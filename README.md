# API Vendor List

API que visa guardar e gerenciar lista de vendedores para compradores e empresas.

## 📋 Sumário
- [Visão Geral](#visão-geral)
- [Tecnologias](#tecnologias)
- [Estrutura do Projeto](#estrutura-do-projeto)
- [Configuração](#configuração)
- [Endpoints](#endpoints)
- [Modelos de Dados](#modelos-de-dados)
- [DTOs](#dtos)
- [Tratamento de Erros](#tratamento-de-erros)

---

## 🎯 Visão Geral

A **vendorListAPI** é uma aplicação REST desenvolvida em Spring Boot que permite gerenciar um catálogo de vendedores com suporte a categorias de venda. A API fornece operações CRUD (Create, Read, Update, Delete) para vendedores e categorias, com validação robusta de dados.

**Principais funcionalidades:**
- Criar, listar, buscar, atualizar e deletar vendedores
- Gerenciar categorias de venda
- Validação automática de dados com Bean Validation
- Persistência em banco de dados MySQL
- Tratamento centralizado de exceções

---

## 🛠 Tecnologias

- **Framework Web:** Spring Boot 4.0.0
- **Banco de Dados:** MySQL
- **ORM:** JPA (Jakarta Persistence)
- **Validação:** Bean Validation (jakarta.validation)
- **Build Tool:** Maven
- **Linguagem:** Java 21
- **Utilitários:** Lombok, Spring Boot DevTools
- **Testes:** Spring Boot Test

**Dependências principais:**
```xml
- spring-boot-starter-data-jpa
- spring-boot-starter-web
- spring-boot-starter-validation
- spring-boot-starter-actuator
- mysql-connector-j
- lombok
```

---

## 📁 Estrutura do Projeto

```
vendorListAPI/
├── src/main/java/com/github/jadilson22a/vendorListAPI/
│   ├── Controller/
│   │   ├── VendedorController.java
│   │   └── CategoriaController.java
│   ├── Services/
│   │   ├── VendedorService.java
│   │   └── CategoriaService.java
│   ├── Models/
│   │   ├── Vendedor.java
│   │   └── Categoria.java
│   ├── DTOs/
│   │   ├── VendedorDTO.java
│   │   ├── CategoriaDTO.java
│   │   └── ErroDto.java
│   ├── Repositories/
│   │   ├── VendedorRepository.java
│   │   └── CategoriaRepository.java
│   ├── Enum/
│   │   └── FornecimentoEscopo.java
│   ├── Exceptions/
│   │   └── GlobalExceptionHandler.java
│   └── VendorListApiApplication.java
├── src/main/resources/
│   └── application.properties
├── pom.xml
└── README.md
```

---

## ⚙️ Configuração

### Pré-requisitos
- Java 21+
- Maven 3.6+
- MySQL 8.0+

### Variáveis de Ambiente (application.properties)

Configure o banco de dados MySQL:

```properties
# Conexão MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/vendor_db
spring.datasource.username=root
spring.datasource.password=sua_senha

# JPA/Hibernate
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.MySQLDialect

# Porta
server.port=8080
```

### Build e Execução

```bash
# Compilar
mvn clean compile

# Executar testes
mvn test

# Executar aplicação
mvn spring-boot:run

# Build JAR
mvn clean package
java -jar target/vendorListAPI-0.0.1-SNAPSHOT.jar
```

---

## 📡 Endpoints

### 🏷️ Vendedor Endpoints

#### 1. Criar Vendedor
```
POST /vendedor
Content-Type: application/json

Body:
{
  "nome": "TechSupply Co",
  "cnpj": "12345678901234",
  "email": "contato@techsupply.com",
  "contato": "+5511999999999",
  "fornecimentoEscopo": "NACIONAL",
  "categoria": {
    "id": 1
  },
  "observacao": "Fornecedor de materiais eletrônicos"
}

Response: 201 Created
{
  "id": 1,
  "nome": "TechSupply Co",
  "cnpj": "12345678901234",
  "email": "contato@techsupply.com",
  "contato": "+5511999999999",
  "fornecimentoEscopo": "NACIONAL",
  "categoria": {
    "id": 1
  },
  "observacao": "Fornecedor de materiais eletrônicos"
}
```

#### 2. Buscar Vendedor por ID
```
GET /vendedor/id/{id}

Example: GET /vendedor/id/1

Response: 200 OK
{
  "id": 1,
  "nome": "TechSupply Co",
  "cnpj": "12345678901234",
  "email": "contato@techsupply.com",
  "contato": "+5511999999999",
  "fornecimentoEscopo": "NACIONAL",
  "categoria": {
    "id": 1
  },
  "observacao": "Fornecedor de materiais eletrônicos"
}
```

#### 3. Buscar Vendedor por Nome
```
GET /vendedor/nome/{nome}

Example: GET /vendedor/nome/TechSupply

Response: 200 OK
[
  {
    "id": 1,
    "nome": "TechSupply Co",
    "cnpj": "12345678901234",
    "email": "contato@techsupply.com",
    "contato": "+5511999999999",
    "fornecimentoEscopo": "NACIONAL",
    "categoria": {
      "id": 1
    },
    "observacao": "Fornecedor de materiais eletrônicos"
  }
]
```

#### 4. Atualizar Vendedor
```
PUT /vendedor/{id}
Content-Type: application/json

Example: PUT /vendedor/1

Body:
{
  "nome": "TechSupply Co Ltd",
  "cnpj": "12345678901234",
  "email": "novo@techsupply.com",
  "contato": "+5511988888888",
  "fornecimentoEscopo": "INTERNACIONAL",
  "categoria": {
    "id": 2
  },
  "observacao": "Atualizado"
}

Response: 201 Created
{
  "id": 1,
  "nome": "TechSupply Co Ltd",
  "cnpj": "12345678901234",
  "email": "novo@techsupply.com",
  "contato": "+5511988888888",
  "fornecimentoEscopo": "INTERNACIONAL",
  "categoria": {
    "id": 2
  },
  "observacao": "Atualizado"
}
```

#### 5. Deletar Vendedor
```
DELETE /vendedor/{id}

Example: DELETE /vendedor/1

Response: 200 OK (sem body)
```

---

### 🏪 Categoria Endpoints

#### 1. Criar Categoria
```
POST /categoria
Content-Type: application/json

Body:
{
  "nome": "Eletrônicos"
}

Response: 201 Created
{
  "id": 1,
  "nome": "Eletrônicos"
}
```

#### 2. Listar Todas as Categorias
```
GET /categoria

Response: 200 OK
[
  {
    "id": 1,
    "nome": "Eletrônicos"
  },
  {
    "id": 2,
    "nome": "Alimentos"
  }
]
```

#### 3. Buscar Categoria por ID
```
GET /categoria/{id}

Example: GET /categoria/1

Response: 200 OK
{
  "id": 1,
  "nome": "Eletrônicos"
}
```

#### 4. Buscar Categoria por Nome
```
GET /categoria/nome/{nome}

Example: GET /categoria/nome/Eletrônicos

Response: 200 OK
{
  "id": 1,
  "nome": "Eletrônicos"
}
```

#### 5. Atualizar Categoria
```
PUT /categoria/{id}
Content-Type: application/json

Example: PUT /categoria/1

Body:
{
  "nome": "Eletrônicos e Informática"
}

Response: 202 Accepted
{
  "id": 1,
  "nome": "Eletrônicos e Informática"
}
```

#### 6. Deletar Categoria por ID
```
DELETE /categoria/{id}

Example: DELETE /categoria/1

Response: 200 OK (sem body)
```

#### 7. Deletar Categoria por Nome
```
DELETE /categoria/nome/{nome}

Example: DELETE /categoria/nome/Eletrônicos

Response: 200 OK (sem body)
```

---

## 📊 Modelos de Dados

### Entidade: Vendedor

```java
@Entity
@Table(name = "vendedor")
public class Vendedor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;              // ID único do vendedor
    
    @Column(name = "nome")
    private String nome;              // Nome do vendedor
    
    @Column(name = "cnpj", length = 14)
    private String cnpj;              // CNPJ (14 dígitos)
    
    @Column(name = "email")
    private String email;             // Email de contato
    
    @Column(name = "contato", precision = 20)
    private String contato;           // Telefone/celular
    
    @Enumerated(EnumType.STRING)
    @Column(name = "fornecimento_escopo")
    private FornecimentoEscopo fornecimentoEscopo;  // Escopo: NACIONAL, INTERNACIONAL, etc.
    
    @ManyToOne
    @JoinColumn(name = "categoria_id")
    private Categoria categoria;      // Categoria do vendedor
    
    @Column(name = "observacao")
    private String observacao;        // Observações adicionais
}
```

**Tabela SQL:**
```sql
CREATE TABLE vendedor (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(255) NOT NULL,
  cnpj VARCHAR(14) UNIQUE NOT NULL,
  email VARCHAR(255),
  contato VARCHAR(20),
  fornecimento_escopo VARCHAR(50),
  categoria_id INT,
  observacao TEXT,
  FOREIGN KEY (categoria_id) REFERENCES categoria_de_venda(id)
);
```

---

### Entidade: Categoria

```java
@Entity
@Table(name = "categoria_de_venda")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;        // ID único da categoria
    
    @Column(name = "nome")
    private String nome;       // Nome da categoria
}
```

**Tabela SQL:**
```sql
CREATE TABLE categoria_de_venda (
  id INT AUTO_INCREMENT PRIMARY KEY,
  nome VARCHAR(255) NOT NULL UNIQUE
);
```

---

### Enum: FornecimentoEscopo

```java
public enum FornecimentoEscopo {
    NACIONAL,
    INTERNACIONAL,
    REGIONAL,
    LOCAL
}
```

---

## 📦 DTOs (Data Transfer Objects)

### VendedorDTO

```java
@Data
@Valid
public class VendedorDTO {
    @NotBlank(message = "Nome é obrigatório")
    private String nome;
    
    @NotBlank(message = "CNPJ é obrigatório")
    @Pattern(regexp = "\\d{14}", message = "CNPJ deve ter exatamente 14 dígitos")
    private String cnpj;
    
    @Email(message = "Email deve ser válido")
    private String email;
    
    private String contato;
    
    @NotNull(message = "Escopo de fornecimento é obrigatório")
    private FornecimentoEscopo fornecimentoEscopo;
    
    private Categoria categoria;
    
    private String observacao;
}
```

---

### CategoriaDTO

```java
@Data
@Valid
public class CategoriaDTO {
    @NotBlank(message = "Nome da categoria é obrigatório")
    private String nome;
}
```

---

### ErroDto

```java
@Data
public class ErroDto {
    private String campo;      // Campo com erro (null se genérico)
    private String mensagem;   // Mensagem de erro
}
```

---

## ⚠️ Tratamento de Erros

A API implementa tratamento centralizado de exceções via `GlobalExceptionHandler`:

### 1. Erros de Validação (400 Bad Request)

```json
{
  "status": 400,
  "titulo": "Parâmetros inválidos",
  "tipo": "ERRO_VALIDACAO",
  "erros": [
    {
      "campo": "nome",
      "mensagem": "Nome é obrigatório"
    },
    {
      "campo": "email",
      "mensagem": "Email deve ser válido"
    }
  ]
}
```

---

### 2. Erros de JSON Inválido (400 Bad Request)

```json
{
  "status": 400,
  "titulo": "JSON inválido ou mal formatado",
  "tipo": "ERRO_JSON",
  "erros": [
    {
      "campo": null,
      "mensagem": "Unexpected character (...)"
    }
  ]
}
```

---

### 3. Erros de Runtime (400 Bad Request)

```json
{
  "status": 400,
  "titulo": "Mensagem da exceção",
  "tipo": "ERRO_GENERICO",
  "erros": [
    {
      "campo": null,
      "mensagem": "Mensagem da exceção"
    }
  ]
}
```

---

### Códigos HTTP Utilizados

| Código | Descrição |
|--------|-----------|
| 200 | OK - Requisição bem-sucedida |
| 201 | Created - Recurso criado com sucesso |
| 202 | Accepted - Requisição aceita para processamento |
| 400 | Bad Request - Erro de validação ou JSON inválido |
| 404 | Not Found - Recurso não encontrado |
| 500 | Internal Server Error - Erro no servidor |

---

## 🔍 Exemplo de Uso (cURL)

### Criar uma Categoria
```bash
curl -X POST http://localhost:8080/categoria \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "Eletrônicos"
  }'
```

### Criar um Vendedor
```bash
curl -X POST http://localhost:8080/vendedor \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "TechSupply Co",
    "cnpj": "12345678901234",
    "email": "contato@techsupply.com",
    "contato": "+5511999999999",
    "fornecimentoEscopo": "NACIONAL",
    "categoria": {
      "id": 1
    },
    "observacao": "Fornecedor de materiais eletrônicos"
  }'
```

### Listar Todas as Categorias
```bash
curl -X GET http://localhost:8080/categoria
```

### Buscar Vendedor por ID
```bash
curl -X GET http://localhost:8080/vendedor/id/1
```

### Atualizar Vendedor
```bash
curl -X PUT http://localhost:8080/vendedor/1 \
  -H "Content-Type: application/json" \
  -d '{
    "nome": "TechSupply Co Ltd",
    "cnpj": "12345678901234",
    "email": "novo@techsupply.com",
    "contato": "+5511988888888",
    "fornecimentoEscopo": "INTERNACIONAL",
    "categoria": {
      "id": 2
    },
    "observacao": "Atualizado"
  }'
```

### Deletar Vendedor
```bash
curl -X DELETE http://localhost:8080/vendedor/1
```

---

## 📚 Referências

- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [Bean Validation](https://beanvalidation.org/)
- [Jakarta Persistence API](https://jakarta.ee/specifications/persistence/)

---

## 📝 Licença

Este projeto é de código aberto. Verifique o arquivo LICENSE para mais detalhes.

---

**Última atualização:** 2026-05-13
