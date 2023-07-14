package prog3.ParcialesModulo1.ArbolBinario.Parcial1;
import prog3.arbol.*;
import prog3.arbolgeneral.ArbolGeneral;

public class Parcial1AB {
    public static void main(String[] args) {
        ArbolBinario<Character> a = crearArbol2();
        a.recorridoPorNiveles();
        System.out.println("Procesamiento del arbol");
        ProcesadorDeArbol2 p = new ProcesadorDeArbol2(a);
        System.out.println("Cantidad de caminos:"+p.procesar(2));
    }

    /*
    *       a
    *      /
    *      c
    *    /  \
    *   m     o
    *    \   / \
    *     p q   z
    * */
    public static ArbolBinario<Character> crearArbol1() {
        ArbolBinario<Character> arbol = new ArbolBinario<Character>();
        arbol.setDato('a');
        ArbolBinario<Character> c = new ArbolBinario<Character>();
        c.setDato('c');
        ArbolBinario<Character> m = new ArbolBinario<Character>();
        m.setDato('m');
        ArbolBinario<Character> p = new ArbolBinario<Character>();
        p.setDato('p');
        ArbolBinario<Character> o = new ArbolBinario<Character>();
        o.setDato('o');
        ArbolBinario<Character> q = new ArbolBinario<Character>();
        q.setDato('q');
        ArbolBinario<Character> z = new ArbolBinario<Character>();
        z.setDato('z');
        arbol.agregarHijoIzquierdo(c);
        c.agregarHijoIzquierdo(m);
        c.agregarHijoDerecho(o);
        m.agregarHijoDerecho(p);
        o.agregarHijoIzquierdo(q);
        o.agregarHijoDerecho(z);
    return arbol;}


    /*
     *         p
     *      /    \
     *      z     g
     *    /       /
     *   u       o
     *  / \     /
     * a   b   t
     *      \
     *       s
     * */
    public static ArbolBinario<Character> crearArbol2() {
        ArbolBinario<Character> arbol = new ArbolBinario<Character>();
        arbol.setDato('p');
        ArbolBinario<Character> z = new ArbolBinario<Character>();
        z.setDato('z');
        ArbolBinario<Character> u = new ArbolBinario<Character>();
        u.setDato('u');
        ArbolBinario<Character> a = new ArbolBinario<Character>();
        a.setDato('a');
        ArbolBinario<Character> b = new ArbolBinario<Character>();
        b.setDato('b');
        ArbolBinario<Character> s = new ArbolBinario<Character>();
        s.setDato('s');
        ArbolBinario<Character> g = new ArbolBinario<Character>();
        g.setDato('g');
        ArbolBinario<Character> o = new ArbolBinario<Character>();
        o.setDato('o');
        ArbolBinario<Character> t = new ArbolBinario<Character>();
        t.setDato('t');

        //SubArbol Izquierdo//
        arbol.agregarHijoIzquierdo(z);
        z.agregarHijoIzquierdo(u);
        u.agregarHijoIzquierdo(a);
        u.agregarHijoDerecho(b);
        b.agregarHijoDerecho(s);
        //SubArbol Derecho//
        arbol.agregarHijoDerecho(g);
        g.agregarHijoIzquierdo(o);
        o.agregarHijoIzquierdo(t);
    return arbol;}

}
