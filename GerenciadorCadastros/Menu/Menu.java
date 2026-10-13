import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;


public class Menu extends Main{

    public void mn(Connection conexao, String sqlInsert, String sqlRead, Scanner scanner, String sqlDelete, String sqlUpdate) throws SQLException {

        while (true) {
            System.out.println("----- MENU -----");
            System.out.print("Escreva (Sair/Continuar): ");
            var decisao = scanner.nextLine().toLowerCase().trim();

            System.out.println("");

            if (decisao.equals("sair")) {
                System.exit(0);

            } else if (decisao.equals("continuar")) {

                System.out.println("Escreva o que fazer (insert, read, update, delete)");
                System.out.print("R: ");
                var scan = scanner.nextLine().toUpperCase().trim();

                 switch (scan){
                    case "INSERT" -> new INSERT().crud (conexao, sqlInsert, sqlRead, scanner, sqlDelete, sqlUpdate);
                    case "DELETE" -> new DELETE().crud (conexao, sqlInsert, sqlRead, scanner, sqlDelete, sqlUpdate);
                    case "UPDATE" -> new UPDATE().crud (conexao, sqlInsert, sqlRead, scanner, sqlDelete, sqlUpdate);
                    case "READ" -> new READ().crud (conexao, sqlInsert, sqlRead, scanner, sqlDelete, sqlUpdate);
                    default -> System.out.println("ERRO");}

            } else {
                System.out.println("ERRO.");
            }
        }
    }
}