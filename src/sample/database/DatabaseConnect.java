package sample.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnect {
    Connection connection;
    Statement statement;
    ResultSet resultSet;
    DatabaseConnect() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "project", "labnan");
            statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from CUSTOMERS");
            //stmt.execute("insert into CUSTOMERS values ('Labnan',01000100,'Jashore,BD')");
            while (resultSet.next())
                System.out.println(resultSet.getString(1) + "  " + resultSet.getString(2) + "  " + resultSet.getString(3));
            connection.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        new DatabaseConnect();
    }
    }
