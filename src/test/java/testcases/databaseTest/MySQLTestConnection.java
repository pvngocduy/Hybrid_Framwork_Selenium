package testcases.databaseTest;

import actions.Utils.MySQL.MySQLConnUtils;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class MySQLTestConnection {
    public static Connection getMyConnection(){
        return MySQLConnUtils.getMySQLConnection();
    }

    public static void main(String[] args) throws SQLException {
        System.out.println("Get connection ...");
        Connection conn = MySQLTestConnection.getMyConnection();
        System.out.println("Open connection: "+conn);
        Statement statement = conn.createStatement();
        String sql = "SELECT * FROM `EMPLOYEE`";
        ResultSet resultSet = statement.executeQuery(sql);
        while (resultSet.next()){
            int emp_int = resultSet.getInt("EMP_ID");
            String first_Name = resultSet.getString("First_name");
            String last_Name = resultSet.getString("Last_name");
            String tilte = resultSet.getString("Title");
            System.out.println(emp_int + "-" + first_Name + " " + last_Name +"-"+ tilte);
        }
        conn.close();
        System.out.println("Closed connection");
    }
}
