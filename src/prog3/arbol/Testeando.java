package prog3.arbol;

import prog3.listagenerica.ListaGenerica;

public class Testeando {
    public static void main(String[] args) {
        //Carga del arbol//
            ArbolBinario<Integer> arbolBinarioB=new ArbolBinario<Integer>(1);
            ArbolBinario<Integer> hijoIzquierdoB=new ArbolBinario<Integer>(2);
            hijoIzquierdoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(3));
            hijoIzquierdoB.agregarHijoDerecho(new ArbolBinario<Integer>(4));
            ArbolBinario<Integer> hijoDerechoB=new ArbolBinario<Integer>(6);
            hijoDerechoB.agregarHijoIzquierdo(new ArbolBinario<Integer>(7));
            hijoDerechoB.agregarHijoDerecho(new ArbolBinario<Integer>(8));
            arbolBinarioB.agregarHijoIzquierdo(hijoIzquierdoB);
            arbolBinarioB.agregarHijoDerecho(hijoDerechoB);
        //Contador Hojas//
            System.out.println("Cantidad de hojas:"+arbolBinarioB.contarHojas());
        //Frontera//
            ListaGenerica<Integer> frontera = arbolBinarioB.frontera();
            System.out.println(frontera);
        //Impresion por niveles//
            System.out.println("Impresion por nivel");
            arbolBinarioB.recorridoPorNiveles();
        //¿El arbol es lleno?//
            System.out.println("El arbol es lleno? "+ arbolBinarioB.esLleno());
    }
}
