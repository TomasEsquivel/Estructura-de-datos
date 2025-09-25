package com.ed.lewischase.list;

import com.ed.lewischase.LinkedNode.LinearNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements ListADT{

    protected LinearNode<T> front, rear;
    protected int count;

    public LinkedList(){
        front = rear = null;
        count = 0;
    }

    @Override
    public T removeFirst() throws EmptyListException {
        if(isEmpty()) throw new EmptyListException();

        T elem = front.getElement();

        if (size() == 1) {
            front = rear = null;
        } else {
            front = front.getNext();
        }

        count--;

        return elem;
    }

    @Override
    public T removeLast() throws EmptyListException {
        if(isEmpty()) throw new EmptyListException();

        T elem = rear.getElement();
        if(size() == 1){
            front = rear = null;
        }
        else{
            LinearNode<T> current = front;

            while(current.getNext() != rear){
               current = current.getNext();
            }
            rear = current;
            rear.setNext(null);
        }

        count--;
        return elem;
    }

    @Override
    public Object remove(Object element) throws EmptyListException, ElementNotFoundException {
        if(isEmpty()){
            throw new EmptyListException();
        }
        LinearNode<T> current = front;
        LinearNode<T> previus = null;

        while (current != null && !element.equals(current.getElement())){
            previus = current;
            current = current.getNext();
        }

        if(current == null){
            throw new ElementNotFoundException("Elemento no encontrado");
        }


        if(size() == 1){
            front = rear = null;
        }
        else if(previus == null){
            front = current.getNext();
        }

        else{
            previus.setNext(current.getNext());
            if(previus.getNext() == null){
                rear = previus;
            }
        }


        count--;

        return current.getElement();
    }

    @Override
    public Object first() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException();
        }
        return front.getElement();
    }

    @Override
    public Object last() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException();
        }
        return rear.getElement();
    }

    @Override
    public boolean contains(Object target) {
        Comparable<T> targetComp = (Comparable<T>) target;

        LinearNode<T> current = front;

        while (current != null && (targetComp.compareTo(current.getElement()) != 0)){
            current = current.getNext();
        }

        return current == null;


    }

    @Override
    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public int size() {
        return count;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            LinearNode<T> current = front;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if(!hasNext()) throw new NoSuchElementException();
                T elem = current.getElement();
                current = current.getNext();
                return elem;
            }
        };
    }

    @Override
    public String toString() {
        Iterator<T> iterador = iterator();
        StringBuilder mensaje = new StringBuilder();
        while(iterador.hasNext()){
            mensaje.append(iterador.next().toString()).append("\n");
        }
        return mensaje.toString();
    }
}
