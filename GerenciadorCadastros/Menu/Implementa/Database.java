package Implementa;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {

    public static Connection conectar() throws SQLException {

        return DriverManager.getConnection(
                "URL",
                "USER",
                "PASSWORD"
        );
    }
}