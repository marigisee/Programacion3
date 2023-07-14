package prog3.ParcialesModulo1.ArbolGeneral.Parcial6;
import prog3.arbolgeneral.*;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Parcial6 {

    public static void main(String[] args) {
        ArbolGeneral<String> arbol = crearArbol();
        arbol.recorridoPorNiveles();
        ListaGenerica<String> resultado = procesar(arbol);
        System.out.println("El camino que cumple con lo pedido es:"+resultado);
    }

    //Implementar un metodo que devuelva una lista con un camino desde la raiz
    //a una Princesa sin pasar por un Dragon - sin necesidad de ser el mas
    //cercano a la raiz.

    public static ListaGenerica<String> procesar (ArbolGeneral<String> arbol){
            if ((arbol.esVacio())|(arbol.esHoja())) {
                return null;
            }
            else {
                ListaGenerica<String> resultado = new ListaGenericaEnlazada<>();
                ListaGenerica<String> caminoAct = new ListaGenericaEnlazada<>();
                recorrido(arbol,resultado,caminoAct);
                return resultado;
                }
            }

    public static void recorrido (ArbolGeneral<String> arbol, ListaGenerica<String> resultado, ListaGenerica<String> caminoAct) {
        if (arbol.esHoja()) {
            String dato = arbol.getDato();
            caminoAct.agregarFinal(dato);
            if (dato.equals("princesa")) {
                if (!(caminoAct.incluye("dragon"))) {
                    clonar(caminoAct,resultado);
                }
            }
        } else {
            if (resultado.esVacia()) {
                String dato = arbol.getDato();
                caminoAct.agregarFinal(dato);
                if (dato.equals("princesa")) {
                    if (!(caminoAct.incluye("dragon"))) {
                        resultado = caminoAct.clonar();
                    }
                }
                else {
                        ArbolGeneral<String> aux = new ArbolGeneral<>();
                        ListaGenerica<ArbolGeneral<String>> hijos = arbol.getHijos();
                        hijos.comenzar();
                        while (!hijos.fin()) {
                            aux = hijos.proximo();
                            recorrido(aux, resultado, caminoAct);
                        }
                    }
            }
        }
    }

    private static void clonar(ListaGenerica<String> l, ListaGenerica<String> camino) {
        l.comenzar();
        while(!l.fin())
            camino.agregarFinal(l.proximo());
    }

    public static ArbolGeneral<String> crearArbol () {
        ArbolGeneral<String> a = new ArbolGeneral<String>("coyote");
        ArbolGeneral<String> b = new ArbolGeneral<String>("scooby");
        ArbolGeneral<String> c = new ArbolGeneral<String>("princesa");
        ArbolGeneral<String> d = new ArbolGeneral<String>("cid");

        ArbolGeneral<String> e = new ArbolGeneral<String>("princesa");
        ArbolGeneral<String> f = new ArbolGeneral<String>("dragon");
        ArbolGeneral<String> g = new ArbolGeneral<String>("animal");

        ArbolGeneral<String> h = new ArbolGeneral<String>("princesa");
        ArbolGeneral<String> i = new ArbolGeneral<String>("tweety");
        ArbolGeneral<String> j = new ArbolGeneral<String>("princesa");

        a.agregarHijo(b);
        a.agregarHijo(c);
        a.agregarHijo(d);

        b.agregarHijo(j);

        c.agregarHijo(e);
        c.agregarHijo(f);
        c.agregarHijo(g);

        d.agregarHijo(h);
        d.agregarHijo(i);

    return a;}

}
