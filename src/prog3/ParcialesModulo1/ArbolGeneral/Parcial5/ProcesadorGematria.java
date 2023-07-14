package prog3.ParcialesModulo1.ArbolGeneral.Parcial5;
import prog3.listagenerica.*;
import prog3.arbolgeneral.*;

public class ProcesadorGematria {
    public int contar(ArbolGeneral<Integer> arbol ,int valor){
            if (arbol.esVacio()) {
                return 0;
            }
            else {
                if (arbol.esHoja()) {
                    if (arbol.getDato()==valor) {
                        return 1;
                    }
                    else {
                        return 0;
                    }
                }
                else {
                    return recorrido(arbol,valor,0,0);
                }
            }
    }


    private static int recorrido (ArbolGeneral<Integer> arbol, int valor, int cantCaminos,int sumaAct){
        if (arbol.esHoja()) {
            sumaAct=sumaAct+arbol.getDato();
            if (sumaAct==valor) {
                cantCaminos=cantCaminos+1;
            }
            return cantCaminos;
        }
        else {
            sumaAct=sumaAct+arbol.getDato();
            ArbolGeneral<Integer> aux = new ArbolGeneral<>();
            ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
            hijos.comenzar();
            while (!hijos.fin()) {
                aux = hijos.proximo();
                cantCaminos = recorrido (aux,valor,cantCaminos,sumaAct);
            }
            return cantCaminos;
        }
    }
}
