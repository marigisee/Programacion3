package prog3.ParcialesModulo1.ArbolGeneral.Parcial8;

import prog3.arbolgeneral.ArbolGeneral;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class testParcial8 {
    public static void main(String[] args) {
         Parcial8 p = new Parcial8();
         ResultadoP8 r = new ResultadoP8();
         ArbolGeneral<Integer> a = crearArbol();
         a.recorridoPorNiveles();
         System.out.println();
         r = p.resolver(a,1);
         System.out.println("Cantidad caminos con sumatoria par:"+r.getCaminosPares());
         System.out.println("Cantidad caminos con sumatoria impar:"+r.getCaminosImpares());
    }


    public static ArbolGeneral<Integer> crearArbol(){

        ArbolGeneral<Integer> a1 = new ArbolGeneral<>();
        a1.setDato(2);
        ArbolGeneral<Integer> a2_1 = new ArbolGeneral<>();
        a2_1.setDato(1);
        ArbolGeneral<Integer> a2_2 = new ArbolGeneral<>();
        a2_2.setDato(8);
        ArbolGeneral<Integer> a2_3 = new ArbolGeneral<>();
        a2_3.setDato(2);
        ArbolGeneral<Integer> a3_1 = new ArbolGeneral<>();
        a3_1.setDato(5);
        ArbolGeneral<Integer> a3_2 = new ArbolGeneral<>();
        a3_2.setDato(8);
        ArbolGeneral<Integer> a3_3 = new ArbolGeneral<>();
        a3_3.setDato(1);
        ArbolGeneral<Integer> a3_4 = new ArbolGeneral<>();
        a3_4.setDato(13);

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

        //Hijos de a2_2//
        ListaGenerica<ArbolGeneral<Integer>> hijos_a2_2 = new ListaGenericaEnlazada<>();
        hijos_a2_2.agregarFinal(a3_3);
        a2_2.setHijos(hijos_a2_2);

        //Hijos de a2_3//
        ListaGenerica<ArbolGeneral<Integer>> hijos_a2_3 = new ListaGenericaEnlazada<>();
        hijos_a2_3.agregarFinal(a3_4);
        a2_3.setHijos(hijos_a2_3);

    return a1;}


}
