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
public class Contador {
    int numBolas;
    ArrayList<Bola> bolas = new ArrayList();
    private int rojo =0;
    private int azul=0;
	public Contador (int rojo, int azul, int numBolas) {
        this.rojo=rojo;
        this.azul=azul; 
        this.numBolas=numBolas;
        for(Bola b: bolas){
            b = new Bola();
        }
        }
        
        public Contador (int numBolas) { 
        this.numBolas=numBolas;
        for(int i = 0; i < numBolas; i++){
            Bola b = new Bola();
            bolas.add(b);
        }
        }
        
        
	public  void incrementaRojo() {
		rojo++;
	}
        
        
	public void incrementaAzul() {
                azul++;
        }
        
        
        
	public int getRojo() {
            return rojo;
        }
        
        public int getAzul() {
            return azul;
        }
        
        public ArrayList<Bola> getBolas(){
        return this.bolas;
    }

}

