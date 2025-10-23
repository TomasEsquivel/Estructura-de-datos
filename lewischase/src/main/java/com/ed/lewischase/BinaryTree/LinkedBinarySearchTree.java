package com.ed.lewischase.BinaryTree;
import com.ed.lewischase.LinkedNode.BinaryTreeNode;

public class LinkedBinarySearchTree<T extends Comparable<T>> extends LinkedBinaryTree<T> implements BinarySearchTreeADT<T> {

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

        if(isEmpty()) root = temp;
        else{
            BinaryTreeNode<T> current = root;
            boolean added = false;
            
            while(!added){
                if(element.compareTo(current.getElement()) < 0){
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
            }
        }
        count++;
    }

    @Override
    public T removeElement(T targetElement) throws ElementNotFoundException{
        T result = null;
        
        if(!isEmpty())
            if(targetElement.compareTo(root.getElement()) == 0){
                result = root.getElement();
                root = replacement(root);
                count--;
            }
            else{
                BinaryTreeNode<T> current = null, parent = root;
                boolean found = false;
                
                if(targetElement.compareTo(root.getElement()) < 0) current = root.getLeft();
                else current = root.getRight();
                
                while(current != null && !found){
                    if(targetElement.compareTo(current.getElement()) == 0){
                        found = true;
                        count--;
                        result = current.getElement();
                        
                        if(current == parent.getLeft()) parent.setLeft(replacement(current));
                        else parent.setRight(replacement(current));
                    }
                    else{
                        parent = current;
                        if(targetElement.compareTo(current.getElement()) < 0) current = current.getLeft();
                        else current = current.getRight();
                    }
                }
                
                if(!found) throw new ElementNotFoundException(targetElement.toString());
            }
        return result;
    }
    
    protected BinaryTreeNode<T> replacement(BinaryTreeNode<T> node){
        BinaryTreeNode<T> result;
        
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
        if(isEmpty())throw new ElementNotFoundException("Árbol vacío: no se puede eliminar el nodo a buscar.");

        PostOrderIterator<T> it = new PostOrderIterator<>(root);
        boolean encontrado = false;

        while (it.hasNext()){
            T current = it.next();

            if(targetElement.compareTo(current) == 0){
                removeElement(current);
                encontrado = true;
            }
        }
        if(!encontrado)throw new ElementNotFoundException("Elemento no encontrado.");
    }

    @Override
    public T removeMin() {
        T elem;
        try {
            elem = removeElement(findMin());
        } catch (ElementNotFoundException e) {
            throw new RuntimeException(e);
        }
        return elem;
    }

    @Override
    public T removeMax() {
        T elem;
        try {
            elem = removeElement(findMax());
        } catch (ElementNotFoundException e) {
            throw new RuntimeException(e);
        }
        return elem;
    }

    @Override
    public T findMin() {
        if(isEmpty()) return null;

        BinaryTreeNode<T> current = root;
        while(current.getLeft() != null){
            current = current.getLeft();
        }
        return current.getElement();
    }

    @Override
    public T findMax() {
        if (isEmpty()) return null;
        BinaryTreeNode<T> current = root;

        while (current.getRight() != null){
            current = current.getRight();
        }
        return current.getElement();
    }
}
