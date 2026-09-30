package Hungry_Hub;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

class DBConnection
{
    private static final String URL = "jdbc:mysql://localhost/food_system";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "tlict2005";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(URL, USERNAME, PASSWORD);
    }

    public static void closeConnection(Connection conn) {
        try {
            if (conn != null) {
                conn.close();
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
