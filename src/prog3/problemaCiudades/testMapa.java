package prog3.problemaCiudades;

import prog3.grafos.*;
import prog3.listagenerica.*;
import prog3.problemaCiudades.Mapa;

public class testMapa {
    public static void main(String[] args) {
        Mapa m = new Mapa();
        testdevolverCaminoExceptuando(m);
    }

    public static Grafo<String> crearGrafo() {

        Vertice<String> v1 = new VerticeImplListAdy<String>("Buenos Aires");
        Vertice<String> v2 = new VerticeImplListAdy<String>("Santiago");
        Vertice<String> v3 = new VerticeImplListAdy<String>("Lima");
        Vertice<String> v4 = new VerticeImplListAdy<String>("Montevideo");
        Vertice<String> v5 = new VerticeImplListAdy<String>("Asuncion");
        Vertice<String> v6 = new VerticeImplListAdy<String>("Caracas");
        Vertice<String> v7 = new VerticeImplListAdy<String>("La Habana");

        Grafo<String> ciudades = new GrafoImplListAdy<>();

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


        return ciudades;
    }

    public static void testdevolverCamino() {
        Grafo<String> ciudades = crearGrafo();

        String ciudad1 = "Santiago";
        String ciudad2 = "Lima";

        System.out.println("Recorrido buscando camino desde " + ciudad1 + " hasta " + ciudad2);
        Mapa c = new Mapa();
        ListaGenerica<String> caminos = new ListaGenericaEnlazada<>();
        caminos = c.devolverCamino(ciudades, ciudad1, ciudad2);
        if (caminos.esVacia()) {
            System.out.println("La lista esta vacia. El camino no existe.");
        } else
            System.out.println(caminos);
    }

    public static void testdevolverCaminoExceptuando(Mapa m) {
        Grafo<String> grafo = crearGrafo();
        String ciudad1 = "Buenos Aires";
        String ciudad2 = "La Habana";

        ListaGenerica<String> ciudades = new ListaGenericaEnlazada<>();
        ciudades.agregarFinal("Santiago");
        ciudades.agregarFinal("Montevideo");

        System.out.println("Recorrido buscando camino desde " + ciudad1 + " hasta " + ciudad2 + " exceptuando las siguientes ciudades:"+ciudades);

        ListaGenerica<String> Caminos = new ListaGenericaEnlazada<>();

        Caminos = m.devolverCaminoExceptuando(grafo, ciudad1, ciudad2, ciudades);

        if (Caminos.esVacia()) {
            System.out.println("La lista esta vacia. El camino no existe.");
        } else {
            System.out.println(Caminos);


        }
    }
}


