package prog3.arbolgeneral;
import prog3.listagenerica.*;
public class testArbolGeneral {
    public static void main(String[] args) {
        ArbolGeneral<String> a;
        String dato = "9";
        a = crearArbol1();
        a.recorridoPorNiveles();
        System.out.println();
        System.out.println("---------");
        System.out.println("La altura del arbol gral es:"+a.altura());
        System.out.println("¿Incluye el string:"+dato+"?"+a.include(dato, 0));
        System.out.println("Se encontro en el nivel:"+a.nivel(dato));
        System.out.println("Ancho del arbol:"+a.ancho());
    }

    public static ArbolGeneral<String> crearArbol1(){
        ArbolGeneral<String> a1 = new ArbolGeneral<String>("1");
        ArbolGeneral<String> a2 = new ArbolGeneral<String>("2");
        ArbolGeneral<String> a3 = new ArbolGeneral<String>("3");
        ArbolGeneral<String> a4 = new ArbolGeneral<String>("4");
        ArbolGeneral<String> a5 = new ArbolGeneral<String>("5");
        ArbolGeneral<String> a6 = new ArbolGeneral<String>("6");
        ArbolGeneral<String> a7 = new ArbolGeneral<String>("7");
        ArbolGeneral<String> a8 = new ArbolGeneral<String>("8");
        ArbolGeneral<String> a9 = new ArbolGeneral<String>("9");
        ListaGenerica<ArbolGeneral<String>> hijos = new ListaGenericaEnlazada<ArbolGeneral<String>>();
        hijos.agregarFinal(a1);
        hijos.agregarFinal(a2);
        hijos.agregarFinal(a3);
        ListaGenerica<ArbolGeneral<String>> hijos2 = new ListaGenericaEnlazada<ArbolGeneral<String>>();
        hijos2.agregarFinal(a4);
        hijos2.agregarFinal(a5);
        hijos2.agregarFinal(a6);
        hijos2.agregarFinal(a9);
        a1.setHijos(hijos2);
        ListaGenerica<ArbolGeneral<String>> hijos3 = new ListaGenericaEnlazada<ArbolGeneral<String>>();
        hijos3.agregarFinal(a7);
        hijos3.agregarFinal(a8);
        a4.setHijos(hijos3);
        ArbolGeneral<String> a = new ArbolGeneral<String>("0",
                hijos);
    return a;}

    public static ArbolGeneral<String> crearArbol2(){
        ArbolGeneral<String> a1 = new ArbolGeneral<String>("1");
        ArbolGeneral<String> a2 = new ArbolGeneral<String>("2");
        ArbolGeneral<String> a3 = new ArbolGeneral<String>("3");
        ArbolGeneral<String> a4 = new ArbolGeneral<String>("4");
        ArbolGeneral<String> a5 = new ArbolGeneral<String>("5");
        ArbolGeneral<String> a6 = new ArbolGeneral<String>("6");
        ArbolGeneral<String> a7 = new ArbolGeneral<String>("7");
        ArbolGeneral<String> a8 = new ArbolGeneral<String>("8");
        ListaGenerica<ArbolGeneral<String>> hijos = new ListaGenericaEnlazada<ArbolGeneral<String>>();
        hijos.agregarFinal(a1);
        hijos.agregarFinal(a2);
        hijos.agregarFinal(a3);
        ListaGenerica<ArbolGeneral<String>> hijos2 = new ListaGenericaEnlazada<ArbolGeneral<String>>();
        hijos2.agregarFinal(a4);
        hijos2.agregarFinal(a5);
        hijos2.agregarFinal(a6);
        a1.setHijos(hijos2);
        ListaGenerica<ArbolGeneral<String>> hijos3 = new ListaGenericaEnlazada<ArbolGeneral<String>>();
        hijos3.agregarFinal(a7);
        hijos3.agregarFinal(a8);
        a2.setHijos(hijos3);
        ArbolGeneral<String> a = new ArbolGeneral<String>("0",
                hijos);

    return a;}

}
