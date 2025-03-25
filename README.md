# Projeto MVC Java: CRUD com Banco de Dados Oracle

Beatriz Silva - RM552600 
Pedro Araujo - RM553801
## Descrição
Este projeto é uma aplicação Java que segue o padrão arquitetural MVC (Model-View-Controller) para realizar operações CRUD (Create, Read, Update, Delete) em um banco de dados Oracle. Ele utiliza DTOs (Data Transfer Objects) para transferência de dados entre camadas e Entities para representar as tabelas do banco de dados.

## Tecnologias Utilizadas
- **Java 11 ou superior**
- **Spring Framework** (Spring Boot, Spring Data JPA)
- **Banco de Dados Oracle**
- **Hibernate** (ORM - Mapeamento Objeto-Relacional)
- **Maven** (Gerenciador de dependências)
- **Lombok** (Para reduzir boilerplate code)
- **Postman** ou **Swagger** (para testes de API)

## Funcionalidades
- **Create:** Inserir novos registros no banco de dados.
- **Read:** Buscar registros existentes, com opção de filtragem.
- **Update:** Atualizar dados de registros existentes.
- **Delete:** Remover registros do banco de dados.

## Estrutura do Projeto
A estrutura do projeto segue a divisão clara entre Model, View e Controller:

### 1. **Model**
- **Entities:** Representam as tabelas do banco de dados e utilizam anotações JPA para mapeamento.
- **DTOs:** Objetos que encapsulam os dados transferidos entre as camadas, evitando exposição direta das entities.

### 2. **Controller**
- Controladores REST que expõem endpoints para interação com o cliente.

### 3. **Service**
- Camada de serviço que implementa a lógica de negócio e faz a ponte entre o controller e o repositório.

### 4. **Repository**
- Interfaces que herdam de **JpaRepository** para operações com o banco de dados.

## Configuração do Ambiente

### 1. Configurações do Banco de Dados
Certifique-se de que o banco de dados Oracle está configurado e rodando. Atualize as credenciais no arquivo `application.properties`.

### 2. Dependências no `pom.xml`
Inclua as dependências necessárias no arquivo `pom.xml`.

### 3. Execução do Projeto
1. Clone o repositório.
2. Navegue até o diretório do projeto e execute o comando para iniciar o projeto.
3. A aplicação estará disponível em `http://localhost:8080`.

## Exemplos de Endpoints

### 1. Criar um registro
**POST** `/api/v1/entidades`

### 2. Listar todos os registros
**GET** `/api/v1/entidades`

### 3. Atualizar um registro
**PUT** `/api/v1/entidades/{id}`

### 4. Deletar um registro
**DELETE** `/api/v1/entidades/{id}`

## Contribuição
Contribuições são bem-vindas! Siga os passos abaixo:
1. Fork o repositório
2. Crie uma branch com sua feature.
3. Envie suas alterações.
4. Abra um Pull Request

## Licença
Este projeto está licenciado sob a Licença MIT. Consulte o arquivo `LICENSE` para mais informações.

