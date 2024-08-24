package br.com.projeto5.dao;

import br.com.projeto5.dto.ClienteDTO;
import br.com.projeto5.dto.VendaDTO;
import java.sql.*;
import java.text.SimpleDateFormat;
import javax.swing.JTable;
import javax.swing.JOptionPane;

public class VendaDAO {

    // ResultSet serve para realizar as consultas no banco de dados.
    private ResultSet rs = null;

    // Manipular o banco de dados.
    Statement stmt = null;
    Statement stmt1 = null;
    Statement stmt2 = null; // Novo statement para atualizar o estoque
    SimpleDateFormat date = new SimpleDateFormat("dd/MM/yyyy");

    public VendaDAO() {

    }

    // inserirVenda cadastra uma venda no Banco de Dados.
    // Possui também uma lógica de estoque, caso o cliente tente comprar mais do que tem no 
    // estoque, um erro é mostrado e a venda é automaticamente cancelada.
    public boolean inserirVenda(VendaDTO vendaDTO, ClienteDTO clienteDTO, JTable produtos) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.con.createStatement();
            stmt1 = ConexaoDAO.con.createStatement();
            stmt2 = ConexaoDAO.con.createStatement(); 

            String comando1 = "Insert into Venda (dat_vend, val_vend, "
                    + "id_cli) values ( "
                    + "to_date('" + date.format(vendaDTO.getDat_vend()) + "', 'DD/MM/YYYY'), "
                    + vendaDTO.getVal_vend() + ", "
                    + clienteDTO.getId_cli() + ")";

            stmt.execute(comando1.toUpperCase(), Statement.RETURN_GENERATED_KEYS);
            rs = stmt.getGeneratedKeys();
            rs.next(); // Obtém a chave gerada

            // Itera sobre a tabela de produtos na venda
            for (int i = 0; i < produtos.getRowCount(); i++) {
                int idProd = Integer.parseInt(produtos.getValueAt(i, 0).toString());
                int qtdVendida = Integer.parseInt(produtos.getValueAt(i, 3).toString());

                // Verifica o quanto de produto tem no estoque
                String consultaEstoque = "Select quantidade_estoque, nome_prod from produto where id_prod = " + idProd;
                ResultSet rsEstoque = stmt2.executeQuery(consultaEstoque);

                if (rsEstoque.next()) {
                    int qtdEstoque = rsEstoque.getInt("quantidade_estoque");
                    String nomeProd = rsEstoque.getString("nome_prod");

                    // Verifica se a quantidade da venda não é maior que o estoque 
                    if (qtdVendida > qtdEstoque) {
                        // Se for, estoura o erro
                        JOptionPane.showMessageDialog(null, "Não é possível vender mais do que a quantidade disponível em estoque.\nProduto: " + nomeProd, "Erro de Estoque", JOptionPane.ERROR_MESSAGE);
                        return false; // Corta a venda
                    }
                } 

                // Insere a venda do produto na tabela 'produto_venda'
                String comando2 = "Insert into produto_venda (id_vend, id_prod, "
                        + "val_prod, qtd_prod) values ( "
                        + rs.getInt(1) + ", " // Obtém o id_vend da chave gerada
                        + idProd + ", "
                        + Double.parseDouble(produtos.getValueAt(i, 2).toString()) + ", "
                        + qtdVendida + "); ";

                stmt1.execute(comando2);

                // Atualiza o estoque do produto após a inserção da venda no Banco
                String comando3 = "Update produto set quantidade_estoque = quantidade_estoque - "
                        + qtdVendida + " where id_prod = " + idProd;

                stmt2.execute(comando3);
            }

            ConexaoDAO.con.commit(); // Confirma a transação

            stmt.close();
            stmt1.close();
            stmt2.close(); 
            rs.close();
            return true;
        } catch (Exception e) {
            System.out.println("Erro na classe VendaDAO! " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB(); 
        }
    }

    // Método para consultar pedidos pelo ID do cliente
    public ResultSet consultarPedidosPorCliente(int id_cli) {
        try {
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "SELECT id_vend, dat_vend, val_vend FROM venda WHERE id_cli = " + id_cli;
            rs = stmt.executeQuery(comando);
            return rs;
        } catch (Exception e) {
            System.out.println("Erro na classe VendaDAO! " + e.getMessage());
            return null;
        }
    }

    // Método para consultar produtos de um pedido pelo ID da venda
    public ResultSet consultarProdutosPorVenda(int id_vend) {
        try {
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "SELECT p.id_prod, p.nome_prod, pv.val_prod, pv.qtd_prod "
                    + "FROM produto p "
                    + "JOIN produto_venda pv ON p.id_prod = pv.id_prod "
                    + "WHERE pv.id_vend = " + id_vend;
            rs = stmt.executeQuery(comando);
            return rs;
        } catch (Exception e) {
            System.out.println("Erro na classe VendaDAO! " + e.getMessage());
            return null;
        }
    }
}
