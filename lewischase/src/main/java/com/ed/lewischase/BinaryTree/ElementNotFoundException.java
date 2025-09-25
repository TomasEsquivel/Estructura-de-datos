package com.ed.lewischase.BinaryTree;

/**
 *
 * @author joserasjido
 */
public class ElementNotFoundException extends Exception {
    public ElementNotFoundException(String elem){
        System.out.println("Excepción: No se encontró el elemento '"+elem+"'");
    }
}
