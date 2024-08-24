package br.com.projeto5.dao;

import java.sql.*;
import br.com.projeto5.dto.ClienteDTO;

public class ClienteDAO {
    
    public ClienteDAO() {}

    private ResultSet rs = null;
    private Statement stmt = null;

    // inserirCliente cria um cliente no Banco de Dados.
    public boolean inserirCliente(ClienteDTO clienteDTO) {
        try {
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Insert into cliente (nome_cli, logradouro_cli, numero_cli, email_cli, telefone_cli," 
                    + "bairro_cli, cidade_cli, estado_cli, cep_cli, cpf_cli, rg_cli) values( "
                    + "'" + clienteDTO.getNome_cli() + "', "
                    + "'" + clienteDTO.getLogradouro_cli() + "', "
                    + clienteDTO.getNumero_cli() + ", "
                    + "'" + clienteDTO.getEmail_cli() + "', "
                    + "'" + clienteDTO.getTelefone_cli() + "', "
                    + "'" + clienteDTO.getBairro_cli() + "', "
                    + "'" + clienteDTO.getCidade_cli() + "', "
                    + "'" + clienteDTO.getEstado_cli() + "', "
                    + "'" + clienteDTO.getCep_cli() + "', "
                    + "'" + clienteDTO.getCpf_cli() + "', "
                    + "'" + clienteDTO.getRg_cli() + "') ";
            System.out.println(comando);
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    // consultarCliente permite a visualização de dados de um cliente baseado 
    // em uma opção que é passada como argumento na hora que a função é chamada.
    public ResultSet consultarCliente(ClienteDTO clienteDTO, int opcao) {
        try {
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "";
            
            switch (opcao) {
                case 1:
                    if (clienteDTO.getNome_cli().isEmpty()) {
                        comando = "Select c.* from cliente c order by c.nome_cli";
                    } else {
                        comando = "Select c.* from cliente c where nome_cli like '" + clienteDTO.getNome_cli() + "%' order by c.nome_cli";
                    }
                    break;
                case 2:
                    comando = "Select c.* from cliente c where c.id_cli = " + clienteDTO.getId_cli();
                    break;
                case 3:
                    comando = "Select c.id_cli, c.nome_cli from cliente c";
                    break;
            }
            
            rs = stmt.executeQuery(comando.toUpperCase());
            return rs;
        } catch (Exception e) {
            System.out.println("Erro!" + e.getMessage());
            return rs;
        }
    }

    // alterarCliente altera os dados de um cliente no Banco de Dados.
    public boolean alterarCliente(ClienteDTO clienteDTO) {
        try {
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Update cliente set "
                    + "nome_cli = '" + clienteDTO.getNome_cli() + "', "
                    + "logradouro_cli = '" + clienteDTO.getLogradouro_cli() + "', "
                    + "numero_cli = " + clienteDTO.getNumero_cli() + ", "
                    + "email_cli = '" + clienteDTO.getEmail_cli() + "', "
                    + "telefone_cli = '" + clienteDTO.getTelefone_cli() + "', "
                    + "bairro_cli = '" + clienteDTO.getBairro_cli() + "', "
                    + "cidade_cli = '" + clienteDTO.getCidade_cli() + "', "
                    + "estado_cli = '" + clienteDTO.getEstado_cli() + "', "
                    + "cep_cli = '" + clienteDTO.getCep_cli() + "', "
                    + "cpf_cli = '" + clienteDTO.getCpf_cli() + "', "
                    + "rg_cli = '" + clienteDTO.getRg_cli() + "' "
                    + "where id_cli = " + clienteDTO.getId_cli();
            System.out.println(comando);
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }

    // excluirCliente remove um cliente do Banco de Dados.
    public boolean excluirCliente(ClienteDTO clienteDTO) {
        try {
            ConexaoDAO.ConnectDB();
            stmt = ConexaoDAO.con.createStatement();
            String comando = "Delete from cliente where id_cli = " + clienteDTO.getId_cli();
            System.out.println(comando);
            stmt.execute(comando.toUpperCase());
            ConexaoDAO.con.commit();
            return true;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            return false;
        } finally {
            ConexaoDAO.CloseDB();
        }
    }
}
