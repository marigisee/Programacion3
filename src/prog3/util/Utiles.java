package prog3.util;
import prog3.arbol.*;
import prog3.listagenerica.*;


public class Utiles<T> extends ArbolBinario<T> {
    /**
     * Retorna el valor de la trayectoria pesada de cada una de las hojas del árbol binario ab
     * Se define el valor de la trayectoria pesada de una hoja de un árbol binario como
     * la suma del contenido de todos los nodos desde la raíz a la hoja multiplicada por el
     * nivel en el que se encuentra
     */
    public static ListaGenericaEnlazada<Integer> trayectoriaPesada(ArbolBinario<Integer> ab) {
        ListaGenericaEnlazada<Integer> l = new ListaGenericaEnlazada<Integer>();
        l.comenzar();
        trayRe(ab,0,0,l);
        return l;
    }

    public static void trayRe(ArbolBinario<Integer> ab, Integer sum, Integer nivel, ListaGenericaEnlazada<Integer> resultados) {
        Integer aux;
        Integer aux_suma=0;
        if (!ab.esVacio()){
            //Si es hoja
            if (ab.esHoja()){
                aux = (Integer) ab.getDato();
                resultados.agregarFinal(sum+(nivel*aux));
            }
            //Si no es hoja
            else {
                if (ab.tieneHijoIzquierdo()) {
                    aux_suma=sum;
                    aux = ab.getDato();
                    trayRe(ab.getHijoIzquierdo(),sum+=(nivel*aux),nivel+1,resultados);
                    sum=aux_suma;
                }
                if (ab.tieneHijoDerecho()) {
                    aux_suma=sum;
                    aux = (Integer) ab.getDato();
                    trayRe(ab.getHijoDerecho(),sum+=(nivel*aux),nivel+1,resultados);
                    sum=aux_suma;
                }
            }
        }
    }



}