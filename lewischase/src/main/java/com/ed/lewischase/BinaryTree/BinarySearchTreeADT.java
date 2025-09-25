package com.ed.lewischase.BinaryTree;

public interface BinarySearchTreeADT<T> extends BinaryTreeADT<T> {
    /**
     * Añade un elemento al árbol
     */
    public void addElement(T element);
    /**
     * Elimina un elemento del árbol
     */
    public T removeElement(T targetElement) throws ElementNotFoundException;
    /**
     * Elimina todas las ocurrencias de un elemento en el árbol.
     */
    public void removeAllOcurrences(T targetElement) throws ElementNotFoundException;
    /**
     * Elimina el elemento mínimo del árbol.
     */
    public T removeMin();
    /**
     * Elimina el elemento máximo del árbol.
     */
    public T removeMax();
    /**
     * Devuelve una referencia al elemento mínimo del árbol.
     */
    public T findMin();
    /**
     * Devuelve una referencia al elemento máximo del árbol.
     */
    public T findMax();
}
