package br.com.projeto5.ctr;

import java.sql.ResultSet;
import br.com.projeto5.dto.ClienteDTO;
import br.com.projeto5.dao.ClienteDAO;
import br.com.projeto5.dao.ConexaoDAO;

public class ClienteCTR {

    ClienteDAO clienteDAO = new ClienteDAO();

    public ClienteCTR() {

    }

    public String inserirCliente(ClienteDTO clienteDTO) {
        try {
            // Chama o método que esta na classe DAO aguardando uma resposta ( T ou F )
            if (clienteDAO.inserirCliente(clienteDTO)) {
                return "Cliente Cadastrado com Sucesso!";
            } else {
                return "Cliente Não Cadastrado!";
            }

            // Caso tenha algum erro no codigo acima é enviado uma mensagem no console
            // com oque esta acontecendo.
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Cliente Não Cadastrado.";
        }
    }

    public String alterarCliente(ClienteDTO clienteDTO) {
        try {
            // Chama o método que esta na classe DAO aguardando uma resposta ( T ou F )
            if (clienteDAO.alterarCliente(clienteDTO)) {
                return "Cliente Alterado com Sucesso!";
            } else {
                return "Cliente Não Alterado!";
            }

            // Caso tenha algum erro no codigo acima é enviado uma mensagem no console
            // com oque esta acontecendo.
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Ocorreu um erro ao tentar alterar o Cliente!";
        }
    }

    public String excluirCliente(ClienteDTO clienteDTO) {
        try {
            // Chama o método que esta na classe DAO aguardando uma resposta ( T ou F )
            if (clienteDAO.excluirCliente(clienteDTO)) {
                return "Cliente Excluído com Sucesso!";
            } else {
                return "Cliente Não Excluído!";
            }

            // Caso tenha algum erro no codigo acima é enviado uma mensagem no console
            // com oque esta acontecendo.
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Ocorreu um erro ao tentar excluir o Cliente!";
        }
    }

    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao) {
        return clienteDAO.consultarCliente(clienteDTO, opcao);
    }

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }

}
