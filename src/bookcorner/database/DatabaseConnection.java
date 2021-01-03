package bookcorner.database;

import java.sql.*;

public class DatabaseConnection {
    Connection connection;
    Statement statement;

    public DatabaseConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        }
        catch (ClassNotFoundException e){
            e.printStackTrace();
        }
    }

    public void connect() {
        try {

            connection = DriverManager.getConnection(
                Environment.connection,Environment.user,Environment.password);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void disconnect(){
        try {
            connection.close();
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


    public void runProcedure(String procedure ){
        String toRun = "Begin " + procedure +"; end;";
        System.out.println(toRun);
        connect();
        try {
            statement = connection.createStatement();
            statement.execute(toRun);
        }
        catch (Exception e){
            e.printStackTrace();
        }
        disconnect();
    }

    public ResultSet runQuery(String query){
        System.out.println(query);
        ResultSet resultSet = null;
        //connect();
        try{
             statement = connection.createStatement();
             resultSet = statement.executeQuery(query);
        }
        catch (SQLException e){
            e.printStackTrace();
        }
       // disconnect();
        return resultSet;
    }


}
