import java.sql.*;

public class DBConnection {
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/dailydose",
                "root",
                "pass123"
            );
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}