package com.ed.lewischase.tp.tp02;

import com.ed.lewischase.queue.EmptyQueueException;
import com.ed.lewischase.queue.LinkedQueue;

public class ejercicio08 {
    public static void main(String[] args) {
        LinkedQueue<Integer> cola = new LinkedQueue<>();

        //enqueue()
        cola.enqueue(1);
        cola.enqueue(2);
        cola.enqueue(3);
        cola.enqueue(4);
        cola.enqueue(5);

        //dequeue()
        try {
            int elemEliminado = cola.dequeue();
            System.out.println("Elemento eliminado: " + elemEliminado);
        } catch (EmptyQueueException e) {
            throw new RuntimeException(e);
        }

        //first()
        try {
            int primero = cola.first();
        } catch (EmptyQueueException e) {
            throw new RuntimeException(e);
        }

        //isEmpty()
        if(cola.isEmpty())
            System.out.println("La cola está vacía");

        //size()
        System.out.println("La cola tiene " + cola.size() + "elementos");

        //toString()
        String colaImpresa = cola.toString();
        System.out.println(colaImpresa);
    }
}
