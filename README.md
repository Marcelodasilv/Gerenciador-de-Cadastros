# Cadastros - Sistema de Menu CRUD

Este é um projeto básico em **Java** que implementa as operações fundamentais de um sistema CRUD (Create, Read, Update, Delete) através de uma interface de console/menu. O projeto utiliza o **Maven** para o gerenciamento de dependências.

## Estrutura do Projeto

O projeto está organizado da seguinte forma:

*   **Cadastros/** (Diretório raiz)
    *   **Menu/** (Pacote/Pasta principal do sistema de menu)
        *   `Implementa/` - Pasta destinada às implementações das lógicas de negócio.
        *   `Main.java` - Ponto de entrada do aplicativo (método `main`).
        *   `Menu.java` - Controla a exibição e o fluxo de opções do menu.
        *   `INSERT.java` - Responsável pela criação/inserção de novos registros.
        *   `READ.java` - Responsável pela leitura/exibição de registros.
        *   `UPDATE.java` - Responsável pela atualização de registros existentes.
        *   `DELETE.java` - Responsável pela remoção de registros.
    *   `pom.xml` - Arquivo de configuração do Maven.
    *   `.gitignore` - Arquivo para ignorar arquivos desnecessários no Git.
    *   `README.md` - Documentação do projeto.

## Tecnologias Utilizadas

*   **Java** (Versão recomendada: 17 ou superior)
*   **Maven** (Gerenciador de dependências e build)

## Como Executar o Projeto

### Pré-requisitos
Antes de começar, você vai precisar ter instalado em sua máquina:
*   [Java JDK](https://oracle.com)
*   [Apache Maven](https://apache.org) (ou usar o suporte ao Maven integrado na sua IDE)

### Passo a Passo

1. **Clonar o repositório:**
   ```bash
   git clone https://github.com
   ```

2. **Navegar até a pasta do projeto:**
   ```bash
   cd Cadastros
   ```

3. **Compilar o projeto com o Maven:**
   ```bash
   mvn clean package
   ```

4. **Executar a aplicação:**
   Você pode rodar o projeto diretamente pela sua IDE de preferência (IntelliJ IDEA, Eclipse, VS Code) executando a classe `Main.java`, ou via terminal se tiver o plugin do Maven configurado para execução.
