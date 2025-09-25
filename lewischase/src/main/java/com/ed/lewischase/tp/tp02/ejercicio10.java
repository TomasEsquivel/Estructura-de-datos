package com.ed.lewischase.tp.tp02;

import com.ed.lewischase.queue.LinkedQueue;
import com.ed.lewischase.stack.LinkedStack;

import java.util.Iterator;

public class ejercicio10 {
    public static void main(String[] args) {
        if(esPalindromo("neuquen"))
            System.out.println("Es palindromo");
        else
            System.out.println("No es palindromo");
    }

    public static boolean esPalindromo(String palabra){
        LinkedStack<Character> pilaTemp = new LinkedStack<>();
        LinkedQueue<Character> colaTemp = new LinkedQueue<>();
        char[] letras = palabra.toCharArray();

        String palabraReverso = "";


        for (char letra: letras){
            colaTemp.enqueue(letra);
        }


        Iterator<Character> scanCola = colaTemp.LinkedQueueIterator();
        while (scanCola.hasNext()){
            pilaTemp.push(scanCola.next());
        }

        Iterator<Character> scanPila = pilaTemp.LinkedStackIterator();
        while (scanPila.hasNext()){
            palabraReverso += scanPila.next();
        }

        return palabra.equals(palabraReverso);
    }
}
