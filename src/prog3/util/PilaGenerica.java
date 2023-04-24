package prog3.util;
import prog3.listagenerica.*;
public class PilaGenerica<T> {

    public PilaGenerica() {
    }

    private ListaGenericaEnlazada<T> pila = new ListaGenericaEnlazada<T>();

    /**
     * Agrega el elemento T al tope de la pila
     * @param elem
     */
    public void apilar(T elem) {
        pila.agregarFinal(elem);
    }

    /**
     * Desapila el último elemento de la pila
     * @return Último elemento de la pila.
     */
    public T desapilar() {
        T elem = pila.elemento(pila.tamanio()-1);
        pila.eliminarEn(pila.tamanio()-1);
    return elem;}

    /**
     * Devuelve el tope de la pila
     * @return Elemento en el tope de la pila
     */
    public T tope() {
        return pila.elemento(pila.tamanio()-1);
    }

    /**
     * Devuelve si la pila esta vacia
     * @return true or false.
     **/
    public boolean esVacia() {
        return pila.esVacia();
    }

}
