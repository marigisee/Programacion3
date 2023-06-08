package prog3.problemaCiudades;
import prog3.listagenerica.*;
import prog3.grafos.*;
import prog3.problemaCiudades.*;
import prog3.utiles.Recorridos;

public class Mapa {

    Grafo<String> grafo;


    public Mapa (Grafo<String> grafo) {
        this.grafo = grafo;
    }

    public Grafo<String> getMapaCiudades() {
        return grafo;
    }

    public void setMapaCiudades(Grafo<String> mapaCiudades) {
        this.grafo = mapaCiudades;
    }


    /**
     * Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso
     * que se pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible)
     * @param ciudad1 : ciudad inicio
     * @param ciudad2 : ciudad destino
     * @return
     */

    public ListaGenerica<String> devolverCamino(String ciudad1, String ciudad2) {
        ListaGenerica<String> ListaAux = new ListaGenericaEnlazada<String>();
        if (!this.getMapaCiudades().esVacio()) {
            Resultados r = new Resultados();
            ListaGenerica<String> Camino = new ListaGenericaEnlazada<String>();
            Camino.comenzar();
            ListaGenerica<Vertice<String>> ciudades = this.getMapaCiudades().listaDeVertices();
            boolean[] visitados = new boolean[ciudades.tamanio()];
            int i = 0;
            boolean ciudad1Encontrada = false;
            while (!(ciudad1Encontrada) & (i < visitados.length)) {
                if (ciudades.proximo().dato().equals(ciudad1)) {
                    ciudad1Encontrada = true;
                    ListaAux.agregarFinal(ciudad1);
                    visitados[i] = true;
                } else {
                    i++;
                }
            }
            //Cuando entra al DFS, va a arrancar desde la ciudad1//
            DFS(this.getMapaCiudades(), r , ListaAux, visitados, i, ciudad1, ciudad2);
            if (r.getFin()){
                return r.getListaString();
            }
            else {
                r.getListaString().eliminar(ciudad1);
                return r.getListaString();
            }
        }
        else
            return ListaAux;
    }

