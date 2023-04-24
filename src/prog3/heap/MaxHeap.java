package prog3.heap;

import prog3.listagenerica.ListaGenerica;

public class MaxHeap<T extends Comparable<T>> implements ColaPrioridades<T> {
    private T[] datos = (T[]) new Comparable[100];
    private int cantEltos = 0;

    //----Constructors

    public MaxHeap() {};

    public MaxHeap(ListaGenerica<T> lista) {
        lista.comenzar();
        while (!lista.fin()){
            this.agregar(lista.proximo());
        }
    }


    @Override
    public boolean esVacia() {
        return false;
    }

    @Override
    public void eliminar() {

    }

    public boolean agregar(T elemento) {
        this.cantEltos++;
        this.datos[cantEltos] = elemento; this.percolate_up(cantEltos);
        return true;}

    @Override
    public void tope() {

    }

    private void percolate_up(int indice) {
        T temporal = datos[indice];
        while (indice/2>0 && datos[indice/2].compareTo(temporal)<0){
            datos[indice] = datos[indice/2]; indice = indice/2;
        }
        datos[indice] = temporal;
    }

    private void percolate_down(int indice) {

    }
}
