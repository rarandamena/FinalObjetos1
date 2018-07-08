/**
 * la clase empleado divide a los mismos en Electrico, Mecanico, Pintor
 * y se basa en los atributos de Humano
 */

public class Empleado extends Humano {

    private String TipoEmpleado;


    public Empleado(String nombre, String Apellido, int edad) {
        super(nombre, Apellido, edad);
    }
}
