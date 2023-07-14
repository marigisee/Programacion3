package prog3.problemaCiudades;

import prog3.grafos.*;
import prog3.listagenerica.*;
import prog3.problemaCiudades.Mapa;

public class testMapa {
    public static void main(String[] args) {
        //testdevolverCamino();
        testdevolverCaminoExceptuando();
    }

    public static Grafo<String> crearGrafo() {

        GrafoImplListAdy<String> ciudades = new GrafoImplListAdy<>();
        int tamAntes = ciudades.listaDeVertices().tamanio();
        VerticeImplListAdy<String> vert1 = new VerticeImplListAdy<>("San Fernando");  /// El <> es igual a un <Integer>
        VerticeImplListAdy<String> vert2 = new VerticeImplListAdy<>("Lomas de Zamora");  /// El <> es igual a un <Integer>
        VerticeImplListAdy<String> vert3 = new VerticeImplListAdy<>("Necochea");  /// El <> es igual a un <Integer>
        VerticeImplListAdy<String> vert4 = new VerticeImplListAdy<>("Zárate");  /// El <> es igual a un <Integer>
        VerticeImplListAdy<String> vert5 = new VerticeImplListAdy<>("Dolores");  /// El <> es igual a un <Integer>
        VerticeImplListAdy<String> vert6 = new VerticeImplListAdy<>("Mercedes");  /// El <> es igual a un <Integer>
        VerticeImplListAdy<String> vert7 = new VerticeImplListAdy<>("Bahía Blanca");  /// El <> es igual a un <Integer>
        VerticeImplListAdy<String> vert8 = new VerticeImplListAdy<>("Tres de Febrero");  /// El <> es igual a un <Integer>
        VerticeImplListAdy<String> vert9 = new VerticeImplListAdy<>("Moreno");  /// El <> es igual a un <Integer>
        VerticeImplListAdy<String> vert10 = new VerticeImplListAdy<>("San Nicolas");  /// El <> es igual a un <Integer>
        VerticeImplListAdy<String> vert11 = new VerticeImplListAdy<>("Azul");  /// El <> es igual a un <Integer>
        VerticeImplListAdy<String> vert12 = new VerticeImplListAdy<>("Vicente Lopez");  /// El <> es igual a un <Integer>
        VerticeImplListAdy<String> vert13 = new VerticeImplListAdy<>("Pergamino");  /// El <> es igual a un <Integer>
        VerticeImplListAdy<String> vert14 = new VerticeImplListAdy<>("Mar del Plata");  /// El <> es igual a un <Integer>
        VerticeImplListAdy<String> vert15 = new VerticeImplListAdy<>("San Isidro");  /// El <> es igual a un <Integer>
        VerticeImplListAdy<String> vert16 = new VerticeImplListAdy<>("Exaltación de la Cruz");  /// El <> es igual a un <Integer>
        VerticeImplListAdy<String> vert17 = new VerticeImplListAdy<>("Pinamar");  /// El <> es igual a un <Integer>
        VerticeImplListAdy<String> vert18 = new VerticeImplListAdy<>("Pilar");  /// El <> es igual a un <Integer>
        ciudades.agregarVertice(vert1);  // Está bien la conección
        ciudades.agregarVertice(vert2);
        ciudades.agregarVertice(vert3);
        ciudades.agregarVertice(vert4);
        ciudades.agregarVertice(vert5);
        ciudades.agregarVertice(vert6);
        ciudades.agregarVertice(vert7);
        ciudades.agregarVertice(vert8);
        ciudades.agregarVertice(vert9);
        ciudades.agregarVertice(vert10);
        ciudades.agregarVertice(vert11);
        ciudades.agregarVertice(vert12);
        ciudades.agregarVertice(vert13);
        ciudades.agregarVertice(vert14);
        ciudades.agregarVertice(vert15);
        ciudades.agregarVertice(vert16);
        ciudades.agregarVertice(vert17);
        ciudades.agregarVertice(vert18);

        ciudades.conectar(vert1, vert2);
        ciudades.conectar(vert1, vert3);
        ciudades.conectar(vert16, vert1);
        ciudades.conectar(vert16, vert2);
        ciudades.conectar(vert16, vert9);
        ciudades.conectar(vert2, vert5);
        ciudades.conectar(vert2, vert6);
        ciudades.conectar(vert2, vert9);
        ciudades.conectar(vert3, vert4);
        ciudades.conectar(vert3, vert5);
        ciudades.conectar(vert5, vert1);
        ciudades.conectar(vert5, vert2);
        ciudades.conectar(vert9, vert6);
        ciudades.conectar(vert6, vert9);
        ciudades.conectar(vert4, vert5);
        ciudades.conectar(vert4, vert7);
        ciudades.conectar(vert7, vert6);
        ciudades.conectar(vert7, vert11);
        ciudades.conectar(vert8, vert3);
        ciudades.conectar(vert8, vert4);
        ciudades.conectar(vert8, vert7);
        ciudades.conectar(vert8, vert12);
        ciudades.conectar(vert10, vert7);
        ciudades.conectar(vert12, vert10);
        ciudades.conectar(vert12, vert18);
        ciudades.conectar(vert14, vert12);
        ciudades.conectar(vert14, vert10);
        ciudades.conectar(vert14, vert15);
        ciudades.conectar(vert18, vert12);
        ciudades.conectar(vert17, vert15);

        return ciudades;
    }

    public static void testdevolverCamino() {
        Grafo<String> ciudades = crearGrafo();

        String ciudad1 = "San Fernando";
        String ciudad2 = "Dolores";

        System.out.println("Recorrido buscando camino desde " + ciudad1 + " hasta " + ciudad2);
        Mapa c = new Mapa(ciudades);
        ListaGenerica<String> caminos = c.devolverCamino(ciudad1, ciudad2);
        if (caminos.esVacia()) {
            System.out.println("La lista esta vacia. El camino no existe.");
        } else
            System.out.println(caminos);
    }

    public static void testdevolverCaminoExceptuando() {
        Grafo<String> grafo = crearGrafo();
        String ciudad1 = "Buenos Aires";
        String ciudad2 = "Asuncion";

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
}


