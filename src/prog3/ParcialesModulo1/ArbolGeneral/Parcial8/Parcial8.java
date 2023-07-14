package prog3.ParcialesModulo1.ArbolGeneral.Parcial8;
import prog3.arbolgeneral.*;
import prog3.listagenerica.ListaGenerica;

public class Parcial8 {


    public ResultadoP8 resolver (ArbolGeneral<Integer> arbol, int nivelExluido) {
            ResultadoP8 resultado = new ResultadoP8();
            if (arbol.esVacio()) {
                return resultado;
            }
            else {
                preOrden(arbol,nivelExluido,resultado,0,0);
                return resultado;
            }
    }

    public  void preOrden(ArbolGeneral<Integer> arbol, int nivelExcluido, ResultadoP8 resultado, int sumaAct, int nivelAct){
           if (arbol.esHoja()){
               if (!(nivelAct==nivelExcluido)) {
                   sumaAct = sumaAct+arbol.getDato();
               }
               if (sumaAct%2==0) {
                   resultado.setCaminosPares(resultado.getCaminosPares()+1);
               }
               else {
                   resultado.setCaminosImpares(resultado.getCaminosImpares()+1);
               }
           }
           else {
               if (!(nivelAct==nivelExcluido)) {
                   sumaAct = sumaAct+arbol.getDato();
               }
               ListaGenerica<ArbolGeneral<Integer>> hijos = arbol.getHijos();
               hijos.comenzar();
               while (!hijos.fin()) {
                   ArbolGeneral<Integer> aux = hijos.proximo();
                   preOrden(aux,nivelExcluido,resultado,sumaAct,nivelAct+1);
               }
           }
    };
}
