package com.ed.lewischase.list;

/**
 *
 * @author joserasjido
 */
public class EmptyListException extends Exception {
    public EmptyListException(){
        System.out.println("Excepción: la lista se encuentra vacía");
    }
}
