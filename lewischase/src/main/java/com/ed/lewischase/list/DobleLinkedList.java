package com.ed.lewischase.list;

import com.ed.lewischase.LinkedNode.DoubleNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class DobleLinkedList<T> implements ListADT<T>{

    protected DoubleNode<T> front, rear;
    protected int count;

    public DobleLinkedList(){
        front = rear = null;
        count = 0;
    }

    @Override
    public T removeFirst() throws EmptyListException {
        if(isEmpty()) throw new EmptyListException();
        else {
            T elem = front.getElement();
            if(count == 1) front = rear = null;
            else {
                DoubleNode<T> temp = front.getNext();
                temp.setPrevious(null);
                front.setNext(null);
                front = temp;
            }
            count--;
            return elem;
        }
    }

    @Override
    public T removeLast() throws EmptyListException {
        if(isEmpty()) throw new EmptyListException();
        else {
            T elem = rear.getElement();
            if(count == 1) front = rear = null;
            else {
                DoubleNode<T> temp = rear.getPrevious();
                temp.setNext(null);
                rear.setPrevious(null);
                rear = temp;
            }
            count--;
            return elem;
        }
    }

    @Override
    public T remove(T element) throws EmptyListException, ElementNotFoundException {
        if(isEmpty()) throw new EmptyListException();
        else {
            DoubleNode<T> current = front;

            while (current != null && !current.getElement().equals(element)) {
                current = current.getNext();
            }
            if (current == null) throw new ElementNotFoundException("Elemento no encontrado");
            else if (current.getPrevious() == null) {
                return removeFirst();
            } else if (current.getNext() == null) {
                return removeLast();
            } else {
                //temp va a apuntar al anterior al current.
                DoubleNode<T> temp = current.getPrevious();
                temp.setNext(current.getNext());

                //temp va a apuntar al siguiente de current
                temp = current.getNext();
                temp.setPrevious(current.getPrevious());

                //desvinculo current
                current.setNext(null);
                current.setPrevious(null);

                count--;
                return current.getElement();
            }
        }
    }

    @Override
    public T first() throws EmptyListException {
        if(isEmpty()) throw new EmptyListException();
        else {
            return front.getElement();
        }
    }

    @Override
    public T last() throws EmptyListException {
        if(isEmpty()) throw new EmptyListException();
        else {
            return rear.getElement();
        }
    }

    @Override
    public boolean contains(T target) {
        if(isEmpty()) return false;
        else{
            DoubleNode<T> current = front;
            while (current != null && !current.getElement().equals(target)){
                current = current.getNext();
            }
            return current != null;
        }
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
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            DoubleNode<T> current = front;
            @Override
            public boolean hasNext() {
                return current != null;
            }

            @Override
            public T next() {
                if(!hasNext())throw new NoSuchElementException();
                T elem =  current.getElement();
                current = current.getNext();
                return elem;
            }
        };
    }

    @Override
    public String toString() {
        StringBuilder mensaje = new StringBuilder();
        Iterator<T> iterador = iterator();
        while (iterador.hasNext()){
            mensaje.append(iterador.next().toString()).append("\n");
        }
        return mensaje.toString();
    }
}
