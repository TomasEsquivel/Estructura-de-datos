package com.ed.lewischase.tp.tp02;


//import com.ed.lewischase.set.ArraySet;
//import com.ed.lewischase.set.SetADT;
//
//import java.util.Iterator;
//
//public ArraySet<T> difference(SetADT<T> set){
//    ArraySet<T> temp = new ArraySet<>();  => 1
//
//    Iterator<T> scan = this.iterator();   => 1
//
//    while (scan.hasNext()){   => n
//        T elemento = scan.next(); = 1
//        if(!set.contains(elemento) && elemento != null){ => m
//            temp.add(elemento); => 1
//        }
//    }
//    return temp; => 1
//}
// f(n) = 1 + 1 + n(1 + m + 1) + 1 = f(n) = O(n * m)


//import com.ed.lewischase.set.ArraySet;
//import com.ed.lewischase.set.SetADT;
//
//import java.util.Iterator;
//
//public ArraySet<T> intersection(SetADT<T> set) {
//    ArraySet<T> temp = new ArraySet<>();  => 1
//
//    Iterator<T> scan = this.iterator();   => 1
//
//    while (scan.hasNext()){   => n
//        T elemento = scan.next(); => 1
//        if(set.contains(elemento) && elemento != null){   => m
//            temp.add(elemento);   => 1
//        }
//    }
//    return temp; = 1
//}
// f(n) = 1 + 1 + n(1 + m + 1) + 1 = f(n) = O(n * m)
// puse que contains es de orden m porque tambien recorre de forma constante pero puede ser mas grande o mas pequeño que n