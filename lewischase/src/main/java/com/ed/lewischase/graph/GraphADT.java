package com.ed.lewischase.graph;

/**
 * GraphADT define la interface para una estructura de datos Grafo.
 */
import java.util.Iterator;

public interface GraphADT<T> {
    /**
     * Agrega un vértice al grafo.
     * @param vertex El nuevo vértice que será agregado.
     */
    public void addVertex(T vertex);
    /**
     * Remueve un vértice del grafo.
     * @param vertex El vértice que será removido.
     */
    public void removeVertex(T vertex);
    /**
     * Agrega una arista entre dos vértices
     * @param vertex1 El primer vétice
     * @param vertex2 El segundo vértice
     */
    public void addEdge(T vertex1, T vertex2);
    /**
     * Elimina una arista entre dos vértices de un grafo.
     * @param vertex1 El primer vértice.
     * @param vertex2 El segundo vértice.
     */
    public void removeEdge(T vertex1, T vertex2);
    /**
     * Retorna un recorrido en anchura del grafo, comenzando desde un vértice dado.
     * @param startVertex Vértice de inicio.
     * @return Un iterador con el recorrido en anchura del grafo, desde un vértice específico.
     */
    public Iterator<T> iteratorBFS(T startVertex);
    /**
     * Retorna un recorrido en profundidad del grafo, comenzando desde un vértice dado.
     * @param startVertex Vértice de inicio.
     * @return Un iterador con el recorrido en profundidad del grafo, desde un vértice específico.
     */
    public Iterator<T> iteratorDFS(T startVertex);
    /**
     * Retorna un iterador que contiene el camino más corto entre dos vértices
     * @param startVertex Vértice de inicio
     * @param targetVertex Vértice final
     * @return Iterador con el recorrido del camino mas corto entre dos vértices.
     */
    public Iterator<T> iteratorShortestPath(T startVertex, T targetVertex);
    /**
     * Informa si el grafo se encuentra vacío o no.
     * @return True si el grafo esta vacío. False en caso contrario.
     */
    public boolean isEmpty();
    /**
     * Informa si el grafo esta conectado.
     * @return True si el grafo esta conectado. False en caso contrario.
     */
    public boolean isConnected();
    /**
     * Retonar el número de vértices en el grafo.
     * @return Un entero, con la cantidad de vértices.
     */
    public int size();
    /**
     * Retonar una representación de la matriz de adyacencia en formato de String.
     * @return Una cadena de caracteres, con la representación de la matriz de adyacencia.
     */
    public String toString();
}
