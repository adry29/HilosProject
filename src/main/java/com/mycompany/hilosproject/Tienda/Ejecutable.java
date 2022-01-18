/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hilosproject.Tienda;

import java.sql.SQLException;

/**
 *
 * @author adryc
 */
public class Ejecutable {
    public static void main(String[] args) throws InterruptedException, SQLException {
		// TODO Auto-generated method stub
                dao d = new dao();
		Tienda t = new Tienda();
		Productor p = new Productor(t);
		Consumidor c = new Consumidor(t);
                p.start();
                c.start();
                
                
		
		

	}
}
