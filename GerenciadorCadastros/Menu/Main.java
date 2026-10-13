import Implementa.Database;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    private static String sqlUpdate;
    private static String sqlInsert;
    private static String sqlDelete;
    private static String sqlRead;
    private static Connection conexao;

    public static void main(String[] args) throws SQLException {

        conexao = Database.conectar();

        var scanner = new Scanner(System.in);

        sqlUpdate = "update usuarios set Dinheiro =? where ID =?";
        sqlInsert = "insert into usuarios(nome,idade,dinheiro) values (?,?,?)";
        sqlDelete = "Delete from usuarios where id = ?";
        sqlRead = "Select * from usuarios";

        var menu = new Menu();
        menu.mn(conexao, sqlInsert, sqlRead, scanner, sqlDelete, sqlUpdate);

        conexao.close();

    }
}