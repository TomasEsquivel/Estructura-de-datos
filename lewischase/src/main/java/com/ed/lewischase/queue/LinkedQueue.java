package com.ed.lewischase.queue;

import com.ed.lewischase.LinkedNode.LinearNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedQueue<T> implements QueueADT<T>{
    
    private LinearNode<T> front, rear;
    private int count;
    
    public LinkedQueue(){
        front = rear = null;
        count = 0;
    }

    @Override
    /**
     * Añade el elemento especificado al final de la cola.
     */
    public void enqueue(T element) {
        LinearNode<T> node = new LinearNode<T>(element);
        
        if(isEmpty()) front = node;
        else rear.setNext(node);
        rear = node;
        count++;
    }

    @Override
    /**
     * Elimina el elemento situado al principio de la cola y devuelve una
     * referencia al mismo. Genera EmptyCollectionException si la cola esta
     * vacía.
     */
    public T dequeue() throws EmptyQueueException {
        if(isEmpty()) throw new EmptyQueueException();
        
        T result =  front.getElement();
        front = front.getNext();
        count--;
        
        if(isEmpty()) rear = null;
        
        return result;
    }

    @Override
    /**
     * Devuelve el elemento situado al principio de la cola.
     */
    public T first() throws EmptyQueueException{
        if(isEmpty()) throw new EmptyQueueException();
        
        return front.getElement();
    }

    @Override
    /**
     * Devuelve true si la cola esta vacia y false en caso contrario.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    /**
     * Devuelve el numero de elementos que la cola tiene actualmente.
     */
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        String result = "";
        
        LinearNode<T> temp = front;
        while(temp != null){
            result += temp.getElement().toString() + "\n";
            temp = temp.getNext();
        }
            
        return result;
    }

    /***
     * Devuelve un iterador para la cola
     */
    @Override
    public Iterator<T> LinkedQueueIterator() throws NoSuchElementException {
        return new Iterator<T>() {
            LinearNode<T> current = front;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if(!hasNext()){
                    throw new NoSuchElementException();
                }
                T elemento = current.getElement();
                current = current.getNext();
                return elemento;
            }
        };
    }
}