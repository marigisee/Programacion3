package prog3.empresa;

import prog3.arbolgeneral.ArbolGeneral;
import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
import prog3.util.ColaGenerica;
import prog3.Resultado.ResultadoInt;


public class Empresa extends ArbolGeneral<Empleado> {

    //Attributes
    private Empleado dato;

    //Constructor
    public Empresa() {

    }
    public Empresa(Empleado dato) {
        this.setDato(dato);
    }

    //Setters and Getters
    public void setDato(Empleado dato) {
        this.dato = dato;
    }

    public Empleado getDato() {
        return this.dato;
    }

    //Methods

    /**
     * Dado un número de categoría
     * devuelve la cantidad de empleados de dicha categoría.
     * @param categoria (número)
     * @return lista generica de empleados cuya categoria es la enviada
     */
    public ListaGenerica<Empleado> empleadosPorCategoria(int categoria) {
        boolean encontro = false;
        ListaGenerica<Empleado> l = new ListaGenericaEnlazada<Empleado>();
        ListaGenerica<ArbolGeneral<Empleado>> hijosAux = new ListaGenericaEnlazada<>();
        ArbolGeneral<Empleado> hijoAct = new ArbolGeneral<>();
        ColaGenerica<ArbolGeneral<Empleado>> cola = new ColaGenerica<>();
        ArbolGeneral<Empleado> arbolAux = new ArbolGeneral<>();
        cola.encolar(this);
        cola.encolar(null);
        while (!cola.esVacia()) {
            arbolAux = cola.desencolar(); //Desencolo un nodo del arbol
            if (!(arbolAux == null)) { //Si  no es null, no estamos pasando a otro nivel
                if (arbolAux.getDato().getCategoria() == categoria) {
                    l.agregarFinal(arbolAux.getDato());
                    encontro = true;
                } else {
                    if (!arbolAux.esHoja() && (!encontro)) { //Si no es hoja y todavia no encontró
                        hijosAux = arbolAux.getHijos(); //Obtenemos los hijos y los guardamos en una lista
                        hijosAux.comenzar();
                        while (!hijosAux.fin()) { //Recorremos la lista de los hijos
                            cola.encolar(hijosAux.proximo()); //Encolamos el nodo
                        }
                    }
                }
            }
            else{
                    if (!cola.esVacia()) {
                        cola.encolar(null);
                    }
                }
            }
            return l;
        }

    /**
     * Determina la categoría que cuenta con la mayor cantidad de empleados.
     * @return categoría máxima
     */
    public Integer categoriaConMasEmpleados(){
        Integer catMax=-1;
        Integer catAct=1;
        Integer cantEmpleados = 0;
        Integer cantEmpleadosMax = -1;
        ColaGenerica<ArbolGeneral<Empleado>> cola = new ColaGenerica<>();
        ArbolGeneral<Empleado> nodo = new ArbolGeneral<>();
        cola.encolar(this);
        cola.encolar(null);
        while (!cola.esVacia()){
            nodo = cola.desencolar();
            if (!(nodo==null)) {
                if (nodo.getDato().getCategoria()==catAct) {
                    cantEmpleados++;
                }
                if (!nodo.esHoja()) {
                    ListaGenerica<ArbolGeneral<Empleado>> hijos = new ListaGenericaEnlazada<>();
                    hijos =  nodo.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()){
                        cola.encolar(hijos.proximo());
                    }
                }
            }
            else {
                if (cantEmpleadosMax<cantEmpleados) {
                    catMax = catAct;
                    cantEmpleadosMax = cantEmpleados;
                }
                if (!cola.esVacia()){
                    cola.encolar(null);
                    cantEmpleados=0;
                    catAct++;
                }
            }


        }
    return catMax;}

    /**
     * Determina la cantidad total de empleados.
     * @return cantidad total de empleados
     */
    public Integer cantidadTotalDeEmpleados () {
        Integer total=0;
        ColaGenerica<ArbolGeneral<Empleado>> cola = new ColaGenerica<>();
        ArbolGeneral<Empleado> nodoAux = new ArbolGeneral<>();
        cola.encolar(this);
        cola.encolar(null);
        while (!cola.esVacia()) {
            nodoAux = cola.desencolar();
            if (!(nodoAux==null)) {
                total++;
                if (!nodoAux.esHoja()) {
                    ListaGenerica<ArbolGeneral<Empleado>> hijos = new ListaGenericaEnlazada<>();
                    hijos = nodoAux.getHijos();
                    hijos.comenzar();
                    while (!hijos.fin()) {
                        cola.encolar(hijos.proximo());
                    }
                }
            }
            else {
                if (!cola.esVacia()) {
                    cola.encolar(null);
                }
            }
        }
    return total;}

    /**
     *
     */
    public void reemplazarPresidente() {

    }

}


