package prog3.listaenteros.test;

import prog3.listaenteros.ListaDeEnterosEnlazada;
import prog3.listaenteros.NodoEntero;

import java.util.Scanner;
public class TestOrdenamientos {
    static Scanner in = new Scanner(System.in);
    public static void main(String[] args) {

        /*Cargamos la lista*/


        ListaDeEnterosEnlazada l1 = new ListaDeEnterosEnlazada();
        ListaDeEnterosEnlazada l2 = new ListaDeEnterosEnlazada();

        crearLista(l1);
        System.out.println("Prox Lista");
        crearLista(l2);

        ListaDeEnterosEnlazada l1Ordenada = new ListaDeEnterosEnlazada();
        l1Ordenada = ListaDeEnterosEnlazada.ordenar(l1);
        ListaDeEnterosEnlazada l2Ordenada = ListaDeEnterosEnlazada.ordenar(l2);

        System.out.println("Lista sin ordenar");
        System.out.println(l1);
        System.out.println("----------------");
        System.out.println("Lista ordenada");
        System.out.println(l1Ordenada);
        System.out.println("--------------------------------");
        System.out.println("Lista sin ordenar");
        System.out.println(l2);
        System.out.println("----------------");
        System.out.println("Lista ordenada");
        System.out.println(l2Ordenada);

        //Listas Ordenadas Combinadas

        ListaDeEnterosEnlazada lCombinada = l2Ordenada.combinarOrdenado(l1Ordenada);
        System.out.println("Lista combinada ordenada");
        System.out.println(lCombinada);


    }


    public static void crearLista (ListaDeEnterosEnlazada l) {

        l.comenzar();
        int aux;
        System.out.println("Ingrese un numero");
        aux = in.nextInt();
        while (aux != 0){
            l.agregarInicio(aux);
            System.out.println("Ingrese un numero");
            aux = in.nextInt();
        }

    }


}


