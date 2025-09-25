/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ed.lewischase.set;

/**
 *
 * @author joserasjido
 */
public class NoSuchElementException extends Exception {
    public NoSuchElementException(){
        System.out.println("Excepción: El elemento especificado no se encuentra en la colección.");
    }
}
