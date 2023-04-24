package prog3.empresa;
import prog3.arbolgeneral.*;
import prog3.listagenerica.*;
import prog3.util.*;
public class Empleado  {

    String nombre;
    int antiguedad;
    int categoria;


    public Empleado(String nombre, int antiguedad,int categoria) {
        this.nombre = nombre;
        this.antiguedad = antiguedad;
        this.categoria = categoria;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAntiguedad() {
        return antiguedad;
    }

    public void setAntiguedad(int antiguedad) {
        this.antiguedad = antiguedad;
    }

    public int getCategoria() {
        return categoria;
    }

    public void setCategoria(int categoria) {
        this.categoria = categoria;
    }


    @Override
    public String toString() {
        return "{" + "nombre='" + nombre + ", categoria=" + categoria + "}|";
    }
}
