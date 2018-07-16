import java.util.ArrayList;
import java.util.UUID;

/**
 * El cliente del taller, tiene asociado un coche.
 */
public class Cliente
{
    private String nombre;
    private String apellido;
    private UUID numeroCliente;
    private Automovil automovil;

    public Cliente(String nombre, String apellido, Automovil automovil)
    {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numeroCliente = UUID.randomUUID();
        this.automovil = automovil;
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

    public UUID getNumeroCliente() {
        return numeroCliente;
    }

    public Automovil getAutomovil() {
        return automovil;
    }

    public void setAutomovil(Automovil automovil) {
        this.automovil = automovil;
    }
}
