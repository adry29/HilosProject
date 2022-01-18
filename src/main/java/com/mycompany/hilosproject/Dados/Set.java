/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hilosproject.Dados;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adryc
 */
public class Set implements Runnable {

    
    
    private Dado dado;
    private int suma;
    
    public Set(Dado d){
        this.dado = d;
        this.suma=0;
    }
    
    @Override
    public void run() {
        
        try {
            suma = dado.Tirada(); //Realizará la tirada de dados.
            //Al estar sincronizada solo un hilo podrá acceder a ella al mismo tiempo
        } catch (InterruptedException ex) {
            System.out.println("Error en la ejecución del hilo");;
        }
    }
    
}
