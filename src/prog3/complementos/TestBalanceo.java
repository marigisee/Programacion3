package prog3.complementos;
import prog3.listagenerica.*;
import prog3.util.PilaGenerica;

public class TestBalanceo {
    public static void main(String[] args) {
        int i=0;
        boolean condicion = true;
        String s = "([)]";
        PilaGenerica<Character> pila = new PilaGenerica<Character>();
        while (i<s.length() & condicion) {
             switch(s.charAt(i)) {
                    case ')':{
                        if (pila.desapilar()!='(') {
                            condicion = false;
                        }
                        break;
                    }
                    case ']':{
                        if (pila.desapilar()!='[') {
                            condicion = false;
                        }
                        break;
                    }
                    case '}':{
                        if (pila.desapilar()!='{') {
                            condicion = false;
                        }
                        break;
                    }
                    default:pila.apilar(s.charAt(i));
                }
            i++;
        }
        if (condicion) {
            System.out.println("El string esta balanceado");
        }
        else
            System.out.println("El string no esta balanceado");
    }
}
