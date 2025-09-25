package com.ed.lewischase.BinaryTree;

/**
 * Define la interfaz para una estructura de datos en árbol binario.
 * @author Lewis / Chase
 */
import java.util.Iterator;

public interface BinaryTreeADT<T> {
    //Debe implementarse para eliminar el subárbol izquierdo de la raíz del árbol binario.
    public void removeLeftSubtree();
    //Debe implementarse para eliminar el subárbol derecho de la raíz del árbol binario.
    public void removeRightSubtree();
    //Debe implementarse para eliminar todos los elementos del árbol binario.
    public void removeAllElements();
    //Debe implementarse para devolver true si el árbol binario está vacío y false en caso contrario.
    public boolean isEmpty();
    //Debe implementarse para devolver el número de elementos del árbol binario.
    public int size();
    //Debe implementarse para devolver true si el árbol binario contiene un elemento que se corresponda con el elemento especificado, y false en caso contrario.
    public boolean contains(T targetElement);
    //Debe implementarse para devolver una referencia al elemento especificado, si se encuentra dentro del arbol binario. Genera una excepcion si el elemento especificado no se encuentra en el arbol.
    public T find(T targetElement) throws ElementNotFoundException;
    //Debe implementarse para devolver la representacion del arbol binario en forma de cadena de caracteres.
    public String toString();
    //Debe implementarse para realizar un recorrido en orden del arbol binario, invocando un metodo recursivo de recorrido que comienza por la raiz.
    public Iterator<T> iteratorInOrder();
    //Debe implementarse para realizar un recorrido descendente del arbol binario, invocando un metodo recursivo de recorrido que comienza por la raiz.
    public Iterator<T> iteratorPreOrder();
    //Debe implementarse para realizar un recorrido ascendente del arbol binario, invocando un metodo recursivo de recorrido que comienza por la raiz.
    public Iterator<T> iteratorPostOrder();
    //Debe implementarse para realizar un recorrido por niveles del arbol binario, invocando un metodo iterativo de recorrido que comienza por la raiz.
    public Iterator<T> iteratorLevelOrder();
}
