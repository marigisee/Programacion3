package prog3.practicaGrafos.utiles;
import prog3.grafos.*;
import prog3.listagenerica.*;
import prog3.util.*;

public class Recorridos<T> {
    public ListaGenerica<Vertice<T>> dfs(Grafo<T> grafo){
        //Arreglo marca el cual nos va a decir cual fue utilizado como vértice inicial y cual no
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        ListaGenerica<Vertice<T>> recorrido = new ListaGenericaEnlazada<>();
        for (int i = 0; i<marca.length; i++){
            if (!marca[i]) {
                this.dfs(i,grafo,recorrido,marca);
            }
        }
     return recorrido;}

    /**
     * @param p: posición del vértice con el que iniciamos a recorrer
     * @param recorrido: ListaGenérica que contiene todos los vértices que están en el recorrido
     */

    private void dfs (int p, Grafo<T> grafo, ListaGenerica<Vertice<T>> recorrido, boolean[] marca) {
            //Cambio el valor a true del vector marca
            marca[p] = true;
            //Creo variable auxiliar vértice
            Vertice<T> v = grafo.listaDeVertices().elemento(p);
            //Agrego el vértice actual al recorrido
            recorrido.agregarFinal(v);
            //Creo una variable auxiliar listaAdyacentes
            ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while (!ady.fin()) {
                    int posicion_vertice = ady.proximo().verticeDestino().posicion();
                    if (!marca[posicion_vertice]){
                        this.dfs(posicion_vertice,grafo,recorrido,marca);
                    }
                }
            }


    public  ListaGenerica<Vertice<T>> bfs (Grafo<T> grafo){
        //Lista donde voy a almacenar el recorrido del grafo
        ListaGenerica<Vertice<T>> recorrido = new ListaGenericaEnlazada<>();
        //Vector de marcas
        boolean[] marca = new boolean[grafo.listaDeVertices().tamanio()];
        for (int i=0;i<marca.length;i++){
             if (!marca[i]) {
                 this.bfs(i,grafo,recorrido,marca);
             }
        }
        return recorrido;
    }
    private void bfs (int i,Grafo<T> grafo,  ListaGenerica<Vertice<T>> recorrido,boolean[] marca) {
        //Lista donde voy a almacenar los adyacentes del vértice al que estoy procesando
        ListaGenerica<Arista<T>> ady = null;
        //Cola genérica
        ColaGenerica<Vertice<T>> cola = new ColaGenerica<>();
        cola.encolar(grafo.listaDeVertices().elemento(i));
        marca[i] = true;
        while (!cola.esVacia()){
            Vertice<T> v = cola.desencolar();
            recorrido.agregarFinal(v);
            ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();
            while (!(ady.fin())){
                Arista<T> arista = ady.proximo();
                int p = arista.verticeDestino().posicion();
                if (!marca[p]) {
                     Vertice<T> w = arista.verticeDestino();
                     marca[p] = true;
                     cola.encolar(w);
                }
            }
        }
    }
}



