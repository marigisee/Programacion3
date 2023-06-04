package prog3.problemaCiudades;
import prog3.listagenerica.*;
import prog3.grafos.*;
import prog3.problemaCiudades.*;
import prog3.utiles.Recorridos;

public class Mapa {

    Grafo<String> mapaCiudades;

    //------ Ejercicio 6a ------//
    //------ devolverCamino ------//

    /**
     * Retorna la lista de ciudades que se deben atravesar para ir de ciudad1 a ciudad2 en caso
     * que se pueda llegar, si no retorna la lista vacía. (Sin tener en cuenta el combustible)
     * @param ciudad1 : ciudad inicio
     * @param ciudad2 : ciudad destino
     * @return
     */
    public ListaGenerica<String> devolverCamino(Grafo<String> grafo,String ciudad1, String ciudad2) {
        ListaGenerica<String> Camino = new ListaGenericaEnlazada<String>();
        ListaGenerica<String> ListaAux = new ListaGenericaEnlazada<String>();
        Camino.comenzar();
        ListaGenerica<Vertice<String>> ciudades = grafo.listaDeVertices();
        boolean[] visitados = new boolean[ciudades.tamanio()];
        int i=0;
        int posicion = 0;
        boolean ciudad1Encontrada = false;
        while (!(ciudad1Encontrada) & (i<visitados.length)){
            if (ciudades.proximo().dato().equals(ciudad1)) {
                ciudad1Encontrada=true;
                ListaAux.agregarFinal(ciudad1);
                visitados[i] = true;
            }
            else {
                i++;}
        }
        //Cuando entra al DFS, va a arrancar desde la ciudad1//
        Camino = DFS(grafo,Camino,ListaAux, visitados, i, ciudad1, ciudad2);
        return Camino;
    }

    private ListaGenerica<String> DFS(Grafo<String> grafo,ListaGenerica<String> Camino,ListaGenerica<String> ListaAux, boolean[] visitados, int i, String ciudad1, String ciudad2) {
        Vertice<String> v = grafo.listaDeVertices().elemento(i);
        Vertice<String> vDestino;
        ListaGenerica<Arista<String>> ady = grafo.listaDeAdyacentes(v);
        ady.comenzar();
        while (!(ady.fin())) {
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
                    Camino = (ListaAux.clonar());
                } else {
                    //Si no encontro la ciudad 2, seguimos recorriendo los adyacentes con el DFS
                    Camino = DFS(grafo, Camino, ListaAux, visitados, i, ciudad1, ciudad2);
                    ListaAux.eliminar(vDestino.dato());
                    visitados[i] = false;
                }
            }
        }
        return Camino;}

    //------ Ejercicio 6b ------//
    //------ devolverCamino ------//

    public ListaGenerica<String> devolverCaminoExceptuando (Grafo<String> grafo,String ciudad1, String ciudad2, ListaGenerica<String> ciudades) {
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
            DFSExceptuando(grafo,ciudad1,ciudad2,ciudades,i,ListaAux,visitados,r);
        }
    return r.getListaString();}

    public void DFSExceptuando (Grafo<String> grafo, String ciudad1, String ciudad2, ListaGenerica<String> ciudades,
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
                      DFSExceptuando(grafo, ciudad1, ciudad2, ciudades, i, ListaAux, visitados,r);
                      visitados[i] = false;
                      ListaAux.eliminar(vDestino.dato());
                  }
              }
          }
    }

}
