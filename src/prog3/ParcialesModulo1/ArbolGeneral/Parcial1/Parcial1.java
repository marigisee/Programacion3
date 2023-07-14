package prog3.ParcialesModulo1.ArbolGeneral.Parcial1;

import prog3.arbolgeneral.*;
import prog3.listagenerica.*;

public class Parcial1 {

    public static void main(String[] args) {
        ArbolGeneral<Integer> a = crearArbol1();
        BuscadorDeArbol b = new BuscadorDeArbol(a);
        System.out.println("El elemento más grande del arbol general es:"+b.buscarMayorEnPostOrden());
    }



    /*
     *                   0
     *                /  |  \
     *              1    2   3
     *           / | |   | \
     *          4  5 6   7  8
     * */
    public static ArbolGeneral<Integer> crearArbol1(){
        ArbolGeneral<Integer> a1 = new ArbolGeneral<>();
        a1.setDato(1);
        ArbolGeneral<Integer> a2 = new ArbolGeneral<>();
        a2.setDato(2);
        ArbolGeneral<Integer> a3 = new ArbolGeneral<>();
        a3.setDato(3);
        ArbolGeneral<Integer> a4 = new ArbolGeneral<>();
        a4.setDato(4);
        ArbolGeneral<Integer> a5 = new ArbolGeneral<>();
        a5.setDato(5);
        ArbolGeneral<Integer> a6 = new ArbolGeneral<>();
        a6.setDato(6);
        ArbolGeneral<Integer> a7 = new ArbolGeneral<>();
        a7.setDato(7);
        ArbolGeneral<Integer> a8 = new ArbolGeneral<>();
        a8.setDato(8);
        ListaGenerica<ArbolGeneral<Integer>> hijos = new ListaGenericaEnlazada<>();
        hijos.agregarFinal(a1);
        hijos.agregarFinal(a2);
        hijos.agregarFinal(a3);
        ListaGenerica<ArbolGeneral<Integer>> hijos2 = new ListaGenericaEnlazada<>();
        hijos2.agregarFinal(a4);
        hijos2.agregarFinal(a5);
        hijos2.agregarFinal(a6);
        a1.setHijos(hijos2);
        ListaGenerica<ArbolGeneral<Integer>> hijos3 = new ListaGenericaEnlazada<>();
        hijos3.agregarFinal(a7);
        hijos3.agregarFinal(a8);
        a2.setHijos(hijos3);
        ArbolGeneral<Integer> a = new ArbolGeneral<>();
        a.setDato(0);
        a.setHijos(hijos);
        return a;}

}
