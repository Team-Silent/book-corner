package sample.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DatabaseConnection {
    Connection connection;
    Statement statement;
    ResultSet resultSet;

    public DatabaseConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    private void connect() {
        try {

            connection = DriverManager.getConnection(
                    "jdbc:oracle:thin:@localhost:1521:xe", "project", "labnan");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void disconnect(){
        try {
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


    public void runProcedure(String procedureName ){
        connect();
        try {
            statement = connection.createStatement();
            statement.execute("exec " + procedureName + "; \n end/");
        }
        catch (Exception e){
            e.printStackTrace();
        }
        disconnect();
    }


    }
