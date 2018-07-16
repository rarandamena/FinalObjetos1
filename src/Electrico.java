public class Electrico extends Empleado
{
    public Electrico(String nombre, String apellido)
    {
        super(nombre, apellido);
        setTiempoDeTrabajo(Constantes.TIEMPO_TRABAJO_ELECTRICO);
    }

    /**
     * El trabajo del Electrico se ejecuta de forma asincrona
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
            getAutosEnCola().element().setFallaElectrica(false);
            System.out.println(getNombre() + " termino con el auto " + getAutosEnCola().element().getNumeroSerie());
            getAutosEnCola().remove();
        }
    }
}
