import Implementa.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class INSERT extends Main implements CRUD {

    public void crud(Connection conexao, String sqlInsert, String sqlRead, Scanner scanner, String sqlDelete, String sqlUpdate) throws SQLException {

        System.out.println("");

        try (PreparedStatement stmtInsert = conexao.prepareStatement(sqlInsert)) {

            System.out.print("Nome do Cliente: ");
            var scanNome = scanner.nextLine();

            System.out.print("Idade do Cliente: ");
            int scanIdade = scanner.nextInt();
            var limpaBuffer = scanner.nextLine();

            System.out.print("Dinheiro do Cliente: ");
            var scanDinheiro = scanner.nextInt();
            limpaBuffer = scanner.nextLine();

            stmtInsert.setString(1, scanNome);
            stmtInsert.setInt(2, scanIdade);
            stmtInsert.setInt(3, scanDinheiro);

            var linhasAfetadas = stmtInsert.executeUpdate();

            System.out.println ("");

        }
    }
}