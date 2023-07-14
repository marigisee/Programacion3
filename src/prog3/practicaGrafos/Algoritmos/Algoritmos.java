package prog3.practicaGrafos.Algoritmos;

import prog3.listagenerica.ListaGenerica;
import prog3.problemaCiudades.Resultados;
import prog3.grafos.*;

public class Algoritmos<T> {

    Resultados r;
    /**
     * Retorna true si un dígrafo (grafo dirigido) contiene un subgrafo cuadrado, false en caso contrario.
     * Un subgrafo cuadrado es un ciclo simple de longitud 4.
    **/

    public boolean SubgrafoCuadrado(Grafo<T> grafo) {
        boolean encontro=false;
        boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
        for (int i = 0; i < visitados.length ;i++) {
            encontro = SubgrafoCuadradoRec(i,grafo,r,visitados,grafo.listaDeVertices().elemento(i),0,false);
            if (encontro) {
                return encontro;
            }
        }
    return encontro;}

    private boolean SubgrafoCuadradoRec (int i, Grafo<T> grafo, Resultados r, boolean[] visitados, Vertice<T> vInicio, int contador, boolean esCuadrado) {
        visitados[i] = true;
        contador++;
        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        // Nos paramos en un vértice, y recorremos cada adyacente para ver si alguno de los proximos ya es vInicio //
        ady.comenzar();
        for (int x = 0; x < ady.tamanio(); x++)
            // Si uno de los proximos es vInicio y además el contador es 4, devolvemos true //
            if (((ady.elemento(x).verticeDestino()) == vInicio) && (contador == 4))
                return true;
        // Si ninguno de los proximos es vInicio o si el contador no es 4, empleamos DFS //
        // Si el contador es menor que 4, debo seguir recorriendo en profundidad //
        ady.comenzar();
        //Si el contador es 4, pero ninguno de los vértices adyacentes es el de inicio NO es el de inicio//
        if (contador < 4) {
                // Recorremos la lista de adyacentes //
                while (!ady.fin()) {
                    // Obtenemos la posicion del proximo vertice a analizar //
                    int j = ady.proximo().verticeDestino().posicion();
                    // Si no lo analizamos todavía //
                    if (!visitados[j]) {
                        // Empleamos DFS en el nodo vDestino //
                        esCuadrado = SubgrafoCuadradoRec(j, grafo, r, visitados, vInicio, contador, esCuadrado);
                        // Volvimos de la recursión, si encontro un ciclo, terminamos de emplear el método //
                        if (esCuadrado) {
                            return esCuadrado;
                        }
                        else {
                            visitados[j] = false;
                        }
                    }
                }

            }
        return esCuadrado;
        }


    /**
     * Retorna el grado del digrafo pasado como parámetro. El grado de un digrafo es el de su vértice de grado máximo.
     * El grado de un vértice en un grafo dirigido es la suma del número de aristas que salen de él (grado de salida) y el número de aristas que entran en él (grado de entrada).
     */
    public int getGrado(Grafo<T> grafo) {
        int gradoMax = 0;
        if (!grafo.esVacio()) {
            int[] vectorGrados = new int[grafo.listaDeVertices().tamanio()];
            for (int i = 0 ; i<grafo.listaDeVertices().tamanio(); i++) {
                Vertice<T> vActual = grafo.listaDeVertices().elemento(i);
                //Obtengo la lista de adyacentes del vértice actual//
                ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(vActual);
                //Primero sumamos la cantidad de aristas que salen del vertice//
                vectorGrados[i] += ady.tamanio();
                ady.comenzar();
                int posAdyacente = 0;
                //Ahora sumo +1 a los vertices que aparecen en la lista adyacente (sumo las aristas incidentes a cada vértice)//
                for (int j = 0; j < ady.tamanio() ; j++) {
                    vectorGrados[ady.proximo().verticeDestino().posicion()]++;
                }
            }
            for (int i = 0; i<vectorGrados.length; i++) {
                if (gradoMax<vectorGrados[i]) {
                    gradoMax = vectorGrados[i];
                }
            }
        }
    return gradoMax;}

    /**
     * tieneCiclo(Grafo<T> grafo): boolean // Retorna true si el grafo dirigido pasado como
     * parámetro tiene al menos un ciclo, false en caso contrario.
     */

    public boolean tieneCiclo (Grafo<T> grafo) {
        boolean ciclo=false;
        if (!grafo.esVacio()) {
            boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
            for (int i = 0 ; i<visitados.length ; i++ ) {
                visitados[i] = true;
                ciclo = tieneCicloDFS(grafo,i,ciclo, grafo.listaDeVertices().elemento(i),visitados);
            }
        }
    return ciclo;}

    private boolean tieneCicloDFS (Grafo<T> grafo,int i,boolean ciclo, Vertice<T> vInicio,boolean[] visitados) {
        visitados[i] = true;
        Vertice<T> v = grafo.listaDeVertices().elemento(i);
        ListaGenerica<Arista<T>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        //Recorro los vértices para ver si el próximo vertice a analizar es vInicio//
        for (int j = 0; j < grafo.listaDeAdyacentes(v).tamanio() ; j++ )
            if (grafo.listaDeAdyacentes(v).elemento(j).verticeDestino() == vInicio) {
                ciclo = true;
                return ciclo;
            }
        ady.comenzar();
        while (!ady.fin()) {
            Arista<T> arista = ady.proximo();
            Vertice<T> vDestino = arista.verticeDestino();
            if (!visitados[vDestino.posicion()]) {
                ciclo = tieneCicloDFS(grafo, vDestino.posicion(), ciclo, vInicio, visitados );
            }
            if (ciclo) {
                return ciclo;
            }
            else{
                visitados[i] = false;
            }
        }
        return ciclo;
    }

}
