import java.util.UUID;

/**
 * El automovil es el que es atendido por los empleados del taller, puede tener una o mas fallas.
 */
public class Automovil
{
    private UUID numeroSerie;

    //Indicadores de danos del coche
    private boolean fallaMecanica;
    private boolean fallaElectrica;
    private boolean pinturaAveriada;

    public Automovil(boolean fallaMecanica, boolean fallaElectrica, boolean pinturaAveriada)
    {
        this.numeroSerie = UUID.randomUUID();
        this.fallaMecanica = fallaMecanica;
        this.fallaElectrica = fallaElectrica;
        this.pinturaAveriada = pinturaAveriada;
    }

    public UUID getNumeroSerie() {
        return numeroSerie;
    }

    public boolean tieneFallaMecanica() {
        return fallaMecanica;
    }

    public void setFallaMecanica(boolean fallaMecanica) {
        this.fallaMecanica = fallaMecanica;
    }

    public boolean tieneFallaElectrica() {
        return fallaElectrica;
    }

    public void setFallaElectrica(boolean fallaElectrica) {
        this.fallaElectrica = fallaElectrica;
    }

    public boolean tienePinturaAveriada() {
        return pinturaAveriada;
    }

    public void setPinturaAveriada(boolean pinturaAveriada) {
        this.pinturaAveriada = pinturaAveriada;
    }

}
