package prog3.problemaCiudades;

import prog3.grafos.Grafo;
import prog3.grafos.GrafoImplListAdy;
import prog3.grafos.Vertice;
import prog3.grafos.VerticeImplListAdy;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;

public class testMapa2Pesado {
    public static void main(String[] args) {
        //testCaminoMasCorto();
        testCaminoSinCombustible();
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

        ciudades.conectar(v1, v2,3);
        ciudades.conectar(v1, v3,2);
        ciudades.conectar(v1, v4,4);
        ciudades.conectar(v1, v5,10);
        ciudades.conectar(v2, v5,500);
        ciudades.conectar(v2, v7,4);
        ciudades.conectar(v3, v5,4);
        ciudades.conectar(v4, v5,6);
        ciudades.conectar(v5, v6,11);
        ciudades.conectar(v6, v7,10);


        return ciudades;
    }

    public static void testCaminoMasCorto() {
        Grafo<String> ciudades = crearGrafo();

        String ciudad1 = "Santiago";
        String ciudad2 = "Lima";

        System.out.println("Buscamos el camino más corto entre " + ciudad1 + " y " + ciudad2);
        Mapa c = new Mapa(ciudades);
        ListaGenerica<String> caminos = c.caminoMasCorto(ciudad1, ciudad2);
        if (caminos.esVacia()) {
            System.out.println("La lista esta vacia. No existe ningun camino entre "+ciudad1+" y "+ciudad2);
        } else
            System.out.println(caminos);
    }

    public static void testdevolverCaminoExceptuando() {
        Grafo<String> grafo = crearGrafo();
        String ciudad1 = "Santiago";
        String ciudad2 = "La Habana";

        Mapa m = new Mapa (grafo);

        ListaGenerica<String> ciudades = new ListaGenericaEnlazada<>();
        ciudades.agregarFinal("Santiago");
        ciudades.agregarFinal("Lima");

        System.out.println("Recorrido buscando camino desde " + ciudad1 + " hasta " + ciudad2 + " exceptuando las siguientes ciudades:"+ciudades);

        ListaGenerica<String> Caminos = new ListaGenericaEnlazada<>();

        Caminos = m.devolverCaminoExceptuando(ciudad1, ciudad2, ciudades);

        if (Caminos.esVacia()) {
            System.out.println("La lista esta vacia. El camino no existe.");
        } else {
            System.out.println(Caminos);

        }
    }

    public static void testCaminoSinCombustible(){
        Grafo<String> ciudades = crearGrafo();
        String ciudad1 = "Buenos Aires";
        String ciudad2 = "Asuncion";

        Mapa m = new Mapa (ciudades);

        ListaGenerica<String> Camino = m.caminoSinCargarCombustible(ciudad1,ciudad2,510);

        if (Camino.esVacia()) {
            System.out.println("La lista está vacia. No existe camino desde "+ciudad1+" hasta " + ciudad2 + " sin tener que cargar combustible.");
        }
        else {
            System.out.println(Camino);
        }

    }
}
