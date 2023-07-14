package prog3.ParcialesModulo1.ArbolGeneral.Parcial9;
import prog3.arbolgeneral.*;
import prog3.listagenerica.*;
public class Parcial9 {
    public ListaGenerica<Integer> resolver (ArbolGeneral<Integer> arbol){
        if (arbol.esVacio()) {
            return null;
        }
        else {
            ListaGenerica<Integer> resultado = new ListaGenericaEnlazada<>();
            preOrden(arbol,resultado,true);
            return resultado;
        }
    }

    public boolean preOrden (ArbolGeneral<Integer> arbol,ListaGenerica<Integer> resultado, boolean condicion) {
        if (arbol.esHoja()) {
            resultado.agregarFinal(arbol.getDato());
            return true;
        }
        else {
            int datoAct = arbol.getDato();
            resultado.agregarFinal(datoAct);
            ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
            hijos.comenzar();
            while ( (!(hijos.fin()))&&(condicion) ){
                ArbolGeneral<Integer> aux = hijos.proximo();
                if (aux.getDato()>=datoAct*2) {
                    condicion = preOrden(aux,resultado,condicion);
                }
                else{
                    condicion = false;
                }
            }
            return condicion;
        }
    }

}