    private void DFS(Grafo<String> grafo,Resultados r,ListaGenerica<String> ListaAux, boolean[] visitados, int i, String ciudad1, String ciudad2) {
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        Vertice<String> vDestino;
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!(ady.fin())&&!(r.getFin())) {
            Arista<String> arista = ady.proximo();
            vDestino = arista.verticeDestino();
            i = arista.verticeDestino().posicion();
            //Si no está visitado, lo visita
            if (!visitados[i]) {
                //Agrego a la ListaAux
                ListaAux.agregarFinal(vDestino.dato());
                visitados[i] = true;
                //Si encontro la ciudad 2, la agrego y no llama a la recursión
                if (vDestino.dato().equals(ciudad2)) {
                    r.setListaString(ListaAux.clonar());
                    r.setFin(true);
                } else {
                    //Si no encontro la ciudad 2, seguimos recorriendo los adyacentes con el DFS
                    DFS(grafo, r, ListaAux, visitados, i, ciudad1, ciudad2);
                    ListaAux.eliminar(vDestino.dato());
                }
            }
        }
    }

    /**
     * Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso
     * que se pueda llegar, si no retorna la lista vacía.
     * El recorrido devuelto no tiene en cuenta las ciudades contenidas en @param ciudades.
     * @param ciudad1 : ciudad inicio
     * @param ciudad2 : ciudad destino
     * @param ciudades : lista que contiene la cantidad de ciudades que deben exceptuarse del recorrido
     *
     * @return Recorrido que cumple lo pedido
     */


    public ListaGenerica<String> devolverCaminoExceptuando (String ciudad1, String ciudad2, ListaGenerica<String> ciudades) {
        ListaGenerica<String> Camino = new ListaGenericaEnlazada<>();
        Camino.comenzar();
        ListaGenerica<String> ListaAux = new ListaGenericaEnlazada<>();
        ListaGenerica<Vertice<String>> ciudadesGrafo = grafo.listaDeVertices();
        ciudadesGrafo.comenzar();
        Resultados r = new Resultados();
        boolean ciudad1Encontrada = false;
        int i=0;
        boolean[] visitados = new boolean[grafo.listaDeVertices().tamanio()];
        while (!(ciudad1Encontrada) & (i<visitados.length)) {
            if (ciudadesGrafo.proximo().dato().equals(ciudad1)) {
                ciudad1Encontrada = true;
                ListaAux.agregarFinal(ciudad1);
                visitados[i] = true;
            }
            else {
                i++;
            }
        }
        if (ciudad1Encontrada) {
            DFSExceptuando(grafo,ciudad2,ciudades,i,ListaAux,visitados,r);
        }
    return r.getListaString();}

    public void DFSExceptuando (Grafo<String> grafo, String ciudad2, ListaGenerica<String> ciudades,
                               int i, ListaGenerica<String> ListaAux, boolean[] visitados, Resultados r) {
          Vertice<String> v = grafo.listaDeVertices().elemento(i);
          ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
          ady.comenzar();
          while (!(ady.fin())&&!(r.getFin())) {
              boolean encontroExceptuada = false;
              Arista<String> arista = ady.proximo();
              Vertice<String> vDestino = arista.verticeDestino();
              ciudades.comenzar();
              while (!(ciudades.fin())&&!(encontroExceptuada)) {
                  if (ciudades.proximo().equals(vDestino.dato())) {
                      encontroExceptuada = true;
                  }
              }
              //Si el proximo vértice no coincide con alguna de las ciudades exceptuadas
              if (!encontroExceptuada) {
                  ListaAux.agregarFinal(vDestino.dato());
                  //Preguntamos si el proximo vértice coincide con ciudad2
                  if (vDestino.dato().equals(ciudad2)) {
                      r.setListaString(ListaAux.clonar());
                      r.setFin(true);
                  }
                  //Si no coincide con la ciudad2 y no es está dentro de las ciudades exceptuadas, seguimos la recursión.
                  else {
                      i = vDestino.posicion();
                      visitados[i] = true;
                      DFSExceptuando(grafo, ciudad2, ciudades, i, ListaAux, visitados,r);
                      visitados[i] = false;
                      ListaAux.eliminar(vDestino.dato());
                  }
              }
          }
    }

    /**
     *     El método caminoMasCorto(String ciudad1, String ciudad2): ListaGenerica<String> //
     *     Retorna la lista de ciudades que forman el camino más corto para llegar de ciudad1 a
     *     ciudad2, si no existe camino retorna la lista vacía. (Las rutas poseen la distancia). (Sin tener
     *     en cuenta el combustible).
     */

    public ListaGenerica<String> caminoMasCorto(String ciudad1, String ciudad2){
        ListaGenerica<String> listaAux = new ListaGenericaEnlazada<>();
        if (!this.grafo.esVacio() && !(this.grafo==null)) {
            boolean[] visitados = new boolean[this.grafo.listaDeVertices().tamanio()];
            boolean encontroCiudad1 = false;

            ListaGenerica<Vertice<String>> list = this.grafo.listaDeVertices();

            int i = 0;

            //Buscamos si está la ciudad1 en el grafo//

            while (!(encontroCiudad1) && (i < visitados.length)) {
                if (list.elemento(i).dato().equals(ciudad1)) {
                    encontroCiudad1 = true;
                } else {
                    i++;
                }
            }
            if (encontroCiudad1) {

                //Si la encontró, entonces creamos lo necesario para comenzar el recorrido DFS

                Resultados r = new Resultados();
                listaAux.agregarFinal(ciudad1);
                visitados[i] = true;
                caminoMasCortoDFS(grafo,ciudad2,r, i,0,listaAux,visitados);
                System.out.println("La distancia total:"+r.getMin());
                return r.getListaString();
            } else {

                //Si no la encontró, entonces devolvemos listaAux que está vacia//

                return listaAux;
            }

        }

           //Si el grafo está vacio, devolvemos una lista vacia//

            return listaAux;
    }

    /**
     * Recorrido DFS del grafo en busca del camino con menor distancia hacia ciudad2.
     * @param grafo : grafo
     * @param ciudad2 : string que contiene la ciudad2
     * @param r : objeto Resultados que contiene la listaGeneral resultado.
     * @param i : posición del vértice actual
     * @param distancia : variable distancia que contiene la suma de las distancias
     * @param listaAux : lista auxiliar con la que iremos recorriendo el grafo
     * @param visitados : vector booleano
     */
    private static void caminoMasCortoDFS (Grafo<String> grafo, String ciudad2, Resultados r, int i, int distancia, ListaGenerica<String> listaAux, boolean[] visitados) {
        visitados[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);

        //Consultamos si el vértice actual es ciudad2 y si además la distancia entre ciudad1 hasta el vértice actual
        //Es menor que la almacenada en la variable r

        if (v.dato().equals(ciudad2) && distancia < r.getMin()) {
                r.setListaString(listaAux.clonar());
                r.setMin(distancia);
        }
        else {
            ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
            ady.comenzar();

            //Recorremos la lista de adyacentes del vértice actual

            while (!ady.fin()){
                Arista<String> arista = ady.proximo();
                int j = arista.verticeDestino().posicion();

                //Si el vértice destino no fue visitado, llamamos a la recursión.

                if (!visitados[j]) {

                    //Agregamos el vDestino a la listaAux
                    listaAux.agregarFinal(arista.verticeDestino().dato());

                    //A la recursión el enviamos la distancia calculada hasta ahora + la distancia entre el vértice actual y el vértice destino.
                    //Además le enviamos la posición del vértice destino en el vector visitados.
                    caminoMasCortoDFS(grafo,ciudad2,r, j,distancia+arista.peso(),listaAux,visitados);

                    //Eliminamos con eliminarEn porque sino no funciona.
                    listaAux.eliminarEn(listaAux.tamanio()-1);
                    visitados[j] = false;

                }
            }
        }
    }


