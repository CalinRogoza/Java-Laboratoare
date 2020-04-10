package compulsory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Database {
    private static Database database = null;
    Connection connection = null;

    private Database() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "dbajava", "sql");
        } catch (Exception exception) {
            System.out.println(exception);
        }
    }

    public static Database getInstance() {
        if (database == null)
            database = new Database();
        return database;
    }

    public Connection getConnection() {
        return connection;
    }
}
