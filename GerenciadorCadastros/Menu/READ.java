import Implementa.CRUD;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class READ extends Main implements CRUD {

    private ResultSet result;

    public void crud (Connection conexao, String sqlInsert, String sqlRead, Scanner scanner, String sqlDelete, String sqlUpdate) throws SQLException {

        try(PreparedStatement stmtRead = conexao.prepareStatement(sqlRead)){
            result = stmtRead.executeQuery();

            System.out.println("");

            while (result.next()) {

                System.out.println(
                        "Nome: " + result.getString("Nome") + ", " +
                                "Idade: " + result.getInt("Idade") + ", " +
                                "Dinheiro: " + result.getInt("Dinheiro") + ", " +
                                "ID: " + result.getInt("ID"));
            }

            System.out.println("");
        }
    }
}