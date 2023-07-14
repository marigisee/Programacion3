package prog3.ParcialesModulo1.ArbolBinario.Parcial1;

import prog3.arbol.ArbolBinario;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class ProcesadorDeArbol {
    private ArbolBinario<Character> arbol;

    public ProcesadorDeArbol (ArbolBinario<Character> arbol) {
        this.arbol=arbol;
    }

    /**
     * Método que utiliza un recorrido preOrden
     * Condicion: en el camino que va desde la raíz a una hoja, la cantidad de árboles con un sólo hijo es K
     * @param
     * @return Cantidad de caminos que cumplen con la condicion
     */
     public int procesar (int k){
         if (this.arbol.esVacio() | this.arbol.esHoja())
             return 0;
         else {
             int resultado = procesar(this.arbol,k,0,0);
             return resultado;
         }
     };

    private static int procesar (ArbolBinario<Character> a, int k, int cantArbolesCondicion, int cantidadCaminos) {

         //Caso base = llegamos a una hoja
          if (a.esHoja()){
              if (cantArbolesCondicion==k) {
                  return cantidadCaminos+1;
              }
          }
          else {
              if ((a.tieneHijoDerecho()) & !(a.tieneHijoIzquierdo())) {
                  cantArbolesCondicion++;
              }
              if ((a.tieneHijoIzquierdo()) & !(a.tieneHijoDerecho())) {
                 cantArbolesCondicion++;
             }
              if (cantArbolesCondicion<=k) {
                  if (a.tieneHijoIzquierdo()) {
                      cantidadCaminos = procesar(a.getHijoIzquierdo(),k,cantArbolesCondicion, cantidadCaminos);
                  }
                  if (a.tieneHijoDerecho()){
                      cantidadCaminos = procesar(a.getHijoDerecho(),k,cantArbolesCondicion, cantidadCaminos);
                  }
              }
          }
          return cantidadCaminos;
    }


}
