/**
 * Representa un nodo en una estructura doblemente enlazada.
 */
package com.ed.lewischase.LinkedNode;

public class DoubleNode<T> {
    
    private DoubleNode<T> previous, next;
    private T element;
    /**
     * Crea un nodo vacío
     */
    public DoubleNode(){
        previous = next = null;
        element = null;
    }
    /**
     * Crea un nodo en el que se alamacena el elemento especificado.
     */
    public DoubleNode(T elem){
        previous = next = null;
        element = elem;
    }
    /**
     * Devuelve el nodo que precede a este
     */
    public DoubleNode<T> getPrevious() {
        return previous;
    }
    /**
     * Especifica el nodo que precede a este
     */
    public void setPrevious(DoubleNode<T> previous) {
        this.previous = previous;
    }
    /**
     * Devuelve el nodo que sigue a este
     */
    public DoubleNode<T> getNext() {
        return next;
    }
    /**
     * Especifica el nodo que sigue a este
     */
    public void setNext(DoubleNode<T> next) {
        this.next = next;
    }
    /**
     * Devuelve el elemento almacenado en este nodo
     */
    public T getElement() {
        return element;
    }
    /**
     * Especifica el elemento almacenado en este nodo
     */
    public void setElement(T element) {
        this.element = element;
    }
}