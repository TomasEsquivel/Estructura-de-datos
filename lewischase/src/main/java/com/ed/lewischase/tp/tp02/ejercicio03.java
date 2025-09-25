package com.ed.lewischase.tp.tp02;

import com.ed.lewischase.set.ArraySet;

public class ejercicio03 {
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
        listaDeNumeros2.add(4);
        listaDeNumeros2.add(67);

        ArraySet<Integer> listaInterseccion = listaDeNumeros.intersection(listaDeNumeros2);
        String lista = listaInterseccion.toString();
        System.out.println(lista);
    }
}
