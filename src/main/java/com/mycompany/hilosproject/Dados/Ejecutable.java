/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hilosproject.Dados;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adryc
 */
public class Ejecutable {

    public static void main(String[] args) {
        
        Thread[] hilos = null;
        Set set;
        Dado d;
        int jugadores=0;
        int caras = 0;
        int tiradas = 0;
        Scanner sc;
        
        while( jugadores <= 0 || jugadores > 4){
            System.out.println("Introduce el número jugadores (máximo 4):");
        try{
            sc = new Scanner(System.in);
            jugadores = sc.nextInt();
            hilos = new Thread[jugadores]; //Inicializamos el array de Threads con el nº de jugadores
        }catch(Exception e){
            System.out.println("Introduzca un número válido");
        }
        }
        
        while( caras <= 0 || caras > 20){
            System.out.println("Introduce el número de caras del dado (máximo 20):");
        try{
            sc = new Scanner(System.in);
            caras = sc.nextInt();
        }catch(Exception e){
            System.out.println("Introduzca un número válido");
        }
        }
        
        while( tiradas <= 0 || tiradas > 20){
            System.out.println("Introduce el número de veces que se lanzará cada dado (máximo 20):");
        try{
            sc = new Scanner(System.in);
            tiradas = sc.nextInt();
        }catch(Exception e){
            System.out.println("Introduzca un número válido");
        }
        }
        
        for(int i = 0; i < jugadores; i++){
            
            System.out.println("------------------------------------");
            d = new Dado(("Jugador "+(i+1)), caras, tiradas);
            set = new Set(d);
            
            hilos[i] = new Thread(set);
            hilos[i].run();
            try {
                Thread.sleep(1000);
            } catch (InterruptedException ex) {
                System.out.println("Error en la ejecución");
            }
            System.out.println("Pasando al siguiente jugador...");
        }
    }
    
    
}
