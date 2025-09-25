package com.ed.lewischase.BinaryTree;
import com.ed.lewischase.LinkedNode.BinaryTreeNode;

public class LinkedBinarySearchTree<T> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {

    /**
     * Constructor
     */
    public LinkedBinarySearchTree(){
        super();
    }
    /**
     * Constructor
     */
    public LinkedBinarySearchTree(T element){
        super(element);
    }
    
    @Override
    public void addElement(T element) {
        BinaryTreeNode<T> temp = new BinaryTreeNode<T>(element);
        Comparable<T> comparableElement = (Comparable<T>)element;
        
        if(isEmpty()) root = temp;
        else{
            BinaryTreeNode<T> current = root;
            boolean added = false;
            
            while(!added){
                if(comparableElement.compareTo(current.getElement()) < 0){
                    if(current.getLeft() == null){
                        current.setLeft(temp);
                        added = true;
                    }
                    else current = current.getLeft();
                }
                else{
                    if(current.getRight() == null){
                        current.setRight(temp);
                        added = true;
                    }
                    else current = current.getRight();
                }
            }//while
        }
        count++;
    }

    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException{
        T result = null;
        Comparable<T> comparableElement = (Comparable<T>) targetElement;
        
        if(!isEmpty())
            if(comparableElement.compareTo(root.getElement()) == 0){
                result = root.getElement();
                root = replacement(root);
                count--;
            }
            else{
                BinaryTreeNode<T> current = null, parent = root;
                boolean found = false;
                
                if(comparableElement.compareTo(root.getElement()) < 0) current = root.getLeft();
                else current = root.getRight();
                
                while(current != null && !found){
                    if(comparableElement.compareTo(current.getElement()) == 0){
                        found = true;
                        count--;
                        result = current.getElement();
                        
                        if(current == parent.getLeft()) parent.setLeft(replacement(current));
                        else parent.setRight(replacement(current));
                    }
                    else{
                        parent = current;
                        if(comparableElement.compareTo(current.getElement()) < 0) current = current.getLeft();
                        else current = current.getRight();
                    }
                }//while
                
                if(!found) throw new ElementNotFoundException(targetElement.toString());
            }
        return result;
    }
    
    protected BinaryTreeNode<T> replacement(BinaryTreeNode<T> node){
        BinaryTreeNode<T> result = null;
        
        if(node.getLeft() == null && node.getRight() == null) result = null;
        else if(node.getLeft() != null && node.getRight() == null) result = node.getLeft();
        else if(node.getLeft() == null && node.getRight() != null) result = node.getRight();
        else{
            BinaryTreeNode<T> current = node.getRight();
            BinaryTreeNode<T> parent = node;
            
            while(current.getLeft() != null){
                parent = current;
                current = current.getLeft();
            }
            
            if(node.getRight() == current) current.setLeft(node.getLeft());
            else{
                parent.setLeft(current.getRight());
                current.setRight(node.getRight());
                current.setLeft(node.getLeft());
            }
            
            result = current;
        }
        return result;
    }

    @Override
    public void removeAllOcurrences(T targetElement) throws ElementNotFoundException{
        removeElement(targetElement);
        
        while(contains(targetElement)) removeElement(targetElement);
    }

    @Override
    public T removeMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T removeMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T findMin() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public T findMax() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
}
