package com.ed.lewischase.set;
import java.util.Iterator;
import java.util.Set;

public interface SetADT<T> {
    //Añade un elemento a este conjunto, ignorando los duplicados.
    public void add(T element);
    //Elimina y devuelve un elemento aleatorio a este conjunto.
    public T removeRandom() throws EmptySetException;
    //Elimina y devuelve un elemento especifico de este conjunto.
    public T remove(T target) throws EmptySetException, NoSuchElementException;
    //Devuelve la unión de este conjunto y del parámetro.
    public SetADT<T> union(SetADT<T> set);
    //Devuelve true si el conjunto contiene el parámetro.
    public boolean contains(T target);
    //Devuelve tru si este conjunto y el parámetro contienen exaxtamente
    //los mismos elementos.
    public boolean equals(SetADT<T> set) throws EmptySetException, NoSuchElementException;
    //Devuelve true si este conjunto no contiene ningún elemento.
    public boolean isEmpty();
    //Devuelve el número de elementos de este conjunto.
    public int size();
    //Devuelve un iterador para los elementos de este conjunto.
    public Iterator<T> iterator();
    //Devuelve un representación de este cojunto en forma de cadena de caracteres.
    public String toString();

    //Devuelve un conjunto con los elementos que no se encuentren repetidos en el conjunto pasado por parametro
     public SetADT<T> difference(SetADT<T> set);

     //Devuelve un conjunto con los elementos coincidentes con el conjunto pasado por parametro
    public SetADT<T> intersection(SetADT<T> set);

}
