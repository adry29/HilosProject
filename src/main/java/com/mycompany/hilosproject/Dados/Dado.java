/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hilosproject.Dados;

import java.util.Random;

/**
 *
 * @author adryc
 */
public class Dado {
    
    private String jugador;
    private int caras;
    private int resultado;
    private int numTiradas;
    private int suma;
    Random r = new Random();
    
    public Dado(String jugador, int caras, int numTiradas){
        this.caras = caras;
        this.jugador = jugador;
        this.numTiradas = numTiradas;
        this.suma = suma;
    }

    public int getCaras() {
        return caras;
    }

    public int getResultado() {
        return resultado;
    }

    public String getJugador() {
        return jugador;
    }

    
    
    //Realizará un cantidad x de tiradas de un dado con el nº de caras definido.
    //Devolverá la suma de todas estas tiradas
    public synchronized int Tirada() throws InterruptedException{
        int tirada;
        for(int i = numTiradas; i > 0; i--){
            tirada = r.nextInt(caras)+1;
            System.out.println("El "+ this.jugador + " ha sacado " + tirada);
            suma=suma+tirada;
            System.out.println("Suma actual de "+ this.jugador +": "+suma);
            Thread.sleep(1000);
        }
        return suma;
    }
}
    
    

