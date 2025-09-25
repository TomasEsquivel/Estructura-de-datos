/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ed.lewischase.stack;

/**
 *
 * @author joserasjido
 */
public class EmptyStackException extends Exception {
    public EmptyStackException(){
        System.out.println("Excepcion: La pila se encuentra vacía.");
    }
}
