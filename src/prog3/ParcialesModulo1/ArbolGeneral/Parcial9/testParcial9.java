package prog3.ParcialesModulo1.ArbolGeneral.Parcial9;

import prog3.arbolgeneral.ArbolGeneral;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class testParcial9 {

    public static void main(String[] args) {
        ArbolGeneral<Integer> arbol = crearArbol();
        arbol.recorridoPorNiveles();
        System.out.println();
        Parcial9 p = new Parcial9();
        ListaGenerica<Integer> resultado = p.resolver(arbol);
        System.out.println("Camino:"+resultado);
    }


    public static ArbolGeneral<Integer> crearArbol(){

        ArbolGeneral<Integer> a1 = new ArbolGeneral<>();
        a1.setDato(2);
        ArbolGeneral<Integer> a2_1 = new ArbolGeneral<>();
        a2_1.setDato(8);
        ArbolGeneral<Integer> a2_2 = new ArbolGeneral<>();
        a2_2.setDato(8);
        ArbolGeneral<Integer> a2_3 = new ArbolGeneral<>();
        a2_3.setDato(6);
        ArbolGeneral<Integer> a3_1 = new ArbolGeneral<>();
        a3_1.setDato(18);
        ArbolGeneral<Integer> a3_2 = new ArbolGeneral<>();
        a3_2.setDato(20);
        ArbolGeneral<Integer> a3_3 = new ArbolGeneral<>();
        a3_3.setDato(14);

        //Hijos de a1//
        ListaGenerica<ArbolGeneral<Integer>> hijos_a1 = new ListaGenericaEnlazada<>();
        hijos_a1.agregarFinal(a2_1);
        hijos_a1.agregarFinal(a2_2);
        hijos_a1.agregarFinal(a2_3);
        a1.setHijos(hijos_a1);

        //Hijos de a2_1//
        ListaGenerica<ArbolGeneral<Integer>> hijos_a2_1 = new ListaGenericaEnlazada<>();
        hijos_a2_1.agregarFinal(a3_1);
        hijos_a2_1.agregarFinal(a3_2);
        a2_1.setHijos(hijos_a2_1);


        //Hijos de a2_3//
        ListaGenerica<ArbolGeneral<Integer>> hijos_a2_3 = new ListaGenericaEnlazada<>();
        hijos_a2_3.agregarFinal(a3_3);
        a2_3.setHijos(hijos_a2_3);

        return a1;}

}
