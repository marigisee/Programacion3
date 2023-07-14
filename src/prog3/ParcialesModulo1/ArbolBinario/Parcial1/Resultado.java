package prog3.ParcialesModulo1.ArbolBinario.Parcial1;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class Resultado {
    private ListaGenerica<ListaGenerica<Character>> listaResultado;

    public Resultado(){
        listaResultado = new ListaGenericaEnlazada<>();
    }

    public ListaGenerica<ListaGenerica<Character>> getListaResultado() {
        return listaResultado;
    }

    public void setListaResultado(ListaGenerica<ListaGenerica<Character>> listaResultado) {
        this.listaResultado = listaResultado;
    }


}
