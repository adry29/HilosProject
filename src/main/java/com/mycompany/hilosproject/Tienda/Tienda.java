/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hilosproject.Tienda;

import java.sql.SQLException;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adryc
 */
public class Tienda {

    private int productos = 0;
    dao d;

    /*
    Función empleada por el consumidor.
    Esta tratará de sacar un número aleatorio entre 1 y 4 productos de la tienda (el productor)
    Si dicha cantidad no está disponible, se mantendrá a la espera de que el productor la reponga.
    En todo momento se actualiza la BBDD
    */
    public synchronized int buy() throws SQLException {

        d = new dao();
        this.productos = d.getProductos();
        Random r = new Random();
        int numero = r.nextInt(4) + 1;
        d.updateClient(numero);
        System.out.println("Cliente quiere comprar "+numero+" productos. Productos disponibles: "+productos);
        
        while (d.getProductos() < numero) {
            try {
                System.out.println("Productos insuficientes, cliente pasa a la espera");
                notifyAll();
                wait();
            } catch (InterruptedException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }

        productos = productos - numero;
        d.updateShop(productos);
        System.out.println("Cliente ha comprado " + numero + " productos, productos restantes: " + productos);
        notifyAll();
        

        
        return numero;

    }

    /*
    Función empleada por el productor.
    Esta  repondrá una cantidad aleatoria de productos entre 1 y 4.
    En todo momento se actualiza la BBDD
    */
    public synchronized void produce() throws SQLException {
        
        dao d = new dao();
        this.productos = d.getProductos();
        while(d.getProductos() > d.getCompra()){
            try {
                wait();
            } catch (InterruptedException ex) {
                Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        Random r = new Random();
        int numero = r.nextInt(4) + 1;
        productos = productos + numero;
        d.updateShop(productos);
        System.out.println("------------------------------------------------------------------------------");
        System.out.println("Se han repuesto " + numero + " productos.");
        notify();
        System.out.println("------------------------------------------------------------------------------");
        try {
            Thread.sleep(4000);
        } catch (InterruptedException ex) {
            Logger.getLogger(Tienda.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
