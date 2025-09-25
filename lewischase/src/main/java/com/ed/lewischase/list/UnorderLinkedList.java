package com.ed.lewischase.list;

import com.ed.lewischase.LinkedNode.LinearNode;

import java.util.Iterator;

public class UnorderLinkedList<T> implements UnorderedListADT{
    protected LinearNode<T> front, rear;
    protected int count;

    public UnorderLinkedList(){
        front = rear = null;
        count = 0;
    }

    @Override
    public void addToFront(Object element) {
        LinearNode<Object> nuevoNodo = new LinearNode<>(element);
    }

    @Override
    public void addToRear(Object element) {

    }

    @Override
    public void addAfter(Object element, Object target) throws ElementNotFoundException, EmptyListException {
        if(isEmpty()){
            throw new EmptyListException();
        }

        LinearNode<T> aux = front;

        while (aux != null && !target.equals(element)){
            aux = aux.getNext();
        }

        if(aux == null){
            throw new ElementNotFoundException("Elemento no encontrado");
        }

        LinearNode<T> nuevoNodo = new LinearNode(element);
        nuevoNodo.setNext(aux.getNext());
        aux.setNext(nuevoNodo);

        if(aux == rear){
            rear = nuevoNodo;
        }

        count++;
    }



    @Override
    public Object removeFirst() throws EmptyListException {
        return null;
    }

    @Override
    public Object removeLast() throws EmptyListException {
        return null;
    }

    @Override
    public Object remove(Object element) throws EmptyListException, ElementNotFoundException {
        return null;
    }

    @Override
    public Object first() throws EmptyListException {
        return null;
    }

    @Override
    public Object last() throws EmptyListException {
        return null;
    }

    @Override
    public boolean contains(Object target) {
        return false;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public Iterator iterator() {
        return null;
    }
}
