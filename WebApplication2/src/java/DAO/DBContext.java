package DAO;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.Connection;
import java.sql.DriverManager;


public class DBContext {
    
    /*USE BELOW METHOD FOR YOUR DATABASE CONNECTION FOR BOTH SINGLE AND MULTILPE SQL SERVER INSTANCE(s)*/
    /*DO NOT EDIT THE BELOW METHOD, YOU MUST USE ONLY THIS ONE FOR YOUR DATABASE CONNECTION*/
     public Connection getConnection() throws Exception{        
        String url = "jdbc:mysql://"+serverName+":"+portNumber +
                ";databaseName="+dbName;//+"; integratedSecurity=true";
        Class.forName("com.mysql.cj.jdbc.Driver");         
        return DriverManager.getConnection("jdbc:mysql://database-2.clu4n8uk1rfj.us-east-1.rds.amazonaws.com/MyDBG3?" +
                                   "user="+userID+"&password="+password+"");
//        return DriverManager.getConnection(url);
    }
    
    /*Insert your other code right after this comment*/
   
    /*Change/update information of your database connection, DO NOT change name of instance variables in this class*/
    private final String serverName = "database-2.clu4n8uk1rfj.us-east-1.rds.amazonaws.com";
    private final String dbName = "MyDBG3";
    private final String portNumber = "3306";
    private final String userID = "dung2";
    private final String password = "123456789";

}



class Using{
    public static void main(String[] args) {
        try {
            new DBContext().getConnection();
            System.out.println("thanh cong");
        } catch (Exception e) {
            System.out.println("that bai "+e.getMessage());
        }
    }
}