package prog3.ParcialesModulo1.ArbolBinario.Parcial4;
import prog3.arbol.*;
import prog3.listagenerica.*;
public class Parcial4 {


    private ListaGenerica<Integer> listaResultado;

    public Parcial4() {

        listaResultado = new ListaGenericaEnlazada<>();
    }

    public static void main(String[] args) {
        ArbolBinario<Integer> arbol = crearArbol();
        ListaGenerica<Integer> lista = resolver(arbol);
        System.out.println("Lista:"+lista);
    }

    public static ListaGenerica<Integer> resolver (ArbolBinario<Integer> arbol){
        if (!arbol.esVacio()){
             Parcial4 resultado = new Parcial4();
             if (arbol.esHoja()) {
                 resultado.getListaResultado().agregarFinal(0);
                 resultado.getListaResultado();
             }
             else {
                 recorridoPostOrder(arbol,resultado,0,0);
                 return resultado.getListaResultado();
             }
        }
        else {
            return null;
        }
    return null;}

    private static Integer recorridoPostOrder (ArbolBinario<Integer> arbol, Parcial4 resultado, Integer nodosIzq, Integer nodosDer) {
        if (arbol.esHoja()) {
            resultado.getListaResultado().agregarFinal(arbol.getDato());
            return 1;
        } else {
            if (arbol.tieneHijoIzquierdo()) {
                nodosIzq = nodosIzq + recorridoPostOrder(arbol.getHijoIzquierdo(), resultado, 0, 0);
            }
            if (arbol.tieneHijoDerecho()) {
                nodosDer = nodosDer + recorridoPostOrder(arbol.getHijoDerecho(), resultado, 0, 0);
            }
            if (nodosIzq == nodosDer) {
                resultado.getListaResultado().agregarFinal(arbol.getDato());
            }
            return nodosIzq + nodosDer + 1;
        }
    }



    public ListaGenerica<Integer> getListaResultado() {
        return listaResultado;
    }

    public void setListaResultado(ListaGenerica<Integer> listaResultado) {
        this.listaResultado = listaResultado;
    }

    public static ArbolBinario<Integer> crearArbol () {
        //Subarbol Izquierdo Nodos//
        ArbolBinario<Integer> a = new ArbolBinario<>();
        a.setDato(2);
        ArbolBinario<Integer> a1 = new ArbolBinario<>();
        a1.setDato(1);
        ArbolBinario<Integer> a16 = new ArbolBinario<>();
        a16.setDato(16);
        ArbolBinario<Integer> a6 = new ArbolBinario<>();
        a6.setDato(6);
        //Subarbol Izquierdo Conexiones//
        a.agregarHijoIzquierdo(a1);
        a1.agregarHijoIzquierdo(a16);
        a1.agregarHijoDerecho(a6);
        //Subarbol Derecho Nodos//
        ArbolBinario<Integer> a5 = new ArbolBinario<>();
        a5.setDato(5);
        ArbolBinario<Integer> a8 = new ArbolBinario<>();
        a8.setDato(8);
        ArbolBinario<Integer> a22 = new ArbolBinario<>();
        a22.setDato(22);
        //Subarbol Derecho Conexiones//
        a.agregarHijoDerecho(a5);
        a5.agregarHijoDerecho(a8);
        a8.agregarHijoIzquierdo(a22);
        return a;}

}


