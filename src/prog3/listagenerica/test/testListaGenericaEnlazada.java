package prog3.listagenerica.test;

import prog3.listagenerica.ListaGenericaEnlazada;

public class testListaGenericaEnlazada {

    public static void main(String[] args) {

        ListaGenericaEnlazada<Character> l = cargarLista();

        System.out.println(l);


    }

    public static ListaGenericaEnlazada<Character> cargarLista() {
        char[] letras = {'a','b','c','d','e','f'};
        int i = 0;
        ListaGenericaEnlazada<Character> l = new ListaGenericaEnlazada<Character>();
        l.comenzar();
        for ( i = 0 ; i<letras.length ; i++ ) {
            l.agregarFinal(letras[i]);
        }
    return l;}


}
