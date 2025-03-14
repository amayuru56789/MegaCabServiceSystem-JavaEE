package lk.icbt.MegaCityCabSystem.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConfiguration {

    private static DbConfiguration dbConnection = null;
    private Connection connection;

    private DbConfiguration() throws ClassNotFoundException, SQLException {

        Class.forName("com.mysql.cj.jdbc.Driver");
        connection = DriverManager.getConnection(
                "jdbc:mysql://127.0.0.1:3306/cabservicedb",
                "root",
                "1234");

    }

    public static DbConfiguration getInstance() throws SQLException, ClassNotFoundException {
        if (dbConnection==null){
            dbConnection = new DbConfiguration();
        }
        return dbConnection;
    }

    public Connection getConnection(){
        return connection;
    }
}
