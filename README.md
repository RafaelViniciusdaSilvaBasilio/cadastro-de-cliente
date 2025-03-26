# cadastro-de-cliente
minha tarefa é modelar e implementar uma solução completa para a gestão desse cadastro de clientes

# Sistema de Gestão de Clientes e Contatos

Este é um sistema de cadastro e gestão de clientes e seus contatos. A aplicação permite que os usuários cadastrem clientes com informações básicas (nome, CPF, data de nascimento, endereço) e adicionem múltiplos contatos (telefone, e-mail). Além disso, é possível editar, excluir e buscar clientes.

## Estrutura do Projeto

O projeto é dividido em duas partes principais:

### Frontend (Interface do Usuário)
- **Tecnologias Usadas**:
  - **HTML5** 
  - **CSS**
  - **JavaScript** .
  - **jQuery**
  - bootstrap

-

### Backend (Servidor e Banco de Dados)
- **Tecnologias Usadas**:
  - **Java** (Spring Boot).
  - **PostgreSQL**
  - **JPA/Hibernate**



## Dependências

### Backend (Spring Boot)

- **Spring Web**
- **Spring Data JPA**
- **PostgreSQL Driver**
- **Spring Boot DevTools**

### Frontend

- **Bootstrap 5**:
- **jQuery**

## Configurações

### Backend (Spring Boot)

1. **Banco de Dados**:
   PostgreSQL 15 e pgAdmin4
   
   
2. **Arquivo de Configuração**:
   No arquivo `src/main/resources/application.properties`, configure a conexão com o banco de dados PostgreSQL:

   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/clientes_db
   spring.datasource.username=usuario
   spring.datasource.password=senha
   spring.jpa.hibernate.ddl-auto=update
   spring.jpa.properties.hibernate.format_sql=true
   spring.jpa.show-sql=true

###Referencia: 
**https://github.com/githubjdev/crud-completo-com-spring-boot-rest-api  e  https://github.com/alura-cursos/3356-java-screenmatch-web**

### Pré-requisitos

**Java 17+ **

**PostgreSQL (banco de dados)**

**pgAdmin** 

**Maven** 

**IDE: IntelliJ IDEA**

**Spring Initializr (para baixar as dependências)**

###Requisitos:
**implementados ou parcialmente:**
RF01: Cadastro de clientes com os seguintes campos
RF02: O sistema deve permitir a edição dos dados de um cliente cadastrado;
RF03: O sistema deve permitir a exclusão de um cliente cadastrado;
RF04: O sistema deve permitir a listagem de todos os clientes cadastrados;
RF06: O sistema deve permitir o cadastro de contatos para um cliente, contendo os
seguintes dados: Tipo do Contato (Telefone, E-mail), Valor do Contato (número ou email) e Observação;
RN01: Os campos Nome e CPF são obrigatórios no cadastro do cliente;
RN02: Os campos Tipo do Contato e Valor do Contato são obrigatórios no cadastro do
contato;
RN04: O Nome do cliente não pode estar vazio;
O sistema deve validar os dados informados antes de permitir o cadastro ou
edição.

