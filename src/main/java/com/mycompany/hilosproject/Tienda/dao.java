/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hilosproject.Tienda;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author adryc
 */
public class dao {
    //Variables necesarias para la conexión
    String dburl="jdbc:mysql://localhost:3306/tienda";
    String dbuser="root";
    String dbpassword="";
    Connection conn;
    Statement stmt;
    
    public dao() throws SQLException{
    }
    
    /*
    Función que crea una tienda en la BBDD (no utilizada al existir ya la tienda)
    */
    public void insertShop() throws SQLException{
        conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
        stmt = conn.createStatement();
        try{
            stmt.executeUpdate("insert into tienda(productos) values ('0');"
            );
        }catch(SQLException e){
            e.printStackTrace();
        }
        conn.close();
    }
    
    /*
    Función que crea un cliente en la BBDD (no utilizada al existir ya el cliente)
    */
    public void insertClient() throws SQLException{
        conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
        stmt = conn.createStatement();
        try{
            stmt.executeUpdate("insert into cliente(compra) values ('"+0+"');"
            );
        }catch(SQLException e){
            e.printStackTrace();
        }
        conn.close();
    }
    
    
    /*
    Actualiza la información (el nº de productos) de la tienda
    sobre la que se trabaja (tienda con id 1 en la BBDD)
    */
    public void updateShop(int num) throws SQLException{
        conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
        stmt = conn.createStatement();
        String query = "update tienda set tienda.productos='"+num+"' where tienda.id='"+1+"';";
        try{
            stmt.executeUpdate(query);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conn.close();
    }
    
    
    /*
    Actualiza la información (el nº de productos) de la tienda
    sobre la que se trabaja (tienda con id 1 en la BBDD)
    */
    public void updateClient(int num) throws SQLException{
        conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
        stmt = conn.createStatement();
        String query = "update cliente set cliente.compra='"+num+"' where cliente.id='"+1+"';";
        try{
            stmt.executeUpdate(query);
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conn.close();
    }
    
    public int getCompra() throws SQLException{
        int result = 0;
        ResultSet rs;
        conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
        stmt = conn.createStatement();
        String query = "select * from cliente where cliente.id='1'";
        try{
            rs = stmt.executeQuery(query);
            while(rs.next()){
                result = rs.getInt(2);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conn.close();
        return result;
    }
    
    public int getProductos() throws SQLException{
        int result = 0;
        ResultSet rs;
        conn = DriverManager.getConnection(dburl, dbuser, dbpassword);
        stmt = conn.createStatement();
        String query = "select * from tienda where tienda.id='1'";
        try{
            rs = stmt.executeQuery(query);
            while(rs.next()){
                result = rs.getInt(2);
            }
        }catch(SQLException ex){
            ex.printStackTrace();
        }
        conn.close();
        return result;
    }
 
}

