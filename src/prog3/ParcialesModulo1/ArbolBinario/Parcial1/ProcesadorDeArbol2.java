package prog3.ParcialesModulo1.ArbolBinario.Parcial1;

import prog3.arbol.ArbolBinario;
import prog3.listagenerica.*;

public class ProcesadorDeArbol2 {
    private ArbolBinario<Character> arbol;
    private ListaGenerica<ListaGenerica<Character>> listaResultado;

    public ProcesadorDeArbol2 (ArbolBinario<Character> arbol) {
        this.arbol=arbol;
        listaResultado = new ListaGenericaEnlazada<>();
    }

    /**
     * Método que utiliza un recorrido preOrden
     * Condicion: en el camino que va desde la raíz a una hoja, la cantidad de árboles con un sólo hijo es K
     * @param
     * @return Cantidad de caminos que cumplen con la condicion
     */

    public int procesar (int k){
        if (this.arbol.esVacio() | this.arbol.esHoja())
            return 0;
        else {
            Resultado r = new Resultado();
            ListaGenerica<Character> listaAct = new ListaGenericaEnlazada<>();
            int resultado = procesar(this.arbol,k,0,0,listaAct,r);
            System.out.println("Los caminos que cumplen la condicion son:");
            r.getListaResultado().comenzar();
            while (!r.getListaResultado().fin()) {
                System.out.println(r.getListaResultado().proximo());
            }
            return resultado;
        }
    };

    private static int procesar (ArbolBinario<Character> a, int k, int cantArbolesCondicion, int cantidadCaminos, ListaGenerica<Character> listaAct, Resultado r) {

        //Caso base = llegamos a una hoja
        if (a.esHoja()){
            listaAct.agregarFinal(a.getDato());
            if (cantArbolesCondicion==k) {
                copiar(r.getListaResultado(),listaAct);
                return cantidadCaminos+1;
            }
        }
        else {
            if ((a.tieneHijoDerecho()) & !(a.tieneHijoIzquierdo())) {
                cantArbolesCondicion++;
            }
            if ((a.tieneHijoIzquierdo()) & !(a.tieneHijoDerecho())) {
                cantArbolesCondicion++;
            }
            if (cantArbolesCondicion<=k) {
                listaAct.agregarFinal(a.getDato());
                if (a.tieneHijoIzquierdo()) {
                    cantidadCaminos = procesar(a.getHijoIzquierdo(),k,cantArbolesCondicion, cantidadCaminos,listaAct,r);
                    listaAct.eliminarEn(listaAct.tamanio()-1);
                }
                if (a.tieneHijoDerecho()){
                    cantidadCaminos = procesar(a.getHijoDerecho(),k,cantArbolesCondicion, cantidadCaminos,listaAct,r);
                    listaAct.eliminarEn(listaAct.tamanio()-1);
                }
            }
        }
        return cantidadCaminos;
    }

    public static void copiar(ListaGenerica<ListaGenerica<Character>> d, ListaGenerica<Character> origen) {
        ListaGenerica<Character> destino = new ListaGenericaEnlazada<>();
        destino.comenzar();
        origen.comenzar();
        while (!origen.fin())
            destino.agregarFinal(origen.proximo());
        d.agregarFinal(destino);
    }

}
