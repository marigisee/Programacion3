package prog3.ParcialesModulo1.ArbolGeneral.Parcial10;
import prog3.arbolgeneral.*;
import prog3.listagenerica.*;
public class testParcial10 {
    public static void main(String[] args) {
         ArbolGeneral<Integer> a = crearArbol();
         a.recorridoPorNiveles();
         Parcial10 p = new Parcial10();
         System.out.println("Resultado:"+p.resolver(a));
    }

    public static ArbolGeneral<Integer> crearArbol(){

        ArbolGeneral<Integer> a1 = new ArbolGeneral<>();
        a1.setDato(2);
        ArbolGeneral<Integer> a2_1 = new ArbolGeneral<>();
        a2_1.setDato(1);
        ArbolGeneral<Integer> a2_2 = new ArbolGeneral<>();
        a2_2.setDato(8);
        ArbolGeneral<Integer> a2_3 = new ArbolGeneral<>();
        a2_3.setDato(25);
        ArbolGeneral<Integer> a3_1 = new ArbolGeneral<>();
        a3_1.setDato(5);
        ArbolGeneral<Integer> a3_2 = new ArbolGeneral<>();
        a3_2.setDato(4);
        ArbolGeneral<Integer> a3_3 = new ArbolGeneral<>();
        a3_3.setDato(13);
        ArbolGeneral<Integer> a4_1 = new ArbolGeneral<>();
        a4_1.setDato(4);
        ArbolGeneral<Integer> a4_2 = new ArbolGeneral<>();
        a4_2.setDato(3);
        ArbolGeneral<Integer> a4_3 = new ArbolGeneral<>();
        a4_3.setDato(11);
        ArbolGeneral<Integer> a4_4 = new ArbolGeneral<>();
        a4_4.setDato(77);
        ArbolGeneral<Integer> a5_1 = new ArbolGeneral<>();
        a5_1.setDato(80);
        ArbolGeneral<Integer> a5_2 = new ArbolGeneral<>();
        a5_2.setDato(33);
        ArbolGeneral<Integer> a5_3 = new ArbolGeneral<>();
        a5_3.setDato(20);
        ArbolGeneral<Integer> a5_4 = new ArbolGeneral<>();
        a5_4.setDato(27);
        ArbolGeneral<Integer> a5_5 = new ArbolGeneral<>();
        a5_5.setDato(90);

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


        //Hijos de a3_1//
        ListaGenerica<ArbolGeneral<Integer>> hijos_a3_1 = new ListaGenericaEnlazada<>();
        hijos_a3_1.agregarFinal(a4_1);
        a3_1.setHijos(hijos_a3_1);


        //Hijos de a4_1//
        ListaGenerica<ArbolGeneral<Integer>> hijos_a4_1 = new ListaGenericaEnlazada<>();
        hijos_a4_1.agregarFinal(a5_1);
        a4_1.setHijos(hijos_a4_1);

        //Hijos de a3_2//
        ListaGenerica<ArbolGeneral<Integer>> hijos_a3_2 = new ListaGenericaEnlazada<>();
        hijos_a3_2.agregarFinal(a4_2);
        hijos_a3_2.agregarFinal(a4_3);
        hijos_a3_2.agregarFinal(a4_4);
        a3_2.setHijos(hijos_a3_2);

        //Hijos de a3_2//
        ListaGenerica<ArbolGeneral<Integer>> hijos_a4_4 = new ListaGenericaEnlazada<>();
        hijos_a4_4.agregarFinal(a5_2);
        hijos_a4_4.agregarFinal(a5_3);
        hijos_a4_4.agregarFinal(a5_4);
        hijos_a4_4.agregarFinal(a5_5);
        a4_4.setHijos(hijos_a4_4);

        //Hijos de a2_3//
        ListaGenerica<ArbolGeneral<Integer>> hijos_a2_3 = new ListaGenericaEnlazada<>();
        hijos_a2_3.agregarFinal(a3_3);
        a2_3.setHijos(hijos_a2_3);


        return a1;}

}
