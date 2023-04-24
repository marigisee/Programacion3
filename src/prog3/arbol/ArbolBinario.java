package prog3.arbol;
import prog3.listagenerica.*;
import prog3.util.ColaGenerica;
import prog3.Resultado.*;

public class ArbolBinario<T> {
	private T dato;
	private ArbolBinario<T> hijoIzquierdo;   
	private ArbolBinario<T> hijoDerecho; 

	
	public ArbolBinario() {
		super();
	}

	public ArbolBinario(T dato) {
		this.dato = dato;
	}

	/*
	 * getters y setters
	 * 
	 */

	public Integer getDato() {
		return (Integer) dato;
	}

	public void setDato(T dato) {
		this.dato = dato;
	}
	

	public ArbolBinario<T> getHijoIzquierdo() {
		return this.hijoIzquierdo;
	}

	public ArbolBinario<T> getHijoDerecho() {
		return this.hijoDerecho;

	}

	public void agregarHijoIzquierdo(ArbolBinario<T> hijo) {
		this.hijoIzquierdo = hijo;
	}

	public void agregarHijoDerecho(ArbolBinario<T> hijo) {
		this.hijoDerecho = hijo;
	}

	public void eliminarHijoIzquierdo() {
		this.hijoIzquierdo = null;
	}

	public void eliminarHijoDerecho() {
		this.hijoDerecho = null;
	}

	public boolean esVacio() {
		return this.getDato() == null && !this.tieneHijoIzquierdo() && !this.tieneHijoDerecho();
	}

	public boolean esHoja() {
		return (!this.tieneHijoIzquierdo() && !this.tieneHijoDerecho());

	}

	@Override
	public String toString() {
		return this.getDato().toString();
	}

	 
	public boolean tieneHijoIzquierdo() {
		return this.hijoIzquierdo!=null;
	}

	 
	public boolean tieneHijoDerecho() {
		return this.hijoDerecho!=null;
	}


	/**
	 * Se procesa primero la raíz y luego sus hijos, izquierdo y derecho
	 */
	public void printPreorden() {
		System.out.println(this.dato);
		if (this.hijoIzquierdo != null) {
			this.hijoIzquierdo.printPreorden();
		}
		if (this.hijoDerecho!= null) {
			this.hijoDerecho.printPreorden();
		}
	}


	/**
	 * Se procesa el hijo izquierdo, luego la raíz y último el hijo derecho
	 * */
	public void printInOrden() {
		if (this.hijoIzquierdo !=null) {
			this.hijoIzquierdo.printInOrden();
		}
		System.out.println(this.dato);
		if (this.hijoDerecho != null) {
			this.hijoDerecho.printInOrden();
		}
	}


	/***
	 *Se procesan primero los hijos, izquierdo y derecho, y luego la raíz
	 */
	public void printPostOrden() {
		if (this.hijoIzquierdo != null) {
			this.hijoIzquierdo.printPostOrden();
		}
		if (this.hijoDerecho != null) {
			this.hijoDerecho.printPostOrden();
			}
		System.out.println(this.dato);
		}

