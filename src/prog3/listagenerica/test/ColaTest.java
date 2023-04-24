package prog3.listagenerica.test;

import prog3.util.ColaGenerica;

public class ColaTest {
        public static void main(String[] args) {
            //Creo una pila de caracteres
            ColaGenerica<Character> pila = new ColaGenerica<Character>();
            pila.encolar('a');
            pila.encolar('b');
            pila.encolar('c');
            pila.encolar('d');
            pila.encolar('e');
            System.out.println("Tope de la cola antes de desencolar:"+pila.tope());
            for (int i=0;i<4;i++) {
                System.out.println(pila.desencolar());
            }
            System.out.println("Tope de la cola despues de desencolar:"+pila.tope());
        }
    }



