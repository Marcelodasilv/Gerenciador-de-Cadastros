import Implementa.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DELETE extends Main implements CRUD {

    public void crud(Connection conexao, String sqlInsert, String sqlRead, Scanner scanner, String sqlDelete, String sqlUpdate) throws SQLException {

        try (PreparedStatement stmtDelete = conexao.prepareStatement(sqlDelete)) {

            System.out.println("Escreva o ID para deletar: ");
            var scanID = scanner.nextInt();
            var limpaBuffer = scanner.nextLine();

            stmtDelete.setInt(1, scanID);

            var linhasAfetadas = stmtDelete.executeUpdate();
        }
    }
}