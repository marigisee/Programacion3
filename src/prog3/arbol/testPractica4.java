package prog3.arbol;

import prog3.listagenerica.ListaGenericaEnlazada;
import prog3.util.*;

import static prog3.util.Utiles.trayectoriaPesada;

public class testPractica4 {
    public static void main(String[] args) {
        int a=1;
        int b=2;
        ArbolBinario<Integer> arbolBinario = new ArbolBinario<Integer>(7);
        ArbolBinario<Integer> hijoIzquierdo1B = new ArbolBinario<Integer>(1);
        hijoIzquierdo1B.agregarHijoIzquierdo(new ArbolBinario<Integer>(8));
        ArbolBinario<Integer> hijoDerecho1B = new ArbolBinario<Integer>(3);
        hijoDerecho1B.agregarHijoIzquierdo(new ArbolBinario<Integer>(2));
        hijoDerecho1B.agregarHijoDerecho(new ArbolBinario<Integer>(1));
        arbolBinario.agregarHijoIzquierdo(hijoIzquierdo1B);
        arbolBinario.agregarHijoDerecho(hijoDerecho1B);
        arbolBinario.recorridoPorNiveles();
        System.out.println();
        /**
        int sumatoriaHorizontal = arbolBinario.sumaMaximaHorizontal();
        System.out.println("Maxima sumatoria horizontal:"+sumatoriaHorizontal);
        int sumatoriaVertical = arbolBinario.sumaMaximaVertical();
        System.out.println("Maxima sumatoria vertical:"+sumatoriaVertical);
         **/
        ListaGenericaEnlazada<Integer> trayPe = trayectoriaPesada(arbolBinario);
        System.out.println("Trayectoria Pesada:");
        System.out.println(trayPe);
    }
}