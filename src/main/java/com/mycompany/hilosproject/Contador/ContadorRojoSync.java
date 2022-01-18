/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hilosproject.Contador;

import java.util.ArrayList;

/**
 *
 * @author adryc
 */
public class ContadorRojoSync extends Thread{
	private final Contador cont;
        private ArrayList<Bola> bolas;
	public ContadorRojoSync(Contador c) {
		this.bolas=c.getBolas();
		this.cont=c;
	}
        
        /*
        Se recorre la lista de bolas y se añaden a la suma del contador
        aquellas que sean rojas
        */
        @Override
	public void run() {
		synchronized (cont) {
			for(int i=0;i<bolas.size();i++) {
				if(bolas.get(i).getColor().equals("rojo")){
                                    System.out.println("La bola " + (i+1) + " es roja");
                                    cont.incrementaRojo();
                                }
				try {
					Thread.sleep(1200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		System.out.println("Se han contado en total "+cont.getRojo()+" bolas rojas");
	}


}
