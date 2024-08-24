package br.com.projeto5.dao;

import java.sql.*;
import br.com.projeto5.dto.FornecedorDTO;
import java.text.SimpleDateFormat;

public class FornecedorDAO {

    public FornecedorDAO() {

    }

    SimpleDateFormat data_format = new SimpleDateFormat("dd/MM/yyyy");

    private ResultSet rs = null; // busca no banco 
    private Statement stmt = null; // manipula no banco

    // inserirFornecedor cria um novo fornecedor no Banco de Dados.
    public boolean inserirFornecedor(FornecedorDTO fornecedorDTO) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "Insert into fornecedor (nome_for, cnpj_for, "
                    + "tel_for, email_for, data_cad_for) values ("
                    + "'" + fornecedorDTO.getNome_for() + "', "
                    + "'" + fornecedorDTO.getCnpj_for() + "', "
                    + "'" + fornecedorDTO.getTel_for() + "', "
                    + "'" + fornecedorDTO.getEmail_for() + "', "
                    + "to_date('" + data_format.format(fornecedorDTO.getData_cad_for()) + "', 'dd/MM/yyyy'))";

            stmt.execute(comando.toUpperCase());

            ConexaoDAO.con.commit();
            stmt.close();

            return true;
        } catch (Exception e) {
            System.out.println("Erro disparado em 'FornecedorDAO': " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    // alterarFornecedor altera os dados de um fornecedor no Banco de Dados.
    public boolean alterarFornecedor(FornecedorDTO fornecedorDTO) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "Update fornecedor set "
                    + "nome_for = '" + fornecedorDTO.getNome_for() + "', "
                    + "cnpj_for = '" + fornecedorDTO.getCnpj_for() + "', "
                    + "tel_for = '" + fornecedorDTO.getTel_for() + "', "
                    + "email_for = '" + fornecedorDTO.getEmail_for() + "', "
                    + "data_cad_for = to_date('" + data_format.format(fornecedorDTO.getData_cad_for()) + "', 'dd/MM/yyyy') "
                    + "where id_for = " + fornecedorDTO.getId_for();

            stmt.execute(comando.toUpperCase());

            ConexaoDAO.con.commit();
            stmt.close();

            return true;
        } catch (Exception e) {
            System.out.println("Erro disparado em 'FornecedorDAO': " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    // excluirFornecedor deleta todos os dados de um fornecedor no Banco de Dados.
    public boolean excluirFornecedor(FornecedorDTO fornecedorDTO) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "Delete from fornecedor where id_for = " + fornecedorDTO.getId_for();

            stmt.execute(comando.toUpperCase());

            ConexaoDAO.con.commit();
            stmt.close();

            return true;
        } catch (Exception e) {
            System.out.println("Erro disparado em 'FornecedorDAO': " + e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    // consultarFornecedor busca os dados de um fornecedor no Banco de dados, 
    // baseado em uma opção enviada como argumento na hora da chamada da função.
    public ResultSet consultarFornecedor(FornecedorDTO fornecedorDTO, int opcao) {
        try {
            ConexaoDAO.ConnectDB();

            stmt = ConexaoDAO.con.createStatement();

            String comando = "";

            switch (opcao) {
                case 1:
                    comando = "Select f.id_for, f.nome_for "
                            + "from fornecedor f "
                            + "where f.nome_for ilike '" + fornecedorDTO.getNome_for() + "%' "
                            + "order by f.nome_for";
                    break;
                case 2:
                    comando = "Select f.nome_for, f.cnpj_for, f.tel_for, f.email_for, "
                            + "to_char(f.data_cad_for, 'dd/MM/yyyy') as data_cad_for "
                            + "from fornecedor f "
                            + "where f.id_for = " + fornecedorDTO.getId_for();
                    break;
            }

            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;

        } catch (Exception e) {
            System.out.println("Erro disparado em 'FornecedorDAO': " + e.getMessage());
            return rs;
        }
    }
}