/**
 * El método caminoSinCargarCombustible(String ciudad1, String ciudad2, int
 * tanqueAuto): ListaGenerica<String> // Retorna la lista de ciudades que forman un camino
 * para llegar de ciudad1 a ciudad2. El auto no debe quedarse sin combustible y no puede
 * cargar. Si no existe camino retorna la lista vacía
 */

    public ListaGenerica<String> caminoSinCargarCombustible (String ciudad1, String ciudad2, int tanqueAuto) {
        Resultados r = new Resultados();
        if (this.grafo.esVacio()) {
            return r.getListaString();
        } else {
            boolean[] visitados = new boolean[getMapaCiudades().listaDeVertices().tamanio()];
            boolean encontroCiudad1 = false;
            int i = 0;
            while (!encontroCiudad1 && i < visitados.length) {
                if (this.grafo.listaDeVertices().elemento(i).dato().equals(ciudad1)) {
                    encontroCiudad1 = true;
                } else i++;
            }
            if (encontroCiudad1) {
                ListaGenerica<String> listaAux = new ListaGenericaEnlazada<>();
                CombustibleDFS(getMapaCiudades(), ciudad2, i, listaAux, visitados, r, tanqueAuto, 0);
            }
        }
        return r.getListaString();
    }

    /*
    *
    * */
    private void CombustibleDFS (Grafo<String> grafo, String ciudad2, int i, ListaGenerica<String> listaAux, boolean[] visitados, Resultados r,int tanqueAuto,int cargaActual) {
        visitados[i] = true;
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        listaAux.agregarFinal(v.dato());
        if (v.dato().equals(ciudad2)) {
            if ((tanqueAuto)>=0) {
                r.setListaString(listaAux.clonar());
                r.setFin(true);
                System.out.println("Para el camino:"+listaAux+" el tanque de auto queda en:"+tanqueAuto);
            }
        } else {
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!ady.fin() && !r.getFin()) {
            Arista<String> arista = ady.proximo();
            Vertice<String> vDestino = arista.verticeDestino();
            int j = vDestino.posicion();
            CombustibleDFS(grafo, ciudad2, j, listaAux, visitados, r, tanqueAuto - arista.peso(), arista.peso());
            }
        }
        listaAux.eliminarEn(listaAux.tamanio()-1);
        visitados[i] = false;
    //    listaAux.eliminarEn(listaAux.tamanio()-1);
    }
}