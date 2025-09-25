package com.ed.lewischase.set;

/**
 *
 * @author joserasjido
 */
public class EmptySetException extends Exception {
    public EmptySetException(){
        System.out.println("Excepción: El conjunto se encuentra vacío.");
    }
}
