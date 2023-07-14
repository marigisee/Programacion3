package prog3.grafos.test;
import prog3.grafos.*;
import prog3.listagenerica.*;
import prog3.practicaGrafos.utiles.Recorridos;

public class testRecorridos {
    public static void main(String[] args) {

        Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
        Vertice<String> v2 = new VerticeImplListAdy<String>("Santiago");
        Vertice<String> v3 = new VerticeImplListAdy<String>("Lima");
        Vertice<String> v4 = new VerticeImplListAdy<String>("Montevideo");
        Vertice<String> v5 = new VerticeImplListAdy<String>("Asuncion");
        Vertice<String> v6 = new VerticeImplListAdy<String>("Caracas");
        Vertice<String> v7 = new VerticeImplListAdy<String>("La Habana");

        Grafo<String> ciudades = new GrafoImplListAdy<String>();

        ciudades.agregarVertice(v1);
        ciudades.agregarVertice(v2);
        ciudades.agregarVertice(v3);
        ciudades.agregarVertice(v4);
        ciudades.agregarVertice(v5);
        ciudades.agregarVertice(v6);
        ciudades.agregarVertice(v7);

        ciudades.conectar(v1, v2);
        ciudades.conectar(v1, v3);
        ciudades.conectar(v1, v4);
        ciudades.conectar(v1, v5);
        ciudades.conectar(v2, v5);
        ciudades.conectar(v2, v7);
        ciudades.conectar(v3, v5);
        ciudades.conectar(v4, v5);
        ciudades.conectar(v5, v6);
        ciudades.conectar(v6, v7);



        Recorridos<String> r = new Recorridos<String>();
        ListaGenerica <Vertice<String>> lisDFS = r.dfs(ciudades);
        System.out.println("---Se imprime el GRAFO con DFS---");
        lisDFS.comenzar();
        while(!lisDFS.fin()) {
            System.out.println(lisDFS.proximo().dato());
        }

        ListaGenerica <Vertice<String>> lisBFS = r.bfs(ciudades);
        System.out.println("---Se imprime el GRAFO con BFS---");
        lisBFS.comenzar();
        while(!lisBFS.fin()) {
            System.out.println(lisBFS.proximo().dato());
        }


    }
}

