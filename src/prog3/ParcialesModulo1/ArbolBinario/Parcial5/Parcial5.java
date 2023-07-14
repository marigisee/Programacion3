package prog3.ParcialesModulo1.ArbolBinario.Parcial5;
import prog3.arbol.*;
import prog3.util.*;

public class Parcial5 {

    public static void main(String[] args) {
        ArbolBinario<String> arbol = crearArbol();
        colorearArbol(arbol,2);
        arbol.recorridoPorNiveles();
    }

    public static void colorearArbol (ArbolBinario<String> arbol,Integer maxColor) {
        if (!arbol.esVacio()) {
            ArbolBinario<String> aux = new ArbolBinario<>();
            String[] colores = {"Negro","Rojo"};
            String v = "Verde";
            int colorAct = 0;
            int nodosPintados = 0;
            ColaGenerica<ArbolBinario<String>> cola = new ColaGenerica<>();
            cola.encolar(arbol);
            cola.encolar(null);
            while (!cola.esVacia()) {
                aux = cola.desencolar();
                if (aux!=null) {
                    if (nodosPintados<maxColor) {
                        //Pintamos Negro//
                        if (colorAct%2==0) {
                            nodosPintados++;
                            aux.setDato("Negro");
                        }
                        else {
                            nodosPintados++;
                            aux.setDato("Rojo");
                        }
                        //Pintamos Rojo//
                    }
                    else {
                            aux.setDato("Verde");
                    }
                    if (aux.tieneHijoIzquierdo()) {
                            cola.encolar(aux.getHijoIzquierdo());
                        }
                    if (aux.tieneHijoDerecho()) {
                            cola.encolar(aux.getHijoDerecho());
                        }
                }
                else
                    if (!cola.esVacia()){
                        colorAct++;
                        nodosPintados=0;
                        cola.encolar(null);
                        System.out.println();
                    }
            }
        }
    }



    public static ArbolBinario<String> crearArbol() {
        ArbolBinario<String> a = new ArbolBinario<>();
        a.setDato("Incolor");
        ArbolBinario<String> a1_1 = new ArbolBinario<>();
        a1_1.setDato("Incolor");
        ArbolBinario<String> a1_2 = new ArbolBinario<>();
        a1_2.setDato("Incolor");
        ArbolBinario<String> a2_1 = new ArbolBinario<>();
        a2_1.setDato("Incolor");
        ArbolBinario<String> a2_2 = new ArbolBinario<>();
        a2_2.setDato("Incolor");
        ArbolBinario<String> a2_3 = new ArbolBinario<>();
        a2_3.setDato("Incolor");
        ArbolBinario<String> a2_4 = new ArbolBinario<>();
        a2_4.setDato("Incolor");
        ArbolBinario<String> a3_1 = new ArbolBinario<>();
        a3_1.setDato("Incolor");
        ArbolBinario<String> a3_2 = new ArbolBinario<>();
        a3_2.setDato("Incolor");
        ArbolBinario<String> a3_3 = new ArbolBinario<>();
        a3_3.setDato("Incolor");
        ArbolBinario<String> a3_4 = new ArbolBinario<>();
        a3_4.setDato("Incolor");
        //SubArbolIzquierdo
        a.agregarHijoIzquierdo(a1_1);
        a1_1.agregarHijoIzquierdo(a2_1);
        a1_1.agregarHijoDerecho(a2_2);
        a2_2.agregarHijoIzquierdo(a3_1);
        //SubArbolDerecho
        a.agregarHijoDerecho(a1_2);
        a1_2.agregarHijoIzquierdo(a2_3);
        a2_3.agregarHijoIzquierdo(a3_2);
        a1_2.agregarHijoDerecho(a2_4);
        a2_4.agregarHijoIzquierdo(a3_3);
        a2_4.agregarHijoDerecho(a3_4);
    return a;}

}
