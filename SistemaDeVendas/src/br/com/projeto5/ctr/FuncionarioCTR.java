package br.com.projeto5.ctr;

import java.sql.ResultSet;
import br.com.projeto5.dto.FuncionarioDTO;
import br.com.projeto5.dao.FuncionarioDAO;
import br.com.projeto5.dao.ConexaoDAO;

public class FuncionarioCTR {

    FuncionarioDAO funcionarioDAO = new FuncionarioDAO();

    public FuncionarioCTR() {

    }

    public String inserirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            // Chama o método que esta na classe DAO aguardando uma resposta ( T ou F )
            if (funcionarioDAO.inserirFuncionario(funcionarioDTO)) {
                return "Funcionario Cadastrado com Sucesso!";
            } else {
                return "Funcionario Não Cadastrado!";
            }

            // Caso tenha algum erro no codigo acima é enviado uma mensagem no console
            // com oque esta acontecendo.
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Funcionario Não Cadastrado.";
        }
    }

    public String alterarFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            // Chama o método que esta na classe DAO aguardando uma resposta ( T ou F )
            if (funcionarioDAO.alterarFuncionario(funcionarioDTO)) {
                return "Funcionario Alterado com Sucesso!";
            } else {
                return "Funcionario Não Alterado!";
            }

            // Caso tenha algum erro no codigo acima é enviado uma mensagem no console
            // com oque esta acontecendo.
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Ocorreu um erro ao tentar alterar o Funcionario!";
        }
    }

    public String excluirFuncionario(FuncionarioDTO funcionarioDTO) {
        try {
            // Chama o método que esta na classe DAO aguardando uma resposta ( T ou F )
            if (funcionarioDAO.excluirFuncionario(funcionarioDTO)) {
                return "Funcionario Excluído com Sucesso!";
            } else {
                return "Funcionario Não Excluído!";
            }

            // Caso tenha algum erro no codigo acima é enviado uma mensagem no console
            // com oque esta acontecendo.
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Ocorreu um erro ao tentar excluir o Funcionario!";
        }
    }

    public ResultSet consultarFuncionario(FuncionarioDTO funcionarioDTO, int opcao) {
        return funcionarioDAO.consultarFuncionario(funcionarioDTO, opcao);
    }

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }

    public String logarFuncionario(FuncionarioDTO funcionarioDTO) {
        return funcionarioDAO.logarFuncionario(funcionarioDTO);
    }

}
