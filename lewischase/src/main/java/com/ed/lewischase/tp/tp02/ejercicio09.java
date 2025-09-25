package com.ed.lewischase.tp.tp02;

import com.ed.lewischase.queue.LinkedQueue;
import com.ed.lewischase.stack.LinkedStack;

import java.util.Iterator;

public class ejercicio09 {
    public static void main(String[] args) {
        LinkedStack<Integer> pilaDeNumeros = new LinkedStack<>();


        pilaDeNumeros.push(1);
        pilaDeNumeros.push(2);
        pilaDeNumeros.push(3);
        pilaDeNumeros.push(4);
        pilaDeNumeros.push(5);

        Iterator<Integer> scan = pilaDeNumeros.LinkedStackIterator();
        System.out.println("***** Elementos del Stack *****");
        while(scan.hasNext()){
            System.out.println(scan.next());
        }


        LinkedQueue<Integer> cola = new LinkedQueue<>();
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        cola.enqueue(4);
        cola.enqueue(5);

        Iterator<Integer> scan2 = cola.LinkedQueueIterator();
        System.out.println("***** Elementos de la cola *****");
        while (scan2.hasNext()){
            System.out.println(scan2.next());
        }


    }
}
