package actions.Utils.MySQL;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class MySQLConnUtils {
    public static Connection getMySQLConnection(){
        String hostName = "localhost";
        String dbName = "automationfc";
        String userName = "root";
        String password = "";
        return getMySQLConnection(hostName, dbName, userName, password);
    }

    private static Connection getMySQLConnection(String hostName, String dbName, String userName, String password) {
        Connection conn = null;
        try {
            String connectionUrl = "jdbc:mysql://"+hostName+":3306/"+dbName;
            conn = DriverManager.getConnection(connectionUrl, userName, password);
        }catch(Exception e){
            e.printStackTrace();
        }
        return conn;
    }
}
