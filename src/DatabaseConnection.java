import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public final class DatabaseConnection {
    // final: class tidak bisa diwariskan lagi (penggunaan final)

    private static final String URL = "jdbc:mysql://localhost:3306/vehicle_db";
    private static final String USER = "root";
    private static final String PASSWORD = "";

    // Method return: mengembalikan objek Connection (method return)
    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}
