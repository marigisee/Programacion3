package prog3.arbolgeneral;

import prog3.listagenerica.ListaGenerica;
import prog3.listagenerica.ListaGenericaEnlazada;
import prog3.util.*;

public class ArbolGeneral<T> {

	private T dato;

	private ListaGenerica<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();

	public ArbolGeneral() {

	}

	public T getDato() {
		return dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}

	public void setHijos(ListaGenerica<ArbolGeneral<T>> hijos) {
		this.hijos = hijos;
	}

	public ArbolGeneral(T dato) {
		this.dato = dato;
		this.hijos = new ListaGenericaEnlazada<ArbolGeneral<T>>();
	}

	public ArbolGeneral(T dato, ListaGenerica<ArbolGeneral<T>> hijos) {
		this(dato);
		this.hijos = hijos;
	}

	public ListaGenerica<ArbolGeneral<T>> getHijos() {
		return this.hijos;
	}

	public void agregarHijo(ArbolGeneral<T> unHijo) {

		this.getHijos().agregarFinal(unHijo);
	}

	public boolean esHoja() {

		return !this.tieneHijos();
	}

	public boolean tieneHijos() {
		return this.hijos != null && !this.hijos.esVacia();
	}

	public boolean esVacio() {

		return this.dato == null && !this.tieneHijos();
	}


	public void eliminarHijo(ArbolGeneral<T> hijo) {
		if (this.tieneHijos()) {
			ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
			if (hijos.incluye(hijo))
				hijos.eliminar(hijo);
		}
	}

	public ListaGenericaEnlazada<T> preOrden() {
		return null;
	}

	/**
	 * Devuelve la altura del árbol, es decir, la
	 * longitud del camino más largo desde el nodo raíz hasta una hoja.
	 *
	 * @return Altura del arbol.
	 */
	public Integer altura() {
		if (!this.esVacio()) {
			if (this.esHoja()) {
				return 0;
			} else {
				ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
				ArbolGeneral<T> unHijo = null;
				Integer maximo = 0;
				Integer altCalc = 0;
				hijos.comenzar();
				while (!hijos.fin()) {
					unHijo = hijos.proximo();
					altCalc = unHijo.altura();
					if (maximo < altCalc)
						maximo = altCalc;
				}
				return 1 + maximo;
			}
		}
		return 0;
	}

	/**
	 * Boolean que devuelve true si dato se encuentra en el árbol, y false en caso contrario.
	 * @param dato a buscar
	 * @param n
	 * @return boolean
	 */
	public boolean include(T dato, Integer n) {
		boolean res = false;
		if (this.esVacio()) {
			return false;
		} else {
			if (this.esHoja()) {
				return this.getDato() == dato;
			} else {
				if (this.getDato() == dato) {
					return true;
				} else {
					ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
					if (this.tieneHijos()) {
						hijos.comenzar();
						while ((!hijos.fin()) && (!res)) {
							res = hijos.proximo().include(dato, n);
						}
					}
					return res;
				}
			}
		}
	}


	public Integer nivel(T dato) {
		Integer nivel = 0;
		ResultadoBoolean encontro = new ResultadoBoolean(false);
		return this.nivelRec(dato, 0, encontro);
	}

	public Integer nivelRec(T dato, Integer nivel, ResultadoBoolean encontro) {
		if (this.esVacio()) {
			return -1;
		} else {
			if (this.esHoja()) {
				encontro.setDato(this.dato == dato);
				return nivel;
			} else {
				encontro.setDato(this.dato == dato);
				if (!encontro.getDato()) {
					Integer aux = 0;
					ArbolGeneral<T> nodoAct = new ArbolGeneral<>();
					ListaGenerica<ArbolGeneral<T>> hijos = this.getHijos();
					hijos.comenzar();
					while ((!hijos.fin()) & (!encontro.getDato())) {
						nodoAct = hijos.proximo();
						aux = nivel;
						nivel = nodoAct.nivelRec(dato, nivel + 1, encontro);
						if (!encontro.getDato()){
							nivel = aux;
						}
					}
				}
			}
		}
		return nivel;
	}


	public Integer ancho() {
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<>();
		ListaGenerica<ArbolGeneral<T>> hijos = new ListaGenericaEnlazada<>();
		ArbolGeneral<T> hijoAct = new ArbolGeneral<T>();
		cola.encolar(this);
		cola.encolar(null);
		Integer max = -1;
		Integer tamanio = 0;
		ArbolGeneral<T> arbolAux;
		while (!cola.esVacia()) {
			arbolAux = cola.desencolar();
			if (!(arbolAux == null)) {
				hijos = arbolAux.getHijos();
				hijos.comenzar();
				tamanio += hijos.tamanio();
				while (!hijos.fin()) { //Recorro la lista hijos encolando sus hijos
					hijoAct = hijos.proximo();
					if (hijoAct.tieneHijos()) {
						cola.encolar(hijoAct);
					}
				}
			} else {
				if (tamanio > max) {
					max = tamanio;
				}
				if (!cola.esVacia()) {
					cola.encolar(null);
					if (tamanio > max) {
						max = tamanio;
					}
					tamanio = 0;
				}
			}
		}
		return max;
	}


	public void recorridoPorNiveles() {
		ArbolGeneral<T> arbol = null;
		ColaGenerica<ArbolGeneral<T>> cola = new ColaGenerica<ArbolGeneral<T>>();
		cola.encolar(this);
		cola.encolar(null);
		int nivel = 0;
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				System.out.print(arbol.getDato());
				if (arbol.tieneHijos()) {
					ListaGenerica<ArbolGeneral<T>> l = arbol.getHijos();
					while (!l.fin()) {
						cola.encolar(l.proximo());
					}
				}
			} else if (!cola.esVacia()) {
				cola.encolar(null);
				System.out.println();
			}
		}
	}


}
