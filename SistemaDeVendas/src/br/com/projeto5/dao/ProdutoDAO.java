package br.com.projeto5.dao;

import java.sql.*;
import br.com.projeto5.dto.ProdutoDTO;
import br.com.projeto5.dto.FornecedorDTO;

public class ProdutoDAO {

    public ProdutoDAO() {

    }

    private ResultSet rs = null;
    private Statement stmt = null;

    // inserirProduto adiciona um produto no Banco de Dados.
    public boolean inserirProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "Insert into produto (nome_prod, desc_prod, cod_bar_prod, "
                    + "p_custo_prod, p_venda_prod, quantidade_estoque, id_for) values ( "
                    + "'" + produtoDTO.getNome_prod() + "', "
                    + "'" + produtoDTO.getDesc_prod() + "', "
                    + "'" + produtoDTO.getCod_bar_prod() + "', "
                    + produtoDTO.getP_custo_prod() + ", "
                    + produtoDTO.getP_venda_prod() + ", "
                    + produtoDTO.getQuantidade_estoque() + ","
                    + fornecedorDTO.getId_for() + ") ";

            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();

            return true;
        } catch (Exception e) {
            System.out.println("Erro disparado em produto.DAO " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    // alterarProduto altera os dados de um produto salvo no Banco de Dados.
    public boolean alterarProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "Update produto set "
                    + "nome_prod = '" + produtoDTO.getNome_prod() + "', "
                    + "desc_prod = '" + produtoDTO.getDesc_prod() + "', "
                    + "cod_bar_prod = '" + produtoDTO.getCod_bar_prod() + "', "
                    + "p_custo_prod = '" + produtoDTO.getP_custo_prod() + "', "
                    + "p_venda_prod = '" + produtoDTO.getP_venda_prod() + "', "
                    + "quantidade_estoque = " + produtoDTO.getQuantidade_estoque() + ", "
                    + "id_for = " + fornecedorDTO.getId_for() + " "
                    + "where id_prod = " + produtoDTO.getId_prod();

            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();

            return true;
        } catch (Exception e) {
            System.out.println("Erro disparado em produto.DAO " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    // excluirProduto exclui um Produto do Banco de Dados.
    public boolean excluirProduto(ProdutoDTO produtoDTO) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "Delete from produto where id_prod = " + produtoDTO.getId_prod();

            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            stmt.close();

            return true;
        } catch (Exception e) {
            System.out.println("Erro disparado em produto.DAO " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    // consultarProduto busca os dados de um Produto no Banco de dados, 
    // baseado em uma opção enviada como argumento na hora da chamada da função.
    public ResultSet consultarProduto(ProdutoDTO produtoDTO, int opcao) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "";

            switch (opcao) {
                case 1:
                    comando = "Select p.* "
                            + "from produto p "
                            + "where p.nome_prod ilike '" + produtoDTO.getNome_prod() + "%' "
                            + "order by p.nome_prod";
                    break;
                case 2:
                    comando = "Select p. *, f.nome_for, f.id_for "
                            + "from produto p, fornecedor f "
                            + "where p.id_for = f.id_for and "
                            + "p.id_prod = " + produtoDTO.getId_prod();
                    break;
            }

            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;

        } catch (Exception e) {
            System.out.println("Erro disparado em produto.DAO " + e.getMessage());
            return rs;
        }
    }
}
