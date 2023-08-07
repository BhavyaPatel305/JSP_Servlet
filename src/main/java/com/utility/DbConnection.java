package com.utility;

import java.sql.Connection;
import java.sql.DriverManager;

public class DbConnection {
    public static Connection getConnection(){
        String driver = "com.mysql.cj.jdbc.Driver";
        String url = "jdbc:mysql://localhost:3306/ADVANCEJAVA";
        String userName = "root";
        String password = "root";

        try{
            // load driver
            Class.forName(driver);

            Connection connection = DriverManager.getConnection(url, userName, password);
            if(connection == null){
                System.out.println("Db not connected");
            }else{
                System.out.println("Db Connected");
                return connection;
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }
    public static void main(String[] args){
        DbConnection dbConnection = new DbConnection();
        dbConnection.getConnection();
    }
}
