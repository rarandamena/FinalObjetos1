public class Pintor extends Empleado
{
    public Pintor(String nombre, String apellido)
    {
        super(nombre, apellido);
        setTiempoDeTrabajo(Constantes.TIEMPO_TRABAJO_PINTOR);
    }

    /**
     * El trabajo del Pintor se ejecuta de forma asincrona
     */
    @Override
    public void run()
    {
        while(!getAutosEnCola().isEmpty())
        {
            System.out.println(getNombre() + " esta trabajando el auto " + getAutosEnCola().element().getNumeroSerie());
            try {
                Thread.sleep(getTiempoDeTrabajo() * 1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            getAutosEnCola().element().setPinturaAveriada(false);
            System.out.println(getNombre() + " termino con el auto " + getAutosEnCola().element().getNumeroSerie());
            getAutosEnCola().remove();
        }
    }
}
