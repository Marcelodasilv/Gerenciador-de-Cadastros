Gerenciador de Cadastros

Aplicação Java de console para gerenciar cadastros (CRUD) em um banco de dados MySQL, usando JDBC e Maven para gerenciar o build e as dependências.

Este README descreve como configurar o banco, rodar a aplicação e testar cada operação.

Tecnologias
JDK 21 (Temurin)
Maven
MySQL 8.x
mysql-connector-j (driver JDBC, via dependência no pom.xml)
IntelliJ IDEA (opcional, mas é o ambiente de desenvolvimento do projeto)
Estrutura do projeto
GerenciadorCadastros/
├── pom.xml
├── README.md
└── src/main/java/
    ├── Main.java        # ponto de entrada
    ├── Menu.java        # menu interativo no console
    ├── Database.java    # conexão com o MySQL
    ├── Insert.java      # cadastrar
    ├── Read.java        # listar / consultar
    ├── Update.java      # atualizar
    └── Delete.java      # remover
1. Configurar o banco de dados

Abra o MySQL (Workbench ou terminal) e rode:

sql
CREATE DATABASE IF NOT EXISTS gerenciador_cadastros;
USE gerenciador_cadastros;

-- Ajuste as colunas conforme a sua tabela real
CREATE TABLE IF NOT EXISTS cadastros (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(100) NOT NULL,
    email VARCHAR(100)
);
2. Configurar a conexão

Em Database.java, a conexão usa uma URL JDBC, um usuário e uma senha.

java
String url = "jdbc:mysql://localhost:3306/gerenciador_cadastros";
String usuario = System.getenv("DB_USER");
String senha = System.getenv("DB_PASSWORD");

Importante: nunca escreva a senha direto no código que vai para o GitHub. Defina DB_USER e DB_PASSWORD como variáveis de ambiente.

No IntelliJ: Run > Edit Configurations > Environment variables e adicione:

DB_USER=root;DB_PASSWORD=sua_senha
3. Dependência do Maven

O driver do MySQL fica no pom.xml:

xml
<dependency>
    <groupId>com.mysql</groupId>
    <artifactId>mysql-connector-j</artifactId>
    <version>8.4.0</version>
</dependency>

Depois de editar o pom.xml, no IntelliJ clique no ícone de Reload All Maven Projects (aba Maven, à direita) para baixar as dependências.

4. Executar

Pelo IntelliJ (mais simples): abra Main.java e clique no botão verde de Run.

Pelo terminal (opcional):

bash
mvn clean compile
mvn exec:java -Dexec.mainClass="Main"
5. Roteiro de testes manuais

Siga esta ordem usando o menu do console e confira o resultado no MySQL com SELECT * FROM cadastros;.

#	Operação	O que fazer	Resultado esperado
1	Conexão	Rodar a aplicação	Menu aparece, sem erro de conexão
2	Insert	Cadastrar um registro	Mensagem de sucesso e registro na tabela
3	Read	Listar os cadastros	O registro do passo 2 aparece
4	Update	Alterar o nome do registro	Dado atualizado no banco
5	Delete	Remover o registro	Registro some da listagem e do banco
6	Erro	Tentar atualizar/remover um ID que não existe	Mensagem tratada, sem a aplicação quebrar
Problemas comuns
Communications link failure: o serviço do MySQL não está rodando ou a porta está errada.
Access denied for user: usuário ou senha incorretos (confira as variáveis de ambiente).
Unknown database: o banco gerenciador_cadastros ainda não foi criado.
ClassNotFoundException: com.mysql.cj.jdbc.Driver: o Maven não baixou o driver. Recarregue o projeto Maven.
Erro de timezone: adicione ?serverTimezone=UTC no final da URL de conexão.
Autor

Marcelo da Silva Barbosa - GitHub
