package prog3.ParcialesModulo1.ArbolGeneral.Parcial3;
import prog3.arbol.ArbolBinario;
import prog3.arbolgeneral.*;
import prog3.listagenerica.*;
public class Parcial3 {

    public static void main(String[] args) {
            ArbolGeneral<Integer> arbol = crearArbol();
            ListaGenerica<Integer> camino = caminoHojaLejana(arbol);
            System.out.println(camino);
    }

    public static ListaGenerica<Integer> caminoHojaLejana (ArbolGeneral<Integer> arbol){
            if (!arbol.esVacio()){
                ListaGenerica<Integer> camino = new ListaGenericaEnlazada<>();
                if (arbol.esHoja()) {
                    camino.agregarFinal(arbol.getDato());
                    return camino;
                }
                else {
                    ListaGenerica<Integer> listaAct = new ListaGenericaEnlazada<>();
                    recorrido(arbol,listaAct,camino,1,-1);
                    return camino;
                }
            }
            else {
                return null;
            }
    }


    public static int recorrido (ArbolGeneral<Integer> arbol,ListaGenerica<Integer> listaAct,
                                  ListaGenerica<Integer> camino,int longCamino,int longCaminoMax) {
            if (arbol.esHoja()) {
                listaAct.agregarFinal(arbol.getDato());
                if (longCamino > longCaminoMax) {
                    clonar(listaAct,camino);
                    longCaminoMax = longCamino;
                    return longCaminoMax;
                }
            }
            else {
                listaAct.agregarFinal(arbol.getDato());
                ArbolGeneral<Integer> aux = new ArbolGeneral<>();
                ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
                hijos.comenzar();
                while (!hijos.fin()) {
                      aux = hijos.proximo();
                      longCaminoMax = recorrido(aux,listaAct,camino,longCamino+1,longCaminoMax);
                      listaAct.eliminarEn(listaAct.tamanio()-1);
                }
            }
        return longCaminoMax;
    }

    private static void clonar (ListaGenerica<Integer> l, ListaGenerica<Integer> camino) {
        camino.comenzar();
        while(!camino.fin())
            camino.eliminar(camino.proximo());
        l.comenzar();
        while(!l.fin())
            camino.agregarFinal(l.proximo());
    }

    /*
     *                   0
     *                /  |  \
     *              1    2   3
     *           / | |   | \
     *          4  5 6   7  8
     * */
    public static ArbolGeneral<Integer> crearArbol(){
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
