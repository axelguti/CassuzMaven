package com.conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexion {

    //private static BasicDataSource pool;
    public static Connection getConexion(){
        /*try{
            String username="Axl";
            String password="1234";
            String url = "jdbc:sqlserver://Axel\\MSSQLSERVER01:1433;" +
                    "database=BDCASSUZ;user="+username+";password="+password+";";
            Connection con=DriverManager.getConnection(url);
            return con;

        }catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }*/

        String url="jdbc:sqlserver://DESKTOP-TT0PJD1\\MSSQLSERVER:1433;" +
                "database=BDCASSUZ;user=Axl;password=1234;";
        try{
            Connection con=DriverManager.getConnection(url);
            return con;

        }catch(SQLException e){
            System.out.println(e.toString());
            return null;
        }
    }
}
