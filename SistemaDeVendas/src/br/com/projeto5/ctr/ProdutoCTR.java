package br.com.projeto5.ctr;

import java.sql.ResultSet;
import br.com.projeto5.dto.FornecedorDTO;
import br.com.projeto5.dto.ProdutoDTO;
import br.com.projeto5.dao.ProdutoDAO;
import br.com.projeto5.dao.ConexaoDAO;

public class ProdutoCTR {

    ProdutoDAO produtoDAO = new ProdutoDAO();

    public ProdutoCTR() {

    }

    public String inserirProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO) {
        try {
            if (produtoDAO.inserirProduto(produtoDTO, fornecedorDTO)) {
                return "Produto cadastrado com Sucesso!";
            } else {
                return "Produto NÃO Cadastado!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NÃO Cadastrado";
        }
    }

    public String alterarProduto(ProdutoDTO produtoDTO, FornecedorDTO fornecedorDTO) {
        try {
            if (produtoDAO.alterarProduto(produtoDTO, fornecedorDTO)) {
                return "Produto Alterado com Sucesso!";
            } else {
                return "Produto NÃO Alterado!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NÃO Alterado";
        }
    }

    public String excluirProduto(ProdutoDTO produtoDTO) {
        try {
            if (produtoDAO.excluirProduto(produtoDTO)) {
                return "Produto excluido com Sucesso!";
            } else {
                return "Produto NÃO excluido!";
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return "Produto NÃO Excluido";
        }
    }

    public ResultSet consultarProduto(ProdutoDTO produtoDTO, int opcao) {
        return produtoDAO.consultarProduto(produtoDTO, opcao);
    }

    public void CloseDB() {
        ConexaoDAO.CloseDB();
    }
}
