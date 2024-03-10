package com.example.jsf.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class SingleConnection {
    private String user = "avnadmin";
    private String pwd = "AVNS_6pPOrjLYnzjGgSNfBBY";
    private String url = "jdbc:mysql://mysql-38f07ac7-mohaennouass-c7fc.a.aivencloud.com:16211/defaultdb";

      private static Connection connection=null;

    public SingleConnection(){
        try{
            connection= DriverManager.getConnection(url,user,pwd);

        }catch (SQLException e){
            e.printStackTrace();
        }

    }

    public static Connection getConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();

        }
        if(connection == null){
             new SingleConnection();
        }
        return connection;
    }
}
