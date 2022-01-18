/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hilosproject.Tienda;

import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adryc
 */
public class Consumidor extends Thread{
	private Tienda t;

	public Consumidor(Tienda t) {
		this.t = t;
	}
	
        @Override
	public void run() {
		
                
                //Durante 10 rondas irán pasando nuevos clientes para consumir productos de la tienda.
                //Estos clientes no finalizarán hasta haber saciado su demanda, en caso de no poder quedarán a la espera
		for(int i=0; i < 10; i++) {
                  
                try {
                    t.buy();
                } catch (SQLException ex) {
                    Logger.getLogger(Consumidor.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Cliente " + (i + 1) + " completado");
                System.out.println("------------------------------------------------------------------------------");
                try {
                    Thread.sleep(4000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
	}
	
}
