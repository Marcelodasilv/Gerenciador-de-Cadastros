package Implementa;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public interface CRUD {

    void crud(Connection conexao, String sqlInsert, String sqlRead, Scanner scanner, String sqlDelete, String sqlUpdate) throws SQLException;
}