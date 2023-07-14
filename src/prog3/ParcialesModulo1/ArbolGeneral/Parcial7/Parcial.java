package prog3.ParcialesModulo1.ArbolGeneral.Parcial7;

import prog3.arbolgeneral.ArbolGeneral;
import prog3.listagenerica.*;

public class Parcial {


    private ArbolGeneral<Integer> arbol;

    public Parcial (ArbolGeneral<Integer> arbol) {
         this.arbol = arbol;
    }


    /**
     * Devuelve en la lista la suma de los datos contenidos en los nodos del arbol
     * que tienen un numero impar hijos
     * El recorrido es postOrden
     * @return
     */
    public ListaGenerica<Integer> resolver(){
        if (arbol.esVacio()) {
            return null;
        }
        else {
            ListaGenerica<Integer> l = new ListaGenericaEnlazada<>();
            if (arbol.esHoja()) {
                l.agregarFinal(arbol.getDato());
                return l;
            }
            else {
                postOrden(arbol,l,0);
                return l;
            }
        }
    }

    public Integer postOrden(ArbolGeneral<Integer> arbol, ListaGenerica<Integer> l, int sumaAct) {
         if (arbol.esHoja()) {
             return arbol.getDato();
         }
         else {
              ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
              hijos.comenzar();
              while (!hijos.fin()){
                   ArbolGeneral<Integer> aux = hijos.proximo();
                   sumaAct = sumaAct + postOrden(aux,l,0);
              }
              if (!(hijos.tamanio()%2==0)){
                  l.agregarFinal(sumaAct);
              }
              return arbol.getDato();
         }
    }


}
