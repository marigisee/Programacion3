package prog3.practicaGrafos.Algoritmos;

import prog3.grafos.*;

public class testAlgoritmos {

    public static void main(String[] args) {
        Algoritmos a = new Algoritmos();
        //Grafo ciclico//
        Grafo<String> grafo1 = crearGrafo1();
        //Grafo aciclico//
        Grafo<String> grafo2 = crearGrafo2();
        boolean encontro = a.SubgrafoCuadrado(grafo1);

        if (encontro) {
            System.out.println("El digrafo es cuadrado");
        }
        else {
                System.out.println("El digrafo no es cuadrado");
            }

        System.out.println("El grado del grafo es:"+a.getGrado(grafo1));

        if (a.tieneCiclo(grafo2)) {
            System.out.println("El grafo tiene al menos un ciclo");
        }
        else {
            System.out.println("El grafo es acíclico");
        }

    }

    //Grafo ciclico//
    public static Grafo<String> crearGrafo1() {

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

        ciudades.conectar(v1, v2); //Buenos Aires → Santiago//
        ciudades.conectar(v1, v3); //Buenos Aires → Lima//
        ciudades.conectar(v4, v1); //Montevideo → Buenos Aires//
        ciudades.conectar(v1, v5); //Buenos Aires → Asuncion//
        ciudades.conectar(v5, v2); //Asuncion → Santiago //
        ciudades.conectar(v2, v7); //Santiago → La Habana//
        ciudades.conectar(v3, v5); //Lima → Asuncion//
        ciudades.conectar(v5, v4); //Asuncion → Montevideo//
        ciudades.conectar(v5, v6); //Asuncion → Caracas//
        ciudades.conectar(v6, v7); //Caracas → La Habana//


        return ciudades;
    }

    //Grafo aciclico//
    public static Grafo<String> crearGrafo2() {

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

}
