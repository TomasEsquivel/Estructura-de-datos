package com.ed.lewischase.stack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public interface StackADT<T> {
    //Añade un elemento a la cima de la pila
    public void push(T element);
    //Elimina y devuelve el elemento de la parte superior de la pila
    public T pop() throws EmptyStackException;
    //Devuelve, sin eliminarlo, el elemento de la parte superiord de la pila.
    public T peek() throws EmptyStackException;
    //Devuelve true si esta pila no contiene elementos.
    public boolean isEmpty();
    //Devuelve el número de elementos de la pila
    public int size();
    //Devuelve una representación de la pila en forma de cadena de caracteres.
    public String toString();
    //Devuelve un iterador para el stack
    public Iterator<T> LinkedStackIterator() throws NoSuchElementException;
}
