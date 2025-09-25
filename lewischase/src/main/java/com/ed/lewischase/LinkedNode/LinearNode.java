package com.ed.lewischase.LinkedNode;

public class LinearNode<T> {
    
    private LinearNode<T> next;
    private T element;
    /**
     * Crea un nodo vacío
     */
    public LinearNode(){
        next = null;
        element = null;
    }
    /**
     * Crea un nodo en el que se almacena el elemento especificado.
     */
    public LinearNode(T elem){
        next = null;
        element = elem;
    }
    /**
     * Devuelve el nodo que sigue a este.
     */
    public LinearNode<T> getNext() {
        return next;
    }
    /**
     * Establece el nodo que sigue a este.
     */
    public void setNext(LinearNode<T> next) {
        this.next = next;
    }
    /**
     * Devuelve el elemento almacenado en este nodo.
     */
    public T getElement() {
        return element;
    }
    /**
     * Asigna el elemento que hay que almacenar en este nodo.
     */
    public void setElement(T element) {
        this.element = element;
    }
}