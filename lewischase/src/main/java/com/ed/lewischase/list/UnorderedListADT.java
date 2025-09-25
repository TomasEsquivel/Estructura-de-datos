/**
 * Define la interfaz para una colección de lista desordenada. Los elementos
 * se almacenan en cualquier orden que el usuario desee.
 */
package com.ed.lewischase.list;

public interface UnorderedListADT<T> extends ListADT<T> {
    //Añade el elemento especificado al principio de la lista
    public void addToFront(T element);

    //Añade el elemento especificado al final de la lista.
    public void addToRear(T element);

    //Añade el elemento especificado despues del elemento especificado como
    //objetivo.
    public void addAfter(T element, T target) throws ElementNotFoundException, EmptyListException;
}
