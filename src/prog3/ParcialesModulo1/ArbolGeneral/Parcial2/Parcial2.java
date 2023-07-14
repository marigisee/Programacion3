package prog3.ParcialesModulo1.ArbolGeneral.Parcial2;

import prog3.arbolgeneral.ArbolGeneral;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Parcial2 {
    public static void main(String[] args) {
        ArbolGeneral<Character> arbol = crearArbol();
        ListaGenerica<ListaGenerica<Character>> resultado = caminosPares(arbol);
        System.out.println("Caminos que cumplen con la condicion");
        resultado.comenzar();
        while (!resultado.fin()){
            System.out.println(resultado.proximo());
            System.out.println();
        }
    }

    public static ListaGenerica<ListaGenerica<Character>> caminosPares (ArbolGeneral<Character> arbol) {
        if (!arbol.esVacio()){
            ListaGenerica<ListaGenerica<Character>> resultado = new ListaGenericaEnlazada<>();
            ListaGenerica<Character> listaAct = new ListaGenericaEnlazada<>();
            if (arbol.esHoja()){
                listaAct.agregarFinal(arbol.getDato());
                resultado.agregarFinal(listaAct);
                return resultado;
            }
            else {
                recorrido(arbol,listaAct,resultado,1);
                return resultado;
            }
        }
        else {
            return null;
        }
    }

// Vamos a utilizar un recorrido preOrder //
    private static void recorrido(ArbolGeneral<Character> arbol, ListaGenerica<Character> listaAct, ListaGenerica<ListaGenerica<Character>> resultado, Integer cantNodos){
        if (arbol.esHoja()) {
            listaAct.agregarFinal(arbol.getDato());
            if (cantNodos%2==0) {
                resultado.agregarFinal(listaAct.clonar());
            }
        }
        else {
               listaAct.agregarFinal(arbol.getDato());
               ListaGenerica<ArbolGeneral<Character>> hijos = arbol.getHijos();
               hijos.comenzar();
               while (!hijos.fin()) {
                    ArbolGeneral<Character> aux = hijos.proximo();
                    recorrido(aux,listaAct,resultado,cantNodos+1);
                    listaAct.eliminarEn(listaAct.tamanio()-1);
               }
        }
    };



    public static ArbolGeneral<Character> crearArbol(){
        ArbolGeneral<Character> A = new ArbolGeneral<>();
        A.setDato('A');
        ArbolGeneral<Character> B = new ArbolGeneral<>();
        B.setDato('B');
        ArbolGeneral<Character> C = new ArbolGeneral<>();
        C.setDato('C');
        ArbolGeneral<Character> D = new ArbolGeneral<>();
        D.setDato('D');
        ArbolGeneral<Character> E = new ArbolGeneral<>();
        E.setDato('E');
        ArbolGeneral<Character> F = new ArbolGeneral<>();
        F.setDato('F');
        ArbolGeneral<Character> G = new ArbolGeneral<>();
        G.setDato('G');
        ArbolGeneral<Character> H = new ArbolGeneral<>();
        H.setDato('H');
        ArbolGeneral<Character> I = new ArbolGeneral<>();
        I.setDato('I');
        ListaGenerica<ArbolGeneral<Character>> hijosA = new ListaGenericaEnlazada<>();
        hijosA.agregarFinal(B);
        hijosA.agregarFinal(C);
        hijosA.agregarFinal(D);
        A.setHijos(hijosA);
        ListaGenerica<ArbolGeneral<Character>> hijosB = new ListaGenericaEnlazada<>();
        hijosB.agregarFinal(E);
        B.setHijos(hijosB);
        ListaGenerica<ArbolGeneral<Character>> hijosC = new ListaGenericaEnlazada<>();
        hijosC.agregarFinal(F);
        hijosC.agregarFinal(G);
        C.setHijos(hijosC);
        ListaGenerica<ArbolGeneral<Character>> hijosF = new ListaGenericaEnlazada<>();
        hijosF.agregarFinal(H);
        hijosF.agregarFinal(I);
        F.setHijos(hijosF);
        return A;}

}
