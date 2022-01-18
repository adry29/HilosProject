/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hilosproject.Contador;

import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adryc
 */
public class Ejecutable {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int numero = 0;
        System.out.println("Inserte un número positivo menor que 100");
        while (numero == 0 || numero < 0 || numero > 100) {
            try {
                numero = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Valor no válido");
            }
            if (numero > 100 || numero < 0) {
                System.out.println("Valor no válido");
            }
        }
        
        /*
        Se inicializa el contador y los hilos y se ejecutan ambos hilos
        */
        Contador c = new Contador(numero);
        
        System.out.println("1 para cuenta en paralelo, 2 para cuenta sincronizada");
        while (numero == 0 || numero < 0 || numero > 2) {
            try {
                numero = sc.nextInt();
            } catch (Exception e) {
                System.out.println("Valor no válido");
            }
            if (numero > 2 || numero < 0) {
                System.out.println("Valor no válido");
            }else if(numero==1){
                ContadorAzul cazul = new ContadorAzul(c);
                ContadorRojo crojo = new ContadorRojo(c);
                cazul.start();
                crojo.start();
            }else{
                ContadorAzulSync cazul = new ContadorAzulSync(c);
                ContadorRojoSync crojo = new ContadorRojoSync(c);
                cazul.start();
                crojo.start();
            }
        }

        

    }
}
