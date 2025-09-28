package com.ed.lewischase.list;


import com.ed.lewischase.LinkedNode.LinearNode;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class IndexedList<T> implements IndexedListADT<T>{
    protected LinearNode<T> front, rear;
    protected int count;

    public IndexedList(){
        front = rear = null;
        count = 0;
    }

    public IndexedList(T elem){
        add(elem);
    }

    @Override
    public void add(int index, T element) throws OutOfRangeException {
            if(index > count){
                throw new OutOfRangeException(index);
            }
            else{
                LinearNode<T> current = front;
                LinearNode<T> previous = null;
                LinearNode<T> elem = new LinearNode<>(element);
                int i = 0;

                if(index != 0){
                    while(i < index){
                        previous = current;
                        current = current.getNext();
                        i++;
                    }

                    elem.setNext(current);
                    previous.setNext(elem);

                    if(index == count){
                        rear = elem;
                    }
                }
                else{
                    elem.setNext(front);
                    front = rear = elem;
                }

                count++;

            }
    }

    @Override
    public void set(int index, T element) throws EmptyListException, OutOfRangeException {
        if(isEmpty()) throw new EmptyListException();

        else if(index < 0 || index >= count)throw new OutOfRangeException(index);

        else {
            LinearNode<T> current = front;
            int i = 0;

            while (i < index){
                current = current.getNext();
                i++;
            }
            current.setElement(element);
        }
    }

    @Override
    public void add(T element) {
            LinearNode<T> elem = new LinearNode<>(element);

            rear.setNext(elem);
            rear = elem;
            count++;

    }

    @Override
    public T get(int index) throws EmptyListException, OutOfRangeException {
        if(isEmpty()) throw new EmptyListException();

        else if(index < 0 || index >= count)throw new OutOfRangeException(index);

        else {
            LinearNode<T> current = front;
            int i = 0;

            while (i < index){
                current = current.getNext();
                i++;
            }
            T elem = current.getElement();
            return elem;
        }
    }

    @Override
    public int indexOf(T element) throws EmptyListException, ElementNotFoundException {
        if(isEmpty())throw new EmptyListException();
        else {
            LinearNode<T> current = front;
            int i = 0;
            while (current != null && !current.getElement().equals(element)){
                current = current.getNext();
                i++;
            }
            if(current == null)throw new ElementNotFoundException("No se encontró el elemento");
            else return i;
        }

    }

    @Override
    public T remove(int index) throws EmptyListException, OutOfRangeException {
        if(isEmpty()) throw new EmptyListException();
        else if(index < 0 || index >= count) throw new OutOfRangeException(index);
        else {
            LinearNode<T> current = front;
            LinearNode<T> previous = null;
            int i = 0;

            if (index == 0) {
                T elem = removeFirst();
                return elem;
            } else if (index == count - 1) {
                T elem = removeLast();
                return elem;
            } else {
                while (i < index) {
                    previous = current;
                    current = current.getNext();
                    i++;
                }
                previous.setNext(current.getNext());
                T elem = current.getElement();
                count--;
                return elem;
            }
        }
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
    public T remove(T element) throws EmptyListException, ElementNotFoundException {
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
    public T first() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException();
        }
        return front.getElement();
    }

    @Override
    public T last() throws EmptyListException {
        if(isEmpty()){
            throw new EmptyListException();
        }
        return rear.getElement();
    }

    @Override
    public boolean contains(T target) {
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
    public Iterator<T> iterator() {
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
}
