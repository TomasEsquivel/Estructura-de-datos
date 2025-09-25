/**
 * Define la interfaz para una colección de lista indexada. Los elementos se
 * referencian mediante índices numéricos contiguos.
 */
package com.ed.lewischase.list;

public interface IndexedListADT<T> extends ListADT<T> {
    //Inserta el elemento especificado en el índice especificado.
    public void add(int index, T element) throws OutOfRangeException;
    //Configura el elemento situado en el índice especificado.
    public void set(int index, T element) throws EmptyListException, OutOfRangeException;
    //Añade el elemento especificado al final de la lista.
    public void add(T element);
    //Devuelve una referencia al elemento situado en el indice especificado.
    public T get(int index) throws EmptyListException, OutOfRangeException;
    //Devuelve el índice del elemento especificado.
    public int indexOf(T element) throws EmptyListException, ElementNotFoundException;
    //Elimina y devuelve el elemento correspondiente al índice especificado.
    public T remove(int index) throws EmptyListException, OutOfRangeException;
}
