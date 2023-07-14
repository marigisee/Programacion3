package prog3.ParcialesModulo1.ArbolGeneral.Parcial10;
import  prog3.arbolgeneral.*;
import prog3.listagenerica.*;

public class Parcial10 {

    public static boolean resolver (ArbolGeneral<Integer> arbol) {
            if (arbol.esVacio()){
                return false;
            }
            else {
                ListaGenerica<Integer> sumTotalCaminos = new ListaGenericaEnlazada<>();
                sumTotalCaminos.agregarFinal(0);
                boolean resultado = preOrden(arbol,sumTotalCaminos,0,false);
                System.out.println();
                System.out.println(sumTotalCaminos);
                return resultado;
            }
    }

    private static boolean preOrden (ArbolGeneral<Integer> arbol, ListaGenerica<Integer> sumTotalCaminos, Integer sumAct, boolean encontro) {
            if (arbol.esHoja()) {
                sumAct = sumAct + arbol.getDato();
                sumTotalCaminos.comenzar();
                while ( (!sumTotalCaminos.fin()) & (!encontro) ){
                    int dat = sumTotalCaminos.proximo();
                    if (dat==sumAct) {
                        encontro=true;
                    }
                }
                sumTotalCaminos.agregarFinal(sumAct);
                return encontro;
            }
            else {
                sumAct=sumAct+arbol.getDato();
                ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
                hijos.comenzar();
                while ((!hijos.fin()) & (!encontro)) {
                    ArbolGeneral<Integer> aux = hijos.proximo();
                    encontro = preOrden(aux,sumTotalCaminos,sumAct,encontro);
                }
                return encontro;
            }
    }


}
