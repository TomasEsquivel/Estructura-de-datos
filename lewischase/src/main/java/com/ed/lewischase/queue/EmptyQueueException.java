/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ed.lewischase.queue;

/**
 *
 * @author joserasjido
 */
public class EmptyQueueException extends Exception {
    public EmptyQueueException(){
        System.out.println("Excepcion: La cola se encuentra vacía.");
    }
}
