package com.ed.lewischase.LinkedNode;

/**
 * Representa un nodo en un árbol binario, con un hijo izquierdo y otro derecho.
 * @author Lewis / Chase
 */
public class BinaryTreeNode<T> {
    private T element;
    private BinaryTreeNode<T> left, right;
    
    /**
     * Crea un nuevo nodo del árbol con los datos especificados.
     * @param obj Nuevo objeto.
     */
    public BinaryTreeNode(T obj) {
        element = obj;
        left = right = null;
    }
    /****** Getters y Setters ******/
    public T getElement() {
        return element;
    }

    public void setElement(T element) {
        this.element = element;
    }

    public BinaryTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinaryTreeNode<T> left) {
        this.left = left;
    }

    public BinaryTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinaryTreeNode<T> right) {
        this.right = right;
    }
    /**
     * Devuelve el número de hijos no nulos de este nodo.
     * Este método podría escribirse de manera más eficiente.
     * @return 
     */
    public int numChildren(){
        int children = 0;
        if(left != null) children = 1 + left.numChildren();
        if(right != null) children = children + 1 + right.numChildren();
        return children;
    }
}
