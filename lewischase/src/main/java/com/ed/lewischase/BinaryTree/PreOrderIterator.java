package com.ed.lewischase.BinaryTree;

import com.ed.lewischase.LinkedNode.BinaryTreeNode;
import com.ed.lewischase.stack.EmptyStackException;
import com.ed.lewischase.stack.LinkedStack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PreOrderIterator<T> implements Iterator<T> {

    private LinkedStack<BinaryTreeNode<T>> elements;

    public PreOrderIterator(BinaryTreeNode<T> root){
        elements = new LinkedStack<>();
        if(root != null) {
            elements.push(root);
        }
    }


    @Override
    public boolean hasNext() {
        return !elements.isEmpty();
    }

    @Override
    public T next() {
        if(!hasNext()) throw new NoSuchElementException();
        BinaryTreeNode<T> current;
        try{
            current = elements.pop();
        } catch (EmptyStackException e) {
            throw new RuntimeException(e);
        }
        if(current.getRight() != null) elements.push(current.getRight());
        if(current.getLeft() != null) elements.push(current.getLeft());
        return current.getElement();
    }
}
