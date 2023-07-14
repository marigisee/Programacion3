package prog3.problemaCiudades;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Resultados {

    boolean fin = false;
    ListaGenerica<String> listaString = new ListaGenericaEnlazada<>();

    int min = 9999;

    public void Resultados() {
        min = 9999;
    }

    public void Resultados(int Min){
        min = Min;
    }

    public void setListaString (ListaGenerica<String> listaString) {
         this.listaString = listaString;
    }

    public ListaGenerica<String> getListaString (){
        return this.listaString;
    }

    public boolean getFin() {
        return fin;
    }

    public void setFin(boolean fin) {
        this.fin = fin;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int min) {
        this.min = min;
    }
}
