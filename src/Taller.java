import java.util.*;

/**
 * Es el "espacio" en donde se llevan a cabo las operaciones.
 */
public class Taller
{
    private ArrayList<Mecanico> mecanicos;
    private ArrayList<Electrico> electricos;
    private ArrayList<Pintor> pintores;
    private ArrayList<Cliente> listaClientes;
    private ArrayList<Automovil> autosEnReparacion;

    public Taller(ArrayList<Mecanico> mecanicos, ArrayList<Electrico> electricos, ArrayList<Pintor> pintores, ArrayList<Automovil> autosEnReparacion) {
        this.mecanicos = mecanicos;
        this.electricos = electricos;
        this.pintores = pintores;
        this.autosEnReparacion = autosEnReparacion;
    }

    /**
     * Empieza la reparacion de autos
     */
    public void repararAutos()
    {
        System.out.println("Observando trabajo...");


        asignarAutosAEmpleados();

        for(Mecanico mecanico : mecanicos)
            mecanico.start();

        for(Electrico electrico : electricos)
            electrico.start();

        for(Pintor pintor : pintores)
            pintor.start();


        while (!autosEnReparacion.isEmpty())
        {
            for(Automovil automovil : autosEnReparacion)
            {
                if(!automovil.tieneFallaMecanica() && !automovil.tieneFallaElectrica() && !automovil.tienePinturaAveriada())
                {
                    autosEnReparacion.remove(automovil);
                    break;
                }
            }
        }

        System.out.println("FINALIZADO!!");
    }

    /**
     * Asigna autos a los empleados de manera uniforme para que los trabajen
     */
    public void asignarAutosAEmpleados()
    {
        for(Automovil automovil : autosEnReparacion)
        {
            if(automovil.tieneFallaMecanica())
                requisarEmpleado(TipoEmpleado.MECANICO).getAutosEnCola().add(automovil);

            if(automovil.tieneFallaElectrica())
                requisarEmpleado(TipoEmpleado.ELECTRICO).getAutosEnCola().add(automovil);

            if(automovil.tienePinturaAveriada())
                requisarEmpleado(TipoEmpleado.PINTOR).getAutosEnCola().add(automovil);
        }

    }

    /**
     * Requisa un empleado, llama siempre al que tiene el menor numero de autos asignados.
     * @param tipoEmpleado Tipo de empleado que se desea requisar
     * @return Devuelve al empleado
     */
    public Empleado requisarEmpleado(TipoEmpleado tipoEmpleado)
    {
        int indiceEmpleado = 0;

        switch (tipoEmpleado)
        {
            case MECANICO:
                if(mecanicos.size() > 1)
                {
                    for (int i = 0; i < mecanicos.size() - 1; i++) {
                        if (mecanicos.get(i).getAutosEnCola().size() <= mecanicos.get(i + 1).getAutosEnCola().size())
                            indiceEmpleado = i;
                        else
                            indiceEmpleado = i + 1;
                    }
                }
                return mecanicos.get(indiceEmpleado);

            case ELECTRICO:
                if(mecanicos.size() > 1)
                {
                    for (int i = 0; i < electricos.size() - 1; i++) {
                        if (electricos.get(i).getAutosEnCola().size() <= electricos.get(i + 1).getAutosEnCola().size())
                            indiceEmpleado = i;
                        else
                            indiceEmpleado = i + 1;
                    }
                }
                return electricos.get(indiceEmpleado);

            case PINTOR:
                if(mecanicos.size() > 1)
                {
                    for (int i = 0; i < pintores.size() - 1; i++) {
                        if (pintores.get(i).getAutosEnCola().size() <= pintores.get(i + 1).getAutosEnCola().size())
                            indiceEmpleado = i;
                        else
                            indiceEmpleado = i + 1;
                    }
                }
                return pintores.get(indiceEmpleado);

            default:
                return null;
        }
    }


}
