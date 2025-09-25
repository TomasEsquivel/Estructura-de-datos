package com.ed.lewischase.tp.tp02;

import com.ed.lewischase.set.ArraySet;
import com.ed.lewischase.set.EmptySetException;
import com.ed.lewischase.set.NoSuchElementException;
import com.ed.lewischase.set.SetADT;

import java.util.Iterator;

public class ejercicio01 {
    public static void main(String[] args) {
        ArraySet<Integer> listaDeNumeros = new ArraySet<>(5);
        ArraySet<Integer> listaDeNumeros2 = new ArraySet<>(5);

        //add() listaDeNumeros
        listaDeNumeros.add(1);
        listaDeNumeros.add(4);
        listaDeNumeros.add(8);
        listaDeNumeros.add(2);
        listaDeNumeros.add(5);
        // add() listaDeNumeros2
        listaDeNumeros2.add(2);
        listaDeNumeros2.add(5);
        listaDeNumeros2.add(9);
        listaDeNumeros2.add(3);
        listaDeNumeros2.add(6);



        //removeRandom()
        try {
            int elemEliminado = listaDeNumeros.removeRandom();
            System.out.println("Elemento aleatorio eliminado de la lista: " + elemEliminado);
        } catch (EmptySetException e) {
            System.out.println(e.getMessage());
        }

        //remove(target)
        try {
            int elemEliminado = listaDeNumeros.remove(1);
            System.out.println("Elemento voluntariamente eliminado: " +  elemEliminado);
        } catch (EmptySetException e) {
            throw new RuntimeException(e);
        } catch (NoSuchElementException e) {
            System.out.println(e.getMessage());
        }

        //union(otra lista) Lo tuve que castear o sino tenia que cambiar el retorno en la firma del metodo union()
        ArraySet<Integer> listaUnida = (ArraySet<Integer>) listaDeNumeros.union(listaDeNumeros2);

        //contains(elem)
        if (listaDeNumeros.contains(1))
            System.out.println("Elemento encontrado");
        else
            System.out.println("No se halló el elemento");

        //equals(otra lista)
        try{
            if(listaDeNumeros.equals(listaDeNumeros2))
                System.out.println("Ambas listas tienen los mismos elementos");
            else
                System.out.println("Las listas son diferentes");
        }catch (Exception e){   //Aprovecho que ambas excepciones heredan de Exception y las meto en un solo catch
            System.out.println(e.getMessage());
        }

        //addAll(otra lista)
        listaUnida.addAll(listaDeNumeros);

        //isEmpty()
        if (listaDeNumeros.isEmpty())
            System.out.println("La lista está vacía.");

        //size()
        System.out.println("Tamaño de la lista unida");
        System.out.println(listaUnida.size());

        //Iterator()
        Iterator<Integer> iterador = listaDeNumeros.iterator();
        System.out.println("***** Lista de números multiplicados por 2 *****");
        int obj;
        while (iterador.hasNext()){
            obj = iterador.next() * 2;
            System.out.print(obj + "/");
        }

        System.out.println();

        //toString()
        System.out.println("***** Lista de numeros 2 *****");
        String lista2 = listaDeNumeros.toString();
        System.out.println(lista2);




    }
}
