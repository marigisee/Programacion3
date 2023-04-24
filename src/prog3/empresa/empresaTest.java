package prog3.empresa;
import prog3.empresa.*;
import prog3.arbolgeneral.*;
import prog3.listagenerica.*;
import prog3.Resultado.ResultadoInt;

public class empresaTest {
    public static void main(String[] args) {
        int categoria = 3;
        Empresa emp = new Empresa();
        emp = cargarEmpresa();
        System.out.println("--------------------------------------------------------------");
        emp.recorridoPorNiveles();
        System.out.println();
        System.out.println("--------------------------------------------------------------");
        System.out.println("Vamos a obtener todos los empleados de categoria "+categoria+":");
        ListaGenerica<Empleado> l = new ListaGenericaEnlazada<>();
        l = emp.empleadosPorCategoria(categoria);
        System.out.println(l);
        System.out.println("--------------------------------------------------------------");
        System.out.println("La categoria con mas empleados:"+emp.categoriaConMasEmpleados());
        System.out.println("--------------------------------------------------------------");
        System.out.println("La cantidad total de empleados es de:"+emp.cantidadTotalDeEmpleados());
    }

    public static Empresa cargarEmpresa(){
        //Empleada de categoría 1
        Empleado empleado = new Empleado("Marina",10,1);
        Empresa e = new Empresa(empleado);
        //Empleados de categoría 2
        ListaGenerica<ArbolGeneral<Empleado>> hijos1 = new ListaGenericaEnlazada<>();
        Empleado Pepe = new Empleado("Pepe",3,2);
        Empleado Juan = new Empleado("Juan",4,2);
        Empleado Fran = new Empleado ("Fran",3,2);
        hijos1.agregarFinal(new ArbolGeneral<Empleado>(Pepe));
        hijos1.agregarFinal(new ArbolGeneral<Empleado>(Juan));
        hijos1.agregarFinal(new ArbolGeneral<Empleado>(Fran));
        e.setHijos(hijos1);
        //------------Empleados de categoria 3------------//
        //--Empleados de Pepe--//
        ListaGenerica<ArbolGeneral<Empleado>> hijos2Pepe = new ListaGenericaEnlazada<>();
        Empleado Marta = new Empleado("Marta",1,3);
        Empleado Pope = new Empleado("Pope",2,3);
        hijos2Pepe.agregarFinal(new ArbolGeneral<>(Marta));
        hijos2Pepe.agregarFinal(new ArbolGeneral<>(Pope));
        e.getHijos().elemento(0).setHijos(hijos2Pepe);
        //--Empleados de Juan--//
        ListaGenerica<ArbolGeneral<Empleado>> hijos2Juan = new ListaGenericaEnlazada<>();
        Empleado Lucho = new Empleado ("Lucho",1,3);
        Empleado Cintia = new Empleado ("Cintia",2,3);
        Empleado Manuel = new Empleado ("Manuel",1,3);
        hijos2Juan.agregarFinal(new ArbolGeneral<>(Lucho));
        hijos2Juan.agregarFinal(new ArbolGeneral<>(Cintia));
        hijos2Juan.agregarFinal(new ArbolGeneral<>(Manuel));
        e.getHijos().elemento(1).setHijos(hijos2Juan);
    return e;}

}
