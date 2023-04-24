package prog3.listaenteros;

/**
 * La clase ListaDeEnterosEnlazada es una ListaDeEnteros, donde los elementos de
 * la lista (nodos) referencian al siguiente elemento (nodo), por este motivo,
 * la ListaDeEnterosEnlazada no tiene límite en la cantidad de elementos que se
 * pueden almacenar.
 * */
public class ListaDeEnterosEnlazada extends ListaDeEnteros {
	/* primer nodo de la lista, si la lista esta vacia, inicio es null */
	private NodoEntero inicio;

	/*
	 * nodo actual que se va actualizando a medida que recorremos la lista, si
	 * la lista esta vacia, actual es null
	 */
	private NodoEntero actual;

	/* ultimo nodo de la lista, si la lista esta vacia, fin es null */
	private NodoEntero fin;

	/* cantidad de nodos en la lista */
	private int tamanio;

	@Override
	public void comenzar() {
		actual = inicio;
	}

	@Override
	public Integer proximo() {
		Integer elem = this.actual.getDato();
		this.actual = this.actual.getSiguiente();
		return elem;
	}

	@Override
	public boolean fin() {
		return (this.actual == null);
	}

	@Override
	public Integer elemento(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // no es posición valida
			return null;
		NodoEntero n = this.inicio;
		while (pos-- > 0)
			n = n.getSiguiente();
		return n.getDato();
	}

	@Override
	public boolean agregarEn(Integer elem, int pos) {
		if (pos < 0 || pos > this.tamanio()) // posicion no valida
			return false;
		this.tamanio++;
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if (pos == 0) { // inserta al principio
			aux.setSiguiente(inicio);
			this.inicio = aux;
		} else {
			NodoEntero n = this.inicio;
			NodoEntero ant = null;
			int posActual = 0;
			while (!(n == null) && (posActual < pos)) {
				ant = n;
				n = n.getSiguiente();
				posActual++;
			}
			aux.setSiguiente(n);
			ant.setSiguiente(aux);

			if (aux.getSiguiente() == null)
				this.fin = aux;
		}
		return true;
	}

	@Override
	public boolean agregarInicio(Integer elem) {
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);

		if (this.inicio == null) {
			this.inicio = aux;
			this.actual = aux;
			this.fin = aux;
		} else {
			aux.setSiguiente(this.inicio);
			this.inicio = aux;
		}
		this.tamanio++;
		return true;
	}

	@Override
	public boolean agregarFinal(Integer elem) {
		NodoEntero aux = new NodoEntero();
		aux.setDato(elem);
		if (this.inicio == null) {
			this.inicio = aux;
			this.actual = aux;
			this.fin = aux;
		} else {
			fin.setSiguiente(aux);
			fin = aux;
		}
		tamanio++;
		return true;
	}

	@Override
	public boolean eliminar(Integer elem) {
		NodoEntero n = this.inicio;
		NodoEntero ant = null;
		while ((n != null) && (!n.getDato().equals(elem))) {
			ant = n;
			n = n.getSiguiente();
		}
		if (n == null)
			return false;
		else {
			if (ant == null)
				this.inicio = this.inicio.getSiguiente();
			else
				ant.setSiguiente(n.getSiguiente());
			this.tamanio--;

			return true;
		}
	}

	@Override
	public boolean eliminarEn(int pos) {
		if (pos < 0 || pos > this.tamanio() - 1) // posicion no valida
			return false;
		this.tamanio--;
		if (pos == 0) {
			this.inicio = this.inicio.getSiguiente();
			return true;
		}
		NodoEntero n = this.inicio;
		NodoEntero ant = null;
		while (!(n == null) && (pos > 0)) {
			pos--;
			ant = n;
			n = n.getSiguiente();
		}
		ant.setSiguiente(n.getSiguiente());
		if (ant.getSiguiente() == null)
			this.fin = ant;
		return true;
	}

	@Override
	public boolean incluye(Integer elem) {
		NodoEntero n = this.inicio;
		while (!(n == null) && !(n.getDato().equals(elem)))
			n = n.getSiguiente();
		return !(n == null);
	}

	@Override
	public String toString() {
		String str = "";
		NodoEntero n = this.inicio;
		while (n != null) {
			str = str + n.getDato() + " -> ";
			n = n.getSiguiente();
		}
		if (str.length() > 1)
			str = str.substring(0, str.length() - 4);
		return str;
	}

	@Override
	public int tamanio() {
		return this.tamanio;
	}

	@Override
	public boolean esVacia() {
		return this.tamanio() == 0;
	}

	public static ListaDeEnterosEnlazada ordenar(ListaDeEnterosEnlazada l) {
		ListaDeEnterosEnlazada resultado = new ListaDeEnterosEnlazada();
		resultado.comenzar();
		NodoEntero aux = l.inicio;
		int min = 9999;
		for (int i = 0; i<l.tamanio; i++) {
			 while (aux !=null) {
				 if ((aux.getDato() < min) & (!resultado.incluye(aux.getDato()))) {
					 min = aux.getDato();
				 }
				 aux=aux.getSiguiente();
			 }
			 resultado.agregarFinal(min);
			 min=9999;
			 aux=l.inicio;
		}
	return resultado;}


/*
	public ListaDeEnterosEnlazada combinarOrdenado (ListaDeEnterosEnlazada listaParametros){

		ListaDeEnterosEnlazada r = new ListaDeEnterosEnlazada();

		NodoEntero principio = listaParamametros.inicio;
		int n;
		int contador=0;
		r.comenzar();
		NodoEntero aux1 = this.inicio;
		for (int i = 0;i<(this.tamanio);i++){
			r.agregarFinal(aux1.getDato());
			aux1 = aux1.getSiguiente();
		}

		aux1 = listaParamametros.inicio; //Lista donde vamos a sacar los elementos a agregar.
		NodoEntero aux2 = r.inicio; //Inicio de la lista resultado.
		n = aux1.getDato(); //Dato de la lista donde vamos a sacar los elementos.

		for (int i = 0;i<listaParamametros.tamanio;i++){


			 * Recorremos la lista nueva r y buscamos el lugar para insertar el dato de la lista listaParametros


			while ((n>aux2.getDato()) & (aux2.getSiguiente()!=null) & (!r.incluye(n))) {
				aux2 = aux2.getSiguiente();
				contador++;
			}

			r.agregarEn(n,contador);
			contador=0;
			aux1=aux1.getSiguiente();
			aux2=r.inicio;
			n=aux2.getDato();

		}

		return r;}

*/
	 public ListaDeEnterosEnlazada combinarOrdenado  (ListaDeEnterosEnlazada listaParametros) {

		    ListaDeEnterosEnlazada r = new ListaDeEnterosEnlazada();

			listaParametros.comenzar();
			while (!listaParametros.fin()) {
				 r.agregarFinal(listaParametros.proximo());
			}

			this.comenzar();
			r.comenzar();
			int aux = r.inicio.getDato();
			int n = this.elemento(0);
			int counter = 0;
			/*
			* Vamos a obtener los enteros de this
			* Y se los agregamos de manera ordenada a r
			* */
			for (int i=0;i<this.tamanio();i++) {
				n = this.elemento(i);
				while ((!r.incluye(n)) && (r.actual!=null) && (n>r.actual.getDato())) {
					aux=r.proximo();
					counter++;
				}
				r.agregarEn(n,counter);
				counter=0;
				r.comenzar();
			}
	 return r;}




}





