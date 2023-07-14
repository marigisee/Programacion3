package prog3.ParcialesModulo1.ArbolBinario.Parcial2;
import prog3.arbol.*;
import prog3.util.ColaGenerica;
import prog3.util.ColaGenerica.*;

public class Parcial2 {

    public static void main(String[] args) {
        ArbolBinario<Integer> arbol = crearArbol();
        System.out.println("El arbol es creciente?" + esArbolCreciente(arbol));
    }

    public static boolean esArbolCreciente (ArbolBinario<Integer> arbol){
        boolean result = false;
        if (!arbol.esVacio()) {
            boolean sigue = true;
            ArbolBinario<Integer> aux = new ArbolBinario<>();
            aux = arbol;
            int nivel=0;
            int cantNodos=0;
            ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<>();
            cola.encolar(aux);
            cola.encolar(null);
            while (!cola.esVacia()&&(sigue)){
                aux = cola.desencolar();
                if (!(aux==null)) {
                    cantNodos++;
                    if (aux.tieneHijoIzquierdo()) {
                        cola.encolar(aux.getHijoIzquierdo());
                    }
                    if (aux.tieneHijoDerecho()) {
                        cola.encolar(aux.getHijoDerecho());
                    }
                }
                else if (!cola.esVacia()) {
                    if ((nivel+1)!=cantNodos) {
                        sigue=false;
                        result=false;
                    }
                    else {
                        cantNodos=0;
                        nivel++;
                        cola.encolar(null);
                    }
                }
            }
            if (sigue) {
                result = true;
            }
         }
        else {
            return false;
        }
    return result;}

    public static ArbolBinario<Integer> crearArbol () {
        ArbolBinario<Integer> a = new ArbolBinario<>();
        a.setDato(2);
        ArbolBinario<Integer> b = new ArbolBinario<>();
        b.setDato(7);
        ArbolBinario<Integer> c = new ArbolBinario<>();
        c.setDato(2);
        ArbolBinario<Integer> d = new ArbolBinario<>();
        d.setDato(6);
        ArbolBinario<Integer> e = new ArbolBinario<>();
        e.setDato(5);
        ArbolBinario<Integer> f = new ArbolBinario<>();
        f.setDato(11);
        ArbolBinario<Integer> g = new ArbolBinario<>();
        g.setDato(5);
        ArbolBinario<Integer> j = new ArbolBinario<>();
        j.setDato(9);
        ArbolBinario<Integer> i = new ArbolBinario<>();
        i.setDato(4);
        //Subarbol Izquierdo
        a.agregarHijoIzquierdo(b);
        b.agregarHijoIzquierdo(c);
        b.agregarHijoDerecho(d);
        d.agregarHijoIzquierdo(e);
        d.agregarHijoDerecho(f);
        //Subarbol Derecho
        a.agregarHijoDerecho(e);
        e.agregarHijoDerecho(j);
        j.agregarHijoIzquierdo(i);

    return a;}

}
