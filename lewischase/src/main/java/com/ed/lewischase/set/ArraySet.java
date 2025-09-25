package com.ed.lewischase.set;
import java.util.Iterator;
import java.util.Random;

public class ArraySet<T> implements SetADT<T> {
    private static Random rand = new Random();
    private final int DEFAULT_CAPACITY = 100;
    private final int NOT_FOUND = -1;
    
    private int count;
    private T[] contents;
    
    public ArraySet(){
        count = 0;
        contents = (T[]) new Object[DEFAULT_CAPACITY];
    }
    
    public ArraySet(int initialCapacity){
        count = 0;
        contents = (T[])new Object[initialCapacity];
    }

    @Override
    /**
     * Añade el elemento especificado al conjunto, si es que ese elemento no
     * está ya presente. Expande la capacidad de la matriz del conjunto en caso
     * necesario.
     */
    public void add(T element) {
        if(!contains(element)){
            if(size() == contents.length) expandCapacity();
            else contents[count++] = element;
        }
    }
    /**
     * Crea una nueva matriz para almacenar el contenido del conjunto, con una
     * capacidad igual al doble de la capacidad de la matriz anterior.
     */
    private void expandCapacity(){
        T[] larger = (T[]) new Object[contents.length*2];
        for(int index = 0; index < contents.length; index++)
            larger[index] = contents[index];
        contents = larger;
    }

    @Override
    /**
     * Elimina un elemento aleatorio del conjunto y lo devuelve. Genera una
     * excepción EmptySetException si el conjunto está vacío.
     */
    public T removeRandom() throws EmptySetException{
        if(isEmpty()) throw new EmptySetException();

        int choice = rand.nextInt(count);
        T result = contents[choice];
        contents[choice] = contents[--count];//Se rellena el hueco
        contents[count] = null;
        return result;
    }

    @Override
    /**
     * Elimina el elemento especificado del conjunto y lo devuelve.
     * Genera EmptySetException si el conjunto esta vacío y NoSuchElementException
     * si el elementos especificado no se encuentra en el conjunto.
     */
    public T remove(T target) throws EmptySetException, NoSuchElementException {
        int search = NOT_FOUND;
        
        if(isEmpty()) throw new EmptySetException();
        
        for(int index = 0; (index < count) && (search == NOT_FOUND); index++)
            if(contents[index].equals(target)) search = index;
        
        if(search == NOT_FOUND) throw new NoSuchElementException();
        
        T result = contents[search];
        contents[search] = contents[--count];
        contents[count] = null;
        return result;
    }

    @Override
    /**
     * Devuelve un nuevo conjunto que es la unión del conjunto actual y del
     * conjunto pasado como parámetro.
     */
    public SetADT<T> union(SetADT<T> set) {
        ArraySet<T> both = new ArraySet<T>();
        
        for(int index = 0; index < count; index++)
            both.add(contents[index]);
        
        Iterator<T> scan = set.iterator();
        while(scan.hasNext())
            both.add(scan.next());
        
        return both;
    }

    @Override
    /**
     * Devuelve true si este conjunto contiene el elemento especificado.
     */
    public boolean contains(T target) {
        int search = NOT_FOUND;
        
        for(int index = 0; (index < count) && (search == NOT_FOUND); index++)
            if(contents[index].equals(target)) search = index;
        
        return search != NOT_FOUND;
    }

    @Override
    /**
     * Devuelve true si este conjunto contiene exactamente los mismos elementos
     * que el conjunto pasado como parámetro.
     */
    public boolean equals(SetADT<T> set) throws EmptySetException, NoSuchElementException{
        boolean result = false;
        ArraySet<T> temp1 = new ArraySet<T>();
        ArraySet<T> temp2 = new ArraySet<T>();
        T obj;
        if(size() == set.size()){
            temp1.addAll(this);
            temp2.addAll(set);
            Iterator<T> scan = set.iterator();
            while(scan.hasNext()){
                obj = scan.next();
                if(temp1.contains(obj)){
                    temp1.remove(obj);
                    temp2.remove(obj);
                }
            }
            result = (temp1.isEmpty() && temp2.isEmpty());
        }
        return result;
    }
    /**
     * Añade al conjunto el contenido del conjunto suministrado por el parámetro.
     */
    public void addAll(SetADT set){
        Iterator<T> scan = set.iterator();
        while(scan.hasNext())
            this.add(scan.next());
    }
    
    @Override
    /**
     * Devuelve true si este conjunto esta vacio y false en caso contrario.
     */
    public boolean isEmpty() {
        return (count == 0);
    }

    @Override
    /**
     * Devuelve el numero de elementos que el conjunto tiene actualmente.
     */
    public int size() {
        return count;
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator<T>(contents, count);
    }

    @Override
    public String toString() {
        String result = "";
        
        for(int index = 0; index < count; index++)
            result += contents[index].toString() + "\n";
            
        return result;
    }

    /**
     * @param set es otro conjunto pasado por parametro
     * toma un conjunto como parametro y resta del conjunto actual el contenido de dicho conjunto,
     * si es que los correspondientes elementos existen en el conjunto actual.
     * El resultado se devolverá en un nuevo conjunto, sin modificar el conjunto original.
     */
    @Override
    public ArraySet<T> difference(SetADT<T> set){
        ArraySet<T> temp = new ArraySet<>();

        Iterator<T> scan = this.iterator();

        while (scan.hasNext()){
            T elemento = scan.next();
            if(!set.contains(elemento) && elemento != null){
                temp.add(elemento);
            }
        }
        return temp;
    }

    /**
     * @param set es otro conjunto pasado por parametro
     * toma un conjunto como parámetro y devuelve otro conjunto con aquellos elementos
     * que existan en ambos conjuntos.
     */
    @Override
    public ArraySet<T> intersection(SetADT<T> set) {
        ArraySet<T> temp = new ArraySet<>();

        Iterator<T> scan = this.iterator();

        while (scan.hasNext()){
            T elemento = scan.next();
            if(set.contains(elemento) && elemento != null){
                temp.add(elemento);
            }
        }
        return temp;
    }
}
