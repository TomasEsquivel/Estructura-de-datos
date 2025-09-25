/**
 * Define la interfaz a una colección general de tipo lista. Los tipos específicos
 * de la lista extenderán esta interfaz para completar el conjunto de operaciones
 * necesarias.
 */
package com.ed.lewischase.list;

import java.util.Iterator;

public interface ListADT<T> {
    //Elimina y devuelve el primer elemento de la lista
    public T removeFirst() throws EmptyListException;
    //Elimina y devuelve el último elemento de la lista
    public T removeLast() throws EmptyListException;
    //Elimina y devuelve el elemento especificado de la lista
    public T remove(T element) throws EmptyListException, ElementNotFoundException;
    //Devuelve una referencia al primer elemento de la lista
    public T first() throws EmptyListException;
    //Devuelve una referencia al ultimo elemento de la lista
    public T last() throws EmptyListException;
    //Devuelve true si esta lista contiene el elemento especificado
    public boolean contains(T target);
    //Devuelve true si esta lista no contiene ningún elemento
    public boolean isEmpty();
    //Devuelve el número de elementos de la lista.
    public int size();
    //Devuelve un iterador para los elementos de la lista
    public Iterator<T> iterator();
    //Devuelve una representación de la lista en forma de cadena de caracteres
    public String toString();
}