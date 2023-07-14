package prog3.ParcialesModulo1.ArbolBinario.Parcial3;

import prog3.arbol.ArbolBinario;

public class Parcial {

    public static void main(String[] args) {
      ArbolBinario<Integer> a = crearArbol();
        System.out.println("Sumatoria:"+sumaImparesPosOrderMayorA(a,30));
    }

    public static Integer sumaImparesPosOrderMayorA(ArbolBinario<Integer> a, int limite) {
        Integer suma = recorridoPostOrder(a,limite,0);
    return suma;}

    private static Integer recorridoPostOrder (ArbolBinario<Integer> a , int limite, Integer suma) {
        if (a.esHoja()) {
            if ((a.getDato()%2!=0)&&(a.getDato()>limite)) {
                return a.getDato();
            }
            else {
                return suma;
            }
        }
        else {
            if (a.tieneHijoIzquierdo()) {
                suma = recorridoPostOrder(a.getHijoIzquierdo(), limite, suma);
            }
            if (a.tieneHijoDerecho()) {
                suma = recorridoPostOrder(a.getHijoDerecho(), limite, suma);
            }
            if ((a.getDato()%2!=0)&&(a.getDato()>limite)) {
                return suma + a.getDato();
            }
        }
    return suma;}


    public static ArbolBinario<Integer> crearArbol () {
        //Subarbol Izquierdo Nodos//
        ArbolBinario<Integer> a = new ArbolBinario<>();
        a.setDato(33);
        ArbolBinario<Integer> a56 = new ArbolBinario<>();
        a56.setDato(56);
        ArbolBinario<Integer> a38 = new ArbolBinario<>();
        a38.setDato(38);
        ArbolBinario<Integer> a87 = new ArbolBinario<>();
        a87.setDato(87);
        ArbolBinario<Integer> a77 = new ArbolBinario<>();
        a77.setDato(77);
        ArbolBinario<Integer> a16 = new ArbolBinario<>();
        a16.setDato(16);
        ArbolBinario<Integer> a43 = new ArbolBinario<>();
        a43.setDato(43);
        ArbolBinario<Integer> a9 = new ArbolBinario<>();
        a9.setDato(9);
        ArbolBinario<Integer> a10 = new ArbolBinario<>();
        a10.setDato(10);
        ArbolBinario<Integer> a31 = new ArbolBinario<>();
        a31.setDato(31);
        ArbolBinario<Integer> a94 = new ArbolBinario<>();
        a94.setDato(94);
        ArbolBinario<Integer> a2 = new ArbolBinario<>();
        a2.setDato(2);
        ArbolBinario<Integer> a1 = new ArbolBinario<>();
        a1.setDato(1);
        //Subarbol Izquierdo Conexiones//
        a.agregarHijoIzquierdo(a56); // 7→56
        a56.agregarHijoIzquierdo(a38); // 56→38
        a56.agregarHijoDerecho(a31);
        a38.agregarHijoIzquierdo(a87);
        a38.agregarHijoDerecho(a77);
        a77.agregarHijoIzquierdo(a16);
        a16.agregarHijoDerecho(a43);
        a43.agregarHijoIzquierdo(a9);
        a43.agregarHijoDerecho(a10);
        a56.agregarHijoDerecho(a31);
        a31.agregarHijoDerecho(a94);
        a94.agregarHijoDerecho(a2);
        a2.agregarHijoIzquierdo(a1);
        //Subarbol Derecho
        ArbolBinario<Integer> a25 = new ArbolBinario<>();
        a25.setDato(25);
        ArbolBinario<Integer> a5 = new ArbolBinario<>();
        a5.setDato(5);
        ArbolBinario<Integer> a6 = new ArbolBinario<>();
        a6.setDato(6);
        //Subarbol Derecho Conexiones//
        a.agregarHijoDerecho(a25);
        a25.agregarHijoIzquierdo(a5);
        a25.agregarHijoDerecho(a6);

        return a;}

    }
