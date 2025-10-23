package com.ed.lewischase.BinaryTree;

import java.util.Iterator;
import com.ed.lewischase.LinkedNode.BinaryTreeNode;
import com.ed.lewischase.list.UnorderedList;

/**
 * Crea un árbol binario vacío.
 * @author Lewis / Chase
 */
public class LinkedBinaryTree<T extends Comparable<T>> implements BinaryTreeADT<T> {
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
        this.root = null;
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
        Comparable<T> targetComp = (Comparable<T>) targetElement;
        BinaryTreeNode<T> aux = this.root;

        while (aux != null && targetComp.compareTo(aux.getElement()) != 0) {
            if (targetComp.compareTo(aux.getElement()) < 0) {
                aux = aux.getLeft();
            } else {
                aux = aux.getRight();
            }

        }
        return aux != null;
    }


    @Override
    public T find(T targetElement) throws ElementNotFoundException{
        Comparable<T> targetComp = (Comparable<T>) targetElement;
        BinaryTreeNode<T> aux = this.root;

        while (aux != null && targetComp.compareTo(aux.getElement()) != 0) {
            if (targetComp.compareTo(aux.getElement()) < 0) {
                aux = aux.getLeft();
            } else {
                aux = aux.getRight();
            }
        }
        if(aux == null)throw new ElementNotFoundException("El elemento no se encontró");

        return aux.getElement();
    }

    //ESTUDIAR MÉTODO
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
        return new inOrderIterator<>(root);
    }

    @Override
    public Iterator<T> iteratorPreOrder() {
        return new PreOrderIterator<>(root);
    }

    @Override
    public Iterator<T> iteratorPostOrder() {
        return new PostOrderIterator<>(root);
    }

    @Override
    public Iterator<T> iteratorLevelOrder() {
        return new LevelOrderIterator<>(root);
    }

    @Override
    public String toString() {
        PreOrderIterator<T> it = new PreOrderIterator<>(root);
        String mensaje = "";
        while(it.hasNext()){
            mensaje += it.next().toString() + " ";
        }
        return mensaje;
    }

    public boolean esAncestro(T v1, T v2) {
        BinaryTreeNode<T> nodo1 = buscarNodo(root, v1);
        if (nodo1 == null)
            return false;

        return contiene(nodo1, v2);
    }

    private BinaryTreeNode<T> buscarNodo(BinaryTreeNode<T> root, T valor) {
        if (root == null)
            return null;

        if (root.getElement().equals(valor))
            return root;

        BinaryTreeNode<T> encontrado = buscarNodo(root.getLeft(), valor);
        if (encontrado == null)
            encontrado = buscarNodo(root.getRight(), valor);

        return encontrado;
    }

    private boolean contiene(BinaryTreeNode<T> root, T valor) {
        if (root == null)
            return false;

        if (root.getElement().equals(valor))
            return true;

        return contiene(root.getLeft(), valor) || contiene(root.getRight(), valor);
    }


    public int contarNodos(BinaryTreeNode<T> nodo) {
        if (nodo == null)
            return 0;
        return 1 + contarNodos(nodo.getLeft()) + contarNodos(nodo.getRight());
    }

    public int maximaProfundidad() {
        return calcularProfundidad(root);
    }

    private int calcularProfundidad(BinaryTreeNode<T> nodo) {
        if (nodo == null) {
            return 0;
        }

        int profIzq = calcularProfundidad(nodo.getLeft());
        int profDer = calcularProfundidad(nodo.getRight());
        int profundidadMayor;

        if (profIzq > profDer)
            profundidadMayor = profIzq;
        else
            profundidadMayor = profDer;

        return 1 + profundidadMayor;
    }

    public boolean equals(LinkedBinaryTree<T> otro) {
        return sonIguales(this.root, otro.root);
    }

    private boolean sonIguales(BinaryTreeNode<T> n1, BinaryTreeNode<T> n2) {
        if (n1 == null && n2 == null) return true;

        if (n1 == null || n2 == null) return false;

        Comparable<T> val1 = n1.getElement();
        T val2 = n2.getElement();

        if (val1.compareTo(val2) != 0) return false;


        return sonIguales(n1.getLeft(), n2.getLeft()) && sonIguales(n1.getRight(), n2.getRight());
    }

    public boolean esEquilibrado() {
        return esEquilibradoNodo(root);
    }

    private boolean esEquilibradoNodo(BinaryTreeNode<T> nodo) {
        if (nodo == null) return true;

        int alturaIzq = altura(nodo.getLeft());
        int alturaDer = altura(nodo.getRight());

        int diferencia;
        if (alturaIzq > alturaDer)
            diferencia = alturaIzq - alturaDer;
        else
            diferencia = alturaDer - alturaIzq;

        if (diferencia > 1)
            return false;

        return esEquilibradoNodo(nodo.getLeft()) && esEquilibradoNodo(nodo.getRight());
    }


    private int altura(BinaryTreeNode<T> nodo) {
        if (nodo == null) return 0;

        int alturaIzq = altura(nodo.getLeft());
        int alturaDer = altura(nodo.getRight());

        if (alturaIzq > alturaDer)
            return alturaIzq + 1;
        else
            return alturaDer + 1;
    }

    public UnorderedList<T> hojas() {
        UnorderedList<T> listaHojas = new UnorderedList<>();
        obtenerHojas(root, listaHojas);
        return listaHojas;
    }

    private void obtenerHojas(BinaryTreeNode<T> nodo, UnorderedList<T> lista) {
        if (nodo == null) return;

        if (nodo.getLeft() == null && nodo.getRight() == null) {
            lista.addToRear(nodo.getElement());
            return;
        }

        obtenerHojas(nodo.getLeft(), lista);
        obtenerHojas(nodo.getRight(), lista);
    }

    public int sumarNodosInternos() {
        return sumarInternos(root);
    }


    private int sumarInternos(BinaryTreeNode<T> nodo) {
        if (nodo == null) return 0;

        if (nodo.getLeft() == null && nodo.getRight() == null) return 0;

        int valor = (Integer) nodo.getElement();
        int sumaIzq = sumarInternos(nodo.getLeft());
        int sumaDer = sumarInternos(nodo.getRight());

        return valor + sumaIzq + sumaDer;
    }





}
