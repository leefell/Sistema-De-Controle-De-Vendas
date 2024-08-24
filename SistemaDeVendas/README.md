# Sistema de Controle de Vendas

Este é um sistema de controle de vendas desenvolvido em Java, utilizando o padrão de arquitetura MVC (Model-View-Controller). O sistema permite gerenciar clientes, fornecedores, funcionários, produtos e vendas.

## Configuração do Banco de Dados

1. Configure a classe `ConexaoDAO` com as informações do seu banco de dados PostgreSQL.
2. Certifique-se de que o banco de dados esteja rodando e acessível.

## Configuração do Usuário Administrador

1. Comente o método `main` da classe `LoginVIEW`.
2. Descomente o método `main` da classe `PrincipalVIEW`.
3. Execute o sistema e crie um usuário administrador.
4. Após criar o usuário administrador, descomente o método `main` da classe `LoginVIEW` e comente novamente o método `main` da classe `PrincipalVIEW`.
5. Agora, você pode logar normalmente no sistema utilizando o usuário administrador criado.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

- **CTR**: Contém as classes de controle (`ClienteCTR`, `FornecedorCTR`, `FuncionarioCTR`, `ProdutoCTR`, `VendaCTR`).
- **DAO**: Contém as classes de acesso a dados (`ClienteDAO`, `ConexaoDAO`, `FornecedorDAO`, `FuncionarioDAO`, `ProdutoDAO`, `VendaDAO`).
- **DTO**: Contém as classes de transferência de dados (`ClienteDTO`, `FornecedorDTO`, `FuncionarioDTO`, `ProdutoDTO`, `VendaDTO`).
- **View**: Contém as classes de interface gráfica (`ClienteVIEW`, `FornecedorVIEW`, `FuncionarioVIEW`, `LoginVIEW`, `PrincipalVIEW`, `ProdutoVIEW`, `VendaVIEW`, `RegistroVIEW`).

## Funcionalidades

- **Clientes**: Cadastro, consulta, atualização e exclusão de clientes.
- **Fornecedores**: Cadastro, consulta, atualização e exclusão de fornecedores.
- **Funcionários**: Cadastro, consulta, atualização e exclusão de funcionários.
- **Produtos**: Cadastro, consulta, atualização e exclusão de produtos.
- **Vendas**: Registro e consulta de vendas, com atualização automática do estoque.

## Instruções de Uso

1. Clone o repositório para o seu ambiente local.
2. Configure a classe `ConexaoDAO` com os detalhes do seu banco de dados.
3. Siga as instruções para configurar o usuário administrador.
4. Utilize a interface gráfica para gerenciar clientes, fornecedores, funcionários, produtos e vendas.

---

**Desenvolvido por [Alexandre Augusto dos Santos Feltrin]**
