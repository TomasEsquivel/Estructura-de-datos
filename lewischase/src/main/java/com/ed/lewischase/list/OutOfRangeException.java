package com.ed.lewischase.list;

public class OutOfRangeException extends Exception {
    public OutOfRangeException(int index){
        System.out.println("Excepción: indice fuera de rango ("+index+")");
    }
}
