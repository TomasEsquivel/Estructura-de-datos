package com.ed.lewischase.BinaryTree;

import com.ed.lewischase.LinkedNode.BinaryTreeNode;
import com.ed.lewischase.stack.EmptyStackException;
import com.ed.lewischase.stack.LinkedStack;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class inOrderIterator<T> implements Iterator<T> {

    private LinkedStack<BinaryTreeNode<T>> stack;
    private BinaryTreeNode<T> current;

    public inOrderIterator(BinaryTreeNode<T> root) {
        stack = new LinkedStack<>();
        current = root;
    }

    @Override
    public boolean hasNext() {
        return (current != null || !stack.isEmpty());
    }

    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();

        while(current != null){
            stack.push(current);
            current = current.getLeft();
        }

        BinaryTreeNode<T> node;
        try {
            node = stack.pop();
        } catch (EmptyStackException e) {
            throw new RuntimeException(e);
        }

        T result = node.getElement();
        current = node.getRight();

        return result;
    }
}
