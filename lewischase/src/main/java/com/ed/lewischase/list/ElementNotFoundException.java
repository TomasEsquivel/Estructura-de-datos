package com.ed.lewischase.list;

/**
 *
 * @author joserasjido
 */
public class ElementNotFoundException extends Exception {

    public ElementNotFoundException(String element) {
        System.out.println("Excepcion: elemento no encontrado: "+element);
    }
    
}
