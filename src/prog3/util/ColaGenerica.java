package prog3.util;
import prog3.listagenerica.*;

public class ColaGenerica<T> {
    public ColaGenerica() {
    }

    private ListaGenericaEnlazada<T> cola = new ListaGenericaEnlazada<T>();

    /**
     * Agrega el elemento T al tope de la pila
     * @param elem
     */
    public void encolar(T elem) {
        cola.agregarFinal(elem);
    }

    /**
     * Desapila el último elemento de la pila
     * @return Último elemento de la pila.
     */
    public T desencolar() {
        T elem = cola.elemento(0);
        cola.eliminarEn(0);
        return elem;}

    /**
     * Devuelve el tope de la pila
     * @return Elemento en el tope de la pila
     */
    public T tope() {
        return cola.elemento(0);
    }

    /**
     * Devuelve si la pila esta vacia
     * @return true or false.
     **/
    public boolean esVacia() {
        return cola.esVacia();
    }

}
