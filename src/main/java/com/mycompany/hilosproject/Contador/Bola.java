/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hilosproject.Contador;

import java.util.Random;

/**
 *
 * @author adryc
 */
public class Bola {
    private String color;
    
    public Bola(){
        this.color=randomizer();
    }
    
    //Agrega de forma aleatoria un color a la bola
    public String randomizer(){
        String color;
        Random r = new Random();
        int num = r.nextInt(2)+1;
        if(num==1){
            color="rojo";
        }else{
            color="azul";
        }
        return color;
    }

    public String getColor() {
        return color;
    }
    
    
}
