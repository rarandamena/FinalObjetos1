import java.io.Serializable;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

/**
 * Es la persona que se encarga de atender los coches en el taller.
 */
public class Empleado extends Thread implements Serializable
{
    private String nombre;
    private String apellido;
    private UUID nss; //Numero de Seguro Social
    private int tiempoDeTrabajo; //El tiempo (en segundos) que tarda el empleado en realizar su trabajo
    private Queue<Automovil> autosEnCola;

    public Empleado(String nombre, String apellido)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.nss = UUID.randomUUID();
        autosEnCola = new LinkedList<>();
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public UUID getNss() {
        return nss;
    }

    public int getTiempoDeTrabajo() {
        return tiempoDeTrabajo;
    }

    public void setTiempoDeTrabajo(int tiempoDeTrabajo) {
        this.tiempoDeTrabajo = tiempoDeTrabajo;
    }

    public Queue<Automovil> getAutosEnCola() {
        return autosEnCola;
    }
}
