# Teste de Aplicação com MySQL e Maven

Projeto Java de teste para validar a conexão e as operações básicas (CRUD) com um banco de dados **MySQL**, usando **Maven** para gerenciar dependências e o build.

## Objetivo

- Testar a conexão de uma aplicação Java com o MySQL via JDBC
- Validar operações de inserção, consulta, atualização e remoção
- Praticar a estrutura de um projeto Maven com dependências externas

## Tecnologias

- Java 17+ (ou a versão que você usa)
- Maven 3.8+
- MySQL 8.x
- MySQL Connector/J (driver JDBC)

## Pré-requisitos

Verifique se tudo está instalado:

```bash
java -version
mvn -version
mysql --version
```

## Configuração do banco de dados

1. Acesse o MySQL:

```bash
mysql -u root -p
```

2. Crie o banco e a tabela de teste:

```sql
CREATE DATABASE IF NOT EXISTS teste_db;
USE teste_db;

CREATE TABLE IF NOT EXISTS usuarios (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    criado_em TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);
```

## Dependência do Maven

No `pom.xml`, adicione o driver do MySQL:

```xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.4.0</version>
</dependency>
```

Para testes automatizados, adicione também o JUnit:

```xml
<dependency>
    <groupId>org.junit.jupiter</groupId>
    <artifactId>junit-jupiter</artifactId>
    <version>5.10.2</version>
    <scope>test</scope>
</dependency>
```

## Configuração da conexão

Ajuste as credenciais na classe de conexão (ou em um arquivo de configuração):

```java
String url = "jdbc:mysql://localhost:3306/teste_db";
String usuario = "root";
String senha = "sua_senha";
```

> **Atenção:** não envie senhas reais para o GitHub. Use variáveis de ambiente ou um arquivo de configuração listado no `.gitignore`.

## Estrutura do projeto

```
projeto/
├── pom.xml
├── README.md
└── src/
    ├── main/java/com/exemplo/
    │   ├── Main.java
    │   ├── ConexaoDB.java
    │   └── UsuarioDAO.java
    └── test/java/com/exemplo/
        └── ConexaoDBTest.java
```

## Como executar

Compilar o projeto:

```bash
mvn clean compile
```

Rodar os testes:

```bash
mvn test
```

Gerar o pacote (`.jar`):

```bash
mvn clean package
```

Executar a aplicação:

```bash
mvn exec:java -Dexec.mainClass="com.exemplo.Main"
```

## O que é testado

| Teste | Descrição | Resultado esperado |
|-------|-----------|--------------------|
| Conexão | Abre conexão com o MySQL | Conexão válida |
| Inserir | Cadastra um usuário | Registro criado |
| Listar | Consulta todos os usuários | Lista retornada |
| Atualizar | Altera dados de um usuário | Registro atualizado |
| Remover | Exclui um usuário | Registro removido |

## Problemas comuns

- **`Communications link failure`**: o MySQL não está rodando ou a porta/host está incorreta.
- **`Access denied for user`**: usuário ou senha incorretos.
- **`Unknown database`**: o banco `teste_db` não foi criado.
- **`ClassNotFoundException: com.mysql.cj.jdbc.Driver`**: a dependência do conector não está no `pom.xml` ou o Maven não baixou as dependências (`mvn clean install`).
- **Erro de timezone**: adicione `?serverTimezone=UTC` à URL de conexão.

## Autor

Desenvolvido para fins de estudo e teste.

## Licença

Uso livre para fins educacionais.
