package prog3.listaenteros.test;

import prog3.listaenteros.ListaDeEnterosEnlazada;
import prog3.listaenteros.NodoEntero;

import java.util.Scanner;


public class ListaDeEnterosEnlazadaTestBasico {
    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);

        /*
         * Probando el comportamiento de la clase ListaDeEnterosEnlazada
         * */
        ListaDeEnterosEnlazada l = new ListaDeEnterosEnlazada();
        l.comenzar();
        int aux;
        System.out.println("Ingrese un numero");
        aux = in.nextInt();
        while (aux != 0){
            l.agregarInicio(aux);
            System.out.println("Ingrese un numero");
            aux = in.nextInt();
        }
        System.out.println(l);
        System.out.println("Segunda Impresion");
        System.out.println(l);
    }


    }





