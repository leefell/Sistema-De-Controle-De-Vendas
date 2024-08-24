# Sistema de Controle de Vendas

Este é um sistema de controle de vendas desenvolvido em Java, utilizando o padrão de arquitetura MVC (Model-View-Controller). O sistema permite gerenciar clientes, fornecedores, funcionários, produtos e vendas, proporcionando uma solução completa para o controle de operações comerciais.

## Sumário

- [Recursos](#recursos)
- [Pré-requisitos](#pré-requisitos)
- [Instalação](#instalação)
- [Configuração do Banco de Dados](#configuração-do-banco-de-dados)
- [Configuração do Usuário Administrador](#configuração-do-usuário-administrador)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Funcionalidades](#funcionalidades)
- [Como Usar](#como-usar)

## Recursos

- Gerenciamento completo de **clientes**, **fornecedores**, **funcionários**, **produtos** e **vendas**.
- Interface gráfica amigável desenvolvida em Java Swing.
- Organização baseada no padrão MVC para separar a lógica de negócios da interface do usuário.
- Atualização automática do estoque com base nas vendas realizadas.

## Pré-requisitos

Antes de começar, certifique-se de ter os seguintes requisitos instalados:

- [Java JDK 8+](https://www.oracle.com/java/technologies/javase-jdk8-downloads.html)
- [PostgreSQL](https://www.postgresql.org/download/)

## Instalação

1. Clone este repositório para o seu ambiente local:

    ```bash
    git clone https://github.com/leefell/Sistema-Loja-Controle-De-Vendas.git
    cd Sistema-Loja-Controle-De-Vendas
    ```

2. Configure a classe `ConexaoDAO` com as credenciais do seu banco de dados PostgreSQL.

## Configuração do Banco de Dados

1. Abra a classe `ConexaoDAO` e configure os parâmetros de conexão com o seu banco de dados PostgreSQL.

2. Certifique-se de que o servidor PostgreSQL esteja rodando e acessível.

## Configuração do Usuário Administrador

Para configurar o usuário administrador, siga os passos abaixo:

1. **Modifique a classe `LoginVIEW`:**
   - Comente o método `main` da classe `LoginVIEW`.
   - Dentro do método `Logar`, remova a instância de `FuncionarioDTO` na linha:
     ```java
     new PrincipalVIEW(funcionarioDTO).setVisible(true);
     ```
   - Substitua por:
     ```java
     new PrincipalVIEW().setVisible(true);
     ```

2. **Ajuste a classe `PrincipalVIEW`:**
   - Descomente o método `main` da classe `PrincipalVIEW`.
   - No construtor da `PrincipalVIEW`, remova todas as instâncias de `FuncionarioDTO`.
   - Comente a verificação `if (funcionarioDTO.getTipo()...)` no construtor da `PrincipalVIEW`.

3. **Execute o sistema para criar um usuário administrador:**
   - Execute o sistema para abrir a `PrincipalVIEW` diretamente.
   - Crie um usuário administrador através da interface.

4. **Reverta as alterações feitas nos passos 1 e 2:**
   - **Na `LoginVIEW`:** 
     - Descomente o método `main`.
     - No método `Logar`, restaure a linha original:
       ```java
       new PrincipalVIEW(funcionarioDTO).setVisible(true);
       ```
   - **Na `PrincipalVIEW`:**
     - Volte a incluir as instâncias de `FuncionarioDTO` no construtor.
     - Descomente a checagem `if (funcionarioDTO.getTipo()...)`.

5. **Login como administrador:**
   - Agora você pode iniciar o sistema normalmente através da `LoginVIEW` e logar utilizando o usuário administrador criado.

## Estrutura do Projeto

O projeto segue a seguinte estrutura:

- **CTR**: Contém as classes de controle (`ClienteCTR`, `FornecedorCTR`, `FuncionarioCTR`, `ProdutoCTR`, `VendaCTR`).
- **DAO**: Contém as classes de acesso a dados (`ClienteDAO`, `ConexaoDAO`, `FornecedorDAO`, `FuncionarioDAO`, `ProdutoDAO`, `VendaDAO`).
- **DTO**: Contém as classes de transferência de dados (`ClienteDTO`, `FornecedorDTO`, `FuncionarioDTO`, `ProdutoDTO`, `VendaDTO`).
- **VIEW**: Contém as classes da interface gráfica (`ClienteVIEW`, `FornecedorVIEW`, `FuncionarioVIEW`, `LoginVIEW`, `PrincipalVIEW`, `ProdutoVIEW`, `VendaVIEW`, `RegistroVIEW`).

## Funcionalidades

- **Clientes**: Gerenciamento completo de clientes (cadastro, consulta, atualização e exclusão).
- **Fornecedores**: Gerenciamento completo de fornecedores (cadastro, consulta, atualização e exclusão).
- **Funcionários**: Gerenciamento completo de funcionários (cadastro, consulta, atualização e exclusão).
- **Produtos**: Gerenciamento completo de produtos (cadastro, consulta, atualização e exclusão).
- **Vendas**: Registro de vendas com atualização automática do estoque e consulta histórica.

## Como Usar

1. Clone o repositório e configure a conexão com o banco de dados conforme descrito em [Instalação](#instalação).
2. Siga as instruções em [Configuração do Usuário Administrador](#configuração-do-usuário-administrador) para configurar o usuário administrador.
3. Utilize a interface gráfica para gerenciar as operações de clientes, fornecedores, funcionários, produtos e vendas.

## Contribuição

Contribuições são bem-vindas! Se você tiver alguma melhoria ou correção a sugerir, por favor, siga os passos abaixo:

1. Fork este repositório.
2. Crie uma branch para a sua feature (`git checkout -b feature/nova-feature`).
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`).
4. Envie para o repositório remoto (`git push origin feature/nova-feature`).
5. Abra um Pull Request.

## Licença

Este projeto é licenciado sob os termos da [MIT License](LICENSE).

## Autor

**Alexandre Augusto dos Santos Feltrin**

Desenvolvido com dedicação e atenção aos detalhes.
