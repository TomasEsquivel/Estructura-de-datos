package com.ed.lewischase.stack;

import com.ed.lewischase.LinkedNode.LinearNode;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedStack<T> implements StackADT<T> {
    
    private LinearNode<T> top;
    private int count;
    
    public LinkedStack(){
        top = null;
        count = 0;
    }

    @Override
    /**
     * Añade el elemento especificado a la cima de la pila.
     */
    public void push(T element) {
        LinearNode<T> temp = new LinearNode<T>(element);
        temp.setNext(top);
        top = temp;
        count++;
    }

    @Override
    /**
     * Elimina el elemento situado en la cima de la pila y devuelve una
     * referencia al mismo. Genera una excepción EmptyStackException si la pila está vacía.
     */
    public T pop() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        
        T result = top.getElement();
        top = top.getNext();
        count--;
        return result;
    }

    @Override
    /**
     * Devuelve el elemento situado en la cima de la pila, sin modificar la pila.
     */
    public T peek() throws EmptyStackException{
        if(isEmpty()) throw new EmptyStackException();
        
        return top.getElement();
    }

    @Override
    /**
     * Devuelve true si la pila esta vacia y false en caso contrario.
     */
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    /**
     * Devuelve el numero de elementos que la pila tiene actualmente.
     */
    public int size() {
        return count;
    }

    @Override
    public String toString() {
        String result = "";
        
        LinearNode<T> temp = top;
        while(temp != null){
            result += temp.getElement().toString() + "\n";
            temp = temp.getNext();
        }
            
        return result;
    }

    /***
     * Devuelve un iterador para el Stack
     */
    @Override
    public Iterator<T> LinkedStackIterator() {
        return new Iterator<T>() {
            private LinearNode<T> current = top;

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
