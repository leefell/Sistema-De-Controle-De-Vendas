package br.com.projeto5.ctr;

import br.com.projeto5.dao.ConexaoDAO;
import br.com.projeto5.dao.VendaDAO;
import br.com.projeto5.dto.VendaDTO;
import br.com.projeto5.dto.ClienteDTO;
import java.sql.ResultSet;
import javax.swing.JTable;

public class VendaCTR {

    VendaDAO vendaDAO = new VendaDAO();

    public VendaCTR() {

    }

    public String inserirVenda(VendaDTO vendaDTO, ClienteDTO clienteDTO, JTable produtos) {
        try {
            if (vendaDAO.inserirVenda(vendaDTO, clienteDTO, produtos)) {
                return "Venda cadastrada com sucesso!";
            } else {
                return "Venda não cadastrada!";
            }
        } catch (Exception e) {
            System.out.println("Erro disparado em VendaCTR " + e.getMessage());
            return "Venda NÃO cadastrada!";
        }
    }

    public ResultSet consultarPedidosPorCliente(int id_cli) {
        return vendaDAO.consultarPedidosPorCliente(id_cli);
    }

    public ResultSet consultarProdutosPorVenda(int id_vend) {
        return vendaDAO.consultarProdutosPorVenda(id_vend);
    }

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }
}
