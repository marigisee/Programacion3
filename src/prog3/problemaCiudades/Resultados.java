package prog3.problemaCiudades;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Resultados {

    boolean fin = false;
    ListaGenerica<String> listaString = new ListaGenericaEnlazada<>();

    public void Resultados() {
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
}
