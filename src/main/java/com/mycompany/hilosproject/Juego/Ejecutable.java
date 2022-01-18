/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hilosproject.Juego;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adryc
 */
public class Ejecutable {
    
    private static int max=0;
    private static int limite=0;

    
    
    
    public static void main(String[] args) {

        //Entero que se utilizará como referencia para obtener el resultado más bajo
        int numBajo=1000;
        
        Scanner sc;
        ArrayList<Thread> hilos = new ArrayList<>();
        
        //ArrayList de enteros para almacenar los resultados de los jugadores
        ArrayList<Integer> resultados = new ArrayList<>();
        
        int numJugadores = 0;
        String jugador;
        String ganador="";
        System.out.println("Bienvenido al juego de Count");
        
        while(numJugadores <= 0 || numJugadores > 6){
            numJugadores = 0;
           try{
              sc = new Scanner(System.in);
              System.out.println("Introduzca el número de jugadores (máximo 6)");
              numJugadores = sc.nextInt();
           }catch(Exception e){
               System.out.println("Valor no válido, introduzca otro");
               
           }
        }
        
        while(limite <= 0 || limite > 200){
            
           try{
              sc = new Scanner(System.in);
              System.out.println("Introduzca el objetivo que se debe alcanzar (máximo 200)");
              limite = sc.nextInt();
           }catch(Exception e){
               System.out.println("Valor no válido, introduzca otro");
               limite = 0;
           }
        }
        
        while(max <= 0 || max > 50){
           try{
              sc = new Scanner(System.in);
              System.out.println("Introduzca el número máximo que se podrá obtener en cada tirada (máximo 50)" );
              max = sc.nextInt();
           }catch(Exception e){
               System.out.println("Valor no válido, introduzca otro");
               max = 0;
           }
        }
        
        
        /*
        El bucle for se repetirá por cada jugador, lanzando un hilo en cada vuelta
        y almacenando los resultados del jugador.
        */
        for(int i = 0; i < numJugadores; i++){
            sc = new Scanner(System.in);
            System.out.println("Introduzca nombre para el jugador "+(i+1));
            String nombre = sc.nextLine();
            Juego j = new Juego(nombre, limite, max);
            
            Thread hilo = new Thread(j);
            hilo.run();
            try{
                hilo.join(); //Se detiene la ejecución de cualquier hilo hasta que el juego lanzado finalice
            }catch(InterruptedException ex){
                System.out.println("Error en el hilo");
            }
            
            int resultado = j.getNumTiradas();
            resultados.add(resultado);
            
            /*
            Se compara el resultado obtenido con el resto de resultados.
            Si es más bajo que el resultado menor anterior, se cambia el valor
            del String 'ganador'
            */
            if(resultados.size()>1){
                for(int r : resultados){
                    if(resultado < numBajo){
                        numBajo = resultado;
                        ganador=nombre;
                    }
                }
            }else{
                numBajo = resultado;
                ganador = nombre;
            }
            
        }
        
        System.out.println("El ganador es: " + ganador);
        
    }
}
