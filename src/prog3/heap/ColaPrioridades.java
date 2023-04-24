package prog3.heap;

public interface ColaPrioridades<T extends Comparable<T>> {
    public boolean esVacia();
    public void eliminar();
    public boolean agregar(T dato);
    public void tope();
}
