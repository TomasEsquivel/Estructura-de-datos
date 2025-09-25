package com.ed.lewischase.BinaryTree;

import java.util.Iterator;
import com.ed.lewischase.LinkedNode.BinaryTreeNode;

/**
 * Crea un árbol binario vacío.
 * @author Lewis / Chase
 */
public class LinkedBinaryTree<T> implements BinaryTreeADT<T> {
    protected int count;
    protected BinaryTreeNode<T> root;
    /**
     * Crea un árbol binario vacío.
     */
    public LinkedBinaryTree(){
        count = 0;
        root = null;
    }
    /**
     * Crea un árbol binario con el elemento especificado como raíz.
     * @param element Nuevo elemento.
     */
    public LinkedBinaryTree(T element){
        count = 1;
        root = new BinaryTreeNode<T>(element);
    }
    /**
     * Crea un árbol binario a partir de los dos árboles binarios especificados
     * @param element Nuevo elemento (raiz).
     * @param leftSubtree Subárbol izquierdo.
     * @param rightSubtree Subárbol derecho.
     */
    public LinkedBinaryTree(T element, LinkedBinaryTree<T> leftSubtree, LinkedBinaryTree<T> rightSubtree){
        root = new BinaryTreeNode<T>(element);
        count = 1;
        if(leftSubtree != null){
            root.setLeft(leftSubtree.root);
            count += leftSubtree.size();
            }
        if(rightSubtree != null){
            root.setRight(rightSubtree.root);
            count += rightSubtree.size();
            }
    }

    @Override
    public void removeLeftSubtree() {
        if(root.getLeft() != null) count -= root.getLeft().numChildren() - 1;
        root.setLeft(null);
    }

    @Override
    public void removeRightSubtree() {
        if(root.getRight() != null) count -= root.getRight().numChildren() - 1;
        root.setRight(null);
    }

    @Override
    public void removeAllElements() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
    public boolean contains(T targetElement) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T find(T targetElement) throws ElementNotFoundException{
        BinaryTreeNode<T> current = findAgain(targetElement,root);
        if(current == null) throw new ElementNotFoundException(targetElement.toString());
        return current.getElement();
    }
    
    private BinaryTreeNode<T> findAgain(T targetElement, BinaryTreeNode<T> next){
        if(next == null) return null;
        
        Comparable<T> comp = (Comparable<T>) targetElement;
        if(comp.compareTo(next.getElement()) == 0) return next;
        
        BinaryTreeNode<T> temp = findAgain(targetElement, next.getLeft());
        if(temp == null) temp = findAgain(targetElement, next.getRight());
        
        return temp;
    }

    @Override
    public Iterator<T> iteratorInOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        return super.toString(); //To change body of generated methods, choose Tools | Templates.
    }

}
