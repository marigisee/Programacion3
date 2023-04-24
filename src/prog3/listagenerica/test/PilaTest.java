package prog3.listagenerica.test;
import prog3.util.PilaGenerica;

public class PilaTest {
    public static void main(String[] args) {
        //Creo una pila de caracteres
        PilaGenerica<Character> pila = new PilaGenerica<Character>();
        pila.apilar('a');
        pila.apilar('b');
        pila.apilar('c');
        pila.apilar('d');
        pila.apilar('e');
        for (int i=0;i<4;i++) {
            pila.desapilar();
        }
        System.out.println("Tope de la pila:"+pila.tope());
    }
}
