package br.com.projeto5.ctr;

import java.sql.ResultSet;
import br.com.projeto5.dao.FornecedorDAO;
import br.com.projeto5.dto.FornecedorDTO;
import br.com.projeto5.dao.ConexaoDAO;

public class FornecedorCTR {

    FornecedorDAO fornecedorDAO = new FornecedorDAO();

    public FornecedorCTR() {
    }

    public String inserirFornecedor(FornecedorDTO fornecedorDTO) {
        try {
            if (fornecedorDAO.inserirFornecedor(fornecedorDTO)) {
                return "Fornecedor cadastrado com sucesso.";
            } else {
                return "ERRO ao cadastrar o fornecedor.";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fornecedor NÃO Cadastrado.";
        }
    }

    public String alterarFornecedor(FornecedorDTO fornecedorDTO) {
        try {
            if (fornecedorDAO.alterarFornecedor(fornecedorDTO)) {
                return "Fornecedor alterado com sucesso.";
            } else {
                return "ERRO ao alterar o fornecedor.";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fornecedor NÃO alterado.";
        }
    }

    public String excluirFornecedor(FornecedorDTO fornecedorDTO) {
        try {
            if (fornecedorDAO.excluirFornecedor(fornecedorDTO)) {
                return "Fornecedor excluido com sucesso.";
            } else {
                return "ERRO ao excluir o fornecedor.";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Fornecedor NÃO excluido.";
        }
    }

    public ResultSet consultarFornecedor(FornecedorDTO fornecedorDTO, int opcao) {
        ResultSet rs = null;

        rs = fornecedorDAO.consultarFornecedor(fornecedorDTO, opcao);
        return rs;
    }

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }
}
