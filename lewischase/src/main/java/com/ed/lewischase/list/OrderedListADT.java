/**
 * Define la interfaz para una colección de lista ordenada. Solo se almacenan
 * elementos de tipo Comparable, que se almacenan en el ordern determinado por
 * la relación inherente que exista entre los elementos
 */
package com.ed.lewischase.list;

public interface OrderedListADT <T> extends ListADT<T> {
    //Añade el elemento especificado a la lista, en la ubicación adecuada.
    public void add(T element);
}
