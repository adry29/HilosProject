/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hilosproject.Juego;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author adryc
 */
public class Juego implements Runnable {
    
    /*
    Esta clase creará el método del hilo, el cual tomará los valores introducidos
    por el usuario de limite y objetivo, y cada ronda sumará un número aleatorio
    entre 1 y el valor limite, sumándolos hasta que esta suma alcance el objetivo.
    
    Se contabilizará el número de tiradas (repeticiones del bucle while).
    
    Ganará aquel jugador que necesite menos tiradas para llegar a ese objetivo
    */
    
    private String jugador;
    private int cuenta;
    private int puntos;
    private int numTiradas;
    private int limite;
    private String opcion;
    private int objetivo;
    Random r = new Random();
    
    
    public Juego(){
        jugador="por defecto";
        objetivo = 1;
        cuenta = 0;
    }
    
    //Objetivo es el valor que se debe alcanzar para finalizar la ronda
    //Limite es el número máximo aleatorio que se puede obtener de una tirada
    public Juego(String jugador, int objetivo, int limite){
        this.jugador=jugador;
        this.numTiradas=0;
        cuenta = 0;
        this.objetivo=objetivo;
        this.limite=limite;
    }

    /*
    En cada ronda del bucle se suma un número aleatorio a la suma total del jugador,
    hasta que dicha suma iguale o supere el valor objetivo a alcanzar
    */
    @Override
    public void run() {
        System.out.println("Turno de " + jugador);
        
        while(cuenta < objetivo){
            
            puntos = r.nextInt(limite)+1;
            cuenta = cuenta + puntos;
            numTiradas++;
            System.out.println("Has sacado el número " + puntos + ", cuenta actual: " + cuenta);
            try{
                Thread.sleep(1000);
            }catch(InterruptedException ex){
                System.out.println("Error en el hilo");
            }
        }
        
        System.out.println("Fin del turno de " + jugador + ", número de tiradas: " + numTiradas);
        
    }
    
    public int getNumTiradas(){
        return numTiradas;
    }
    
    public String getJugador(){
        return jugador;
    }
    
    
}
