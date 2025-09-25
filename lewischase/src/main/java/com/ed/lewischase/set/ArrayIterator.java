package com.ed.lewischase.set;
import java.util.Iterator;

public class ArrayIterator<T> implements Iterator<T>{
    private int count, current;
    private T[] items;
    
    /**
     * Inicializa el iterador utilizando los elementos especificados.
     */
    public ArrayIterator(T[] collection, int size){
        count = size;
        current = 0;
        items = collection;
    }

    @Override
    /**
     * Devuelve true si el iterador tiene al menos un elemento mas que devolver
     * como parte de la iteración.
     */
    public boolean hasNext() {
        return current < count;
    }

    @Override
    /**
     * Devuelve el siguiente elemento de la iteración.
     */
    public T next(){
        return items[current++];
    }
    
}
