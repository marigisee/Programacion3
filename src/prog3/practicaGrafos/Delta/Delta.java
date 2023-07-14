package prog3.practicaGrafos.Delta;

import prog3.listagenerica.ListaGenerica;
import prog3.grafos.*;

public class Delta <T> {

    public static void main(String[] args) {
        Grafo<String> grafo = crearGrafoNoDirigido();


    }
    public static Grafo<String> crearGrafoNoDirigido () {

            Vertice<String> vertice1 = new VerticeImplListAdy<String>("Saladillo");
            Vertice<String> vertice2 = new VerticeImplListAdy<String>("Navarro");
            Vertice<String> vertice3 = new VerticeImplListAdy<String>("Lobos");
            Vertice<String> vertice4 = new VerticeImplListAdy<String>("Cañuelas");
            Vertice<String> vertice5 = new VerticeImplListAdy<String>("Suipacha");
            Vertice<String> vertice6 = new VerticeImplListAdy<String>("Carlos Keen");
            Vertice<String> vertice7 = new VerticeImplListAdy<String>("Abasto");
            Vertice<String> vertice8 = new VerticeImplListAdy<String>("Moreno");
            Vertice<String> vertice9 = new VerticeImplListAdy<String>("La Plata");
            Vertice<String> vertice10 = new VerticeImplListAdy<String>("Quilmes");
            Vertice<String> vertice11 = new VerticeImplListAdy<String>("Pinamar");

            Grafo<String> ciudades = new GrafoImplListAdy<String>();

            ciudades.agregarVertice(vertice1);
            ciudades.agregarVertice(vertice2);
            ciudades.agregarVertice(vertice3);
            ciudades.agregarVertice(vertice4);
            ciudades.agregarVertice(vertice5);
            ciudades.agregarVertice(vertice6);
            ciudades.agregarVertice(vertice7);
            ciudades.agregarVertice(vertice8);
            ciudades.agregarVertice(vertice9);
            ciudades.agregarVertice(vertice10);
            ciudades.agregarVertice(vertice11);

            //Saladillo - Navarro//
            ciudades.conectar(vertice1, vertice2,40);
            ciudades.conectar(vertice2, vertice1,40);

            //Lobos - Navarro//
            ciudades.conectar(vertice3, vertice2,20);
            ciudades.conectar(vertice2, vertice3,20);

            //Navarro - Cañuelas//
            ciudades.conectar(vertice2, vertice4,40);
            ciudades.conectar(vertice2, vertice4,40);

            //Navarro - Suipacha//
            ciudades.conectar(vertice2, vertice5,30);
            ciudades.conectar(vertice5, vertice2,30);

            //Cañuelas - Abasto//
            ciudades.conectar(vertice4, vertice7,180);
            ciudades.conectar(vertice7, vertice4,180);

            //Carlos Keen - Suipacha//
            ciudades.conectar(vertice6, vertice5,50);
            ciudades.conectar(vertice5, vertice6,50);

            //Carlos Keen - Moreno//
            ciudades.conectar(vertice6, vertice8,100);
            ciudades.conectar(vertice8, vertice6,100);

            //Moreno - Abasto//
            ciudades.conectar(vertice8, vertice7,100);
            ciudades.conectar(vertice7, vertice8,100);

            //Abasto - La Plata//
            ciudades.conectar(vertice7, vertice9,15);
            ciudades.conectar(vertice9, vertice7,15);

            //Moreno - Quilmes//
            ciudades.conectar(vertice8, vertice10,40);
            ciudades.conectar(vertice10, vertice8,40);

            //La Plata - Quilmes//
            ciudades.conectar(vertice9, vertice10,40);
            ciudades.conectar(vertice10, vertice9,40);

            //La Plata - Pinamar//
            ciudades.conectar(vertice9, vertice11,350);
            ciudades.conectar(vertice11, vertice9,350);



        return ciudades;}
    }

    /**
    maxIslasDistintas(Grafo<String> grafo) : int // Retorna el número máximo de islas distintas
    que se pueden recorrer en el grafo comprando un único boleto.**/

