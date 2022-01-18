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
public class Productor extends Thread{
		private Tienda t;

		public Productor (Tienda t) {
			this.t = t;
		}
		
                @Override
		public void run() {
                    
			
                        
                            try {
                                //Cada 5 segundos se llamará a la función del productor, de manera repetida hasta que finalice el programa
                                while(0 == 0){
                                    try {
                                        Thread.sleep(5000);
                                    } catch (InterruptedException ex) {
                                        Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                                    }
                                    t.produce();
                                }
                                
                            } catch (SQLException ex) {
                                Logger.getLogger(Productor.class.getName()).log(Level.SEVERE, null, ex);
                            }
				
				
			
		}
}
		
	