	public void recorridoPorNiveles() {
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				System.out.print(arbol.getDato());
				if (arbol.tieneHijoIzquierdo()) {
					cola.encolar(arbol.getHijoIzquierdo());
				}
				if (arbol.tieneHijoDerecho()) {
					cola.encolar(arbol.getHijoDerecho());
				}
			}
			else if (!cola.esVacia()){
				System.out.println();
				cola.encolar(null);
			}
		}
	}

	public ListaGenerica<T> frontera() {
		ListaGenerica<T> l = new ListaGenericaEnlazada<T>();
		l.comenzar();
		return this.fronteraRecursion(l);
	}

	public ListaGenerica<T> fronteraRecursion(ListaGenerica<T> l){
		if (this.esHoja()) {
			l.agregarFinal(this.dato);
			return l;
		}
		else {
			if (this.tieneHijoIzquierdo()){
				this.hijoIzquierdo.fronteraRecursion(l);
			}
			if (this.tieneHijoDerecho()){
				this.hijoDerecho.fronteraRecursion(l);
			}
		}
		return l;
	}

	public int contarHojas() {
		if (this.esHoja()) {
			return 1;
		} else {
			int c = 0;
			if (this.tieneHijoIzquierdo()) {
				c += this.hijoIzquierdo.contarHojas();
			}
			if (this.tieneHijoDerecho()) {
				c += this.hijoDerecho.contarHojas();
			}
			return c;
		}
	}

	/**
	 *  Devuelve true si el árbol es lleno. Un árbol binario es
	 * 	lleno si tiene todas las hojas en el mismo nivel y además tiene todas las hojas
	 * 	posibles (es decir todos los nodos intermedios tienen dos hijos).
	 */
	public boolean esLleno() {
		boolean lleno = true;
		int contadorNivel = 0;
		int contadorNodos = 0;
		ArbolBinario<T> arbol = null;
		ColaGenerica<ArbolBinario<T>> cola = new ColaGenerica<ArbolBinario<T>>();
		cola.encolar(this);
		cola.encolar(null);
		while (!cola.esVacia() && lleno)
		 {
			arbol = cola.desencolar();
			if (arbol != null) {
				if (arbol.tieneHijoIzquierdo()) {
					cola.encolar(arbol.getHijoIzquierdo());
					contadorNodos = contadorNodos + 1;
				}
				if (arbol.tieneHijoDerecho()) {
					cola.encolar(arbol.getHijoDerecho());
					contadorNodos = contadorNodos + 1;
				}
			}
			else if (!cola.esVacia()){
				if (contadorNodos == Math.pow(2,++contadorNivel)) { //cantidadNodos = 2^(n)// (si se cumple la condicion?)
					cola.encolar(null);
					contadorNodos = 0;
				}
				else
					lleno = false; //Si no se cumple la condición el arbo no es lleno
			}
		}
	return lleno;}

	public boolean esCompleto() {
	return true;}

	/**
	 * Se quiere saber cuál es la suma de mayor valor, recorriendo
	 * el árbol desde la raíz hacia las hojas.
	 */
	public int sumaMaximaVertical() {
		ResultadoInt res = new ResultadoInt();
		res.setDato(0);
		sumaMaximaVerticalRec(0, res, (ArbolBinario<Integer>) this);
		System.out.println("----Suma máxima vertical----");
		System.out.println("Suma max = "+ res.getDato());
		return res.getDato();
	}

	public static void sumaMaximaVerticalRec(int cont, ResultadoInt max, ArbolBinario<Integer> a) {
		if (!a.esVacio()) {
			if (a.esHoja()) {
				cont += a.getDato();
				if (max.getDato() < cont) {
					max.setDato(cont);
				}
			} else {
				if (a.tieneHijoIzquierdo()) {
					sumaMaximaVerticalRec(cont + a.getDato(), max, a.getHijoIzquierdo());
				}
				if (a.tieneHijoDerecho()) {
					sumaMaximaVerticalRec(cont + a.getDato(), max, a.getHijoDerecho());
				}
			}
		}
	}

	/**
	 * Devuelve la suma máxima considerando que los valores a sumar deben
	 * pertenecer al mismo nivel
	 */
	public int sumaMaximaHorizontal(){
		int suma = 0;
		int max = -5;
		int nivelMax = 0;
		int contadorNiveles = 0;
		ArbolBinario<Integer> arbol = null;
		ColaGenerica<ArbolBinario<Integer>> cola = new ColaGenerica<ArbolBinario<Integer>>();
		cola.encolar((ArbolBinario<Integer>) this);
		cola.encolar(null);
		while (!cola.esVacia()) {
			arbol = cola.desencolar();
			if (arbol != null) {
				suma = suma + arbol.getDato();
				if (arbol.tieneHijoIzquierdo()) {
					cola.encolar(arbol.getHijoIzquierdo());
				}
				if (arbol.tieneHijoDerecho()) {
					cola.encolar(arbol.getHijoDerecho());
				}
			}
			//me falta una condicion para que procese esto por mas que termine
			else if (!cola.esVacia()){
				if (suma>max) {
					max = suma;
					nivelMax = contadorNiveles;
				}
				suma = 0;
				contadorNiveles++;
				cola.encolar(null);
			}
		}
		if (suma>max) {
			 max = suma;
			 nivelMax = contadorNiveles;
		}
		System.out.println("----Suma máxima horizontal----");
		System.out.println("Suma max = "+ suma + ". Nivel max = "+nivelMax);
		return max;}
}



