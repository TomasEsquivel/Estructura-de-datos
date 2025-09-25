package com.ed.lewischase.tp.tp02;

import com.ed.lewischase.stack.EmptyStackException;
import com.ed.lewischase.stack.LinkedStack;

public class ejercicio07 {
    public static void main(String[] args) {
        LinkedStack<Integer> pilaDeNumeros = new LinkedStack<>();

        //push(elemento)
        pilaDeNumeros.push(1);
        pilaDeNumeros.push(2);
        pilaDeNumeros.push(3);
        pilaDeNumeros.push(4);
        pilaDeNumeros.push(5);

        //pop()
        try {
            int elemBorrado = pilaDeNumeros.pop();
            System.out.println("Elemento borrado = " + elemBorrado);
        } catch (EmptyStackException e) {
            throw new RuntimeException(e);
        }

        //peek()
        try {
            int primerElem = pilaDeNumeros.peek();
            System.out.println("Elemento borrado = " + primerElem);
        } catch (EmptyStackException e) {
            throw new RuntimeException(e);
        }

        //isEmpty()
        if(pilaDeNumeros.isEmpty())
            System.out.println("La pila está vacía");
        else
            System.out.println("La pila tiene elementos");

        System.out.println("El stack tiene " + pilaDeNumeros.size() + "elementos");

        //toString()
        String imprimirStack = pilaDeNumeros.toString();
        System.out.println(imprimirStack);
    }
}
