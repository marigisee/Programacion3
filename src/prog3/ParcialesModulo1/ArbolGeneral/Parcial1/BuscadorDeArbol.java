package prog3.ParcialesModulo1.ArbolGeneral.Parcial1;
import prog3.arbolgeneral.*;
import prog3.listagenerica.*;

public class BuscadorDeArbol {

    private ArbolGeneral<Integer> arbol;


    public Integer buscarMayorEnPostOrden(){
        if (!arbol.esVacio()) {
            if (arbol.esHoja()){
                return arbol.getDato();
            }
            else {
                Integer mayorValor = -1;
                mayorValor = recorridoPostOrden(arbol, mayorValor);
                return mayorValor;
            }
        }
        else {
            return 0;
        }
    }



    //RecorridoPostOrden = Hijos - Padre
    public static Integer recorridoPostOrden(ArbolGeneral<Integer> arbol, Integer mayorValor) {
        if (arbol.esHoja()) {
            if (arbol.getDato() > mayorValor) {
                mayorValor = arbol.getDato();
            }
            return mayorValor;
        } else {
            ArbolGeneral<Integer> aux = new ArbolGeneral<>();
            ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
            hijos.comenzar();
            while (!hijos.fin()) {
                aux = hijos.proximo();
                mayorValor = recorridoPostOrden(aux, mayorValor);
            }
            if (arbol.getDato() > mayorValor) {
                mayorValor = arbol.getDato();
            }
            return mayorValor;
        }
    }


    //Constructor
    public BuscadorDeArbol(ArbolGeneral<Integer> arbol) {
        this.arbol = arbol;
    }
    public ArbolGeneral<Integer> getArbol() {
        return arbol;
    }

    public void setArbol(ArbolGeneral<Integer> arbol) {
        this.arbol = arbol;
    }
}
