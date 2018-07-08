/**
 * clase padre de Cliente, Empleado, y todo lo antropomorfo
 */
public class Humano {

    private String Nombre;
    private String Apellido;
    private int Edad;

    /**
     * crea las variables que se van a usar para la clase Humano
     * @param nombre
     * @param Apellido
     * @param edad
     */

    public Humano(String nombre, String Apellido, int edad) {
        this.Nombre = nombre;
        this.Apellido = Apellido;
        this.Edad = edad;
    }

    /**
     * setters y getters de la clase humano
     */
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        this.Nombre = nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String apellido) {
        this.Apellido = apellido;
    }

    public int getEdad() {
        return Edad;
    }

    public void setEdad(int edad) {
        this.Edad = edad;
    }
    /**
     * hasta aqui termina
     */
}



