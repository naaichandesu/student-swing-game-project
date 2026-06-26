package tictactoe;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/** TODO */
public class DatabaseManager {
    private static final String DB_HOST = "localhost";
    private static final String DB_PORT = "5433";
    private static final String DB_NAME = "game_project";
    private static final String DB_USER = "postgres";
    private static final String DB_PASSWORD = "naaich4ndesP";
    

    private static final String URL =
            "jdbc:postgresql://" + DB_HOST + ":" + DB_PORT + "/" + DB_NAME;

    

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, DB_USER, DB_PASSWORD);
    }

    public static boolean testConnection() {
        try (Connection conn = getConnection()) {
            return conn != null && !conn.isClosed();
        } catch (SQLException e) {
            System.out.println("Gagal terhubung ke database: " + e.getMessage());
            return false;
        }
    }
}
