import Implementa.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class UPDATE extends Main implements CRUD {

    public void crud(Connection conexao, String sqlInsert, String sqlRead, Scanner scanner,String sqlDelete, String sqlUpdate) throws SQLException {

        try (PreparedStatement stmtUpdate = conexao.prepareStatement(sqlUpdate)) {
            System.out.println("");

            System.out.print("Você vai atualizar o dinheiro: ");
            var scanDinheiro = scanner.nextInt();
            var limpaBuffer = scanner.nextLine();

            System.out.print("ID do cliente: ");
            var scanID = scanner.nextInt();
            var limpaBuffeer = scanner.nextLine();

            stmtUpdate.setInt(1, scanDinheiro);
            stmtUpdate.setInt(2, scanID);

            var linhasAfetadas = stmtUpdate.executeUpdate();
        }
        System.out.println("");
    }
}