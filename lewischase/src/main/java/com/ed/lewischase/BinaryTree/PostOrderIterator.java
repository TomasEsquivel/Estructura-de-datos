package com.ed.lewischase.BinaryTree;

import com.ed.lewischase.LinkedNode.BinaryTreeNode;
import com.ed.lewischase.list.EmptyListException;
import com.ed.lewischase.list.UnorderedList;
import com.ed.lewischase.list.UnorderedListADT;
import com.ed.lewischase.stack.EmptyStackException;
import com.ed.lewischase.stack.LinkedStack;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class PostOrderIterator<T> implements Iterator<T> {
    private LinkedStack<BinaryTreeNode<T>> stack1;
    private LinkedStack<BinaryTreeNode<T>> stack2;

    public PostOrderIterator(BinaryTreeNode<T> root) {
        stack1 = new LinkedStack<>();
        stack2 = new LinkedStack<>();

        if (root != null)
            stack1.push(root);

        while (!stack1.isEmpty()) {
            BinaryTreeNode<T> current;
            try {
                current = stack1.pop();
            } catch (EmptyStackException e) {
                throw new RuntimeException(e);
            }

            stack2.push(current);

            if (current.getLeft() != null)
                stack1.push(current.getLeft());

            if (current.getRight() != null)
                stack1.push(current.getRight());
        }
    }

    @Override
    public boolean hasNext() {
        return !stack2.isEmpty();
    }

    @Override
    public T next() {
        if (!hasNext()) throw new NoSuchElementException();

        BinaryTreeNode<T> node;
        try {
            node = stack2.pop();
        } catch (EmptyStackException e) {
            throw new RuntimeException(e);
        }

        return node.getElement();
    }
}
