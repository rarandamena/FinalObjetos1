import java.io.IOException;
import java.util.ArrayList;

public class Main
{
    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Se crean empleados
        Mecanico mecanico1 = new Mecanico("Alan", "Barrera");
        Mecanico mecanico2 = new Mecanico("Omar", "Ayala");

        ArrayList<Mecanico> mecanicos = new ArrayList<>();
        mecanicos.add(mecanico1);
        mecanicos.add(mecanico2);

        Electrico electrico1 = new Electrico("Rafael", "Aranda");
        Electrico electrico2 = new Electrico("Joan", "Malpica");

        ArrayList<Electrico> electricos = new ArrayList<>();
        electricos.add(electrico1);
        electricos.add(electrico2);

        Pintor pintor1 = new Pintor("Victor", "Lorenzo");
        Pintor pintor2 = new Pintor("Cesar", "Pinto");

        ArrayList<Pintor> pintores = new ArrayList<>();
        pintores.add(pintor1);
        pintores.add(pintor2);

        //Clientes
        Automovil automovil1 = new Automovil(true, true, true);
        Automovil automovil2 = new Automovil(true, false, true);
        Automovil automovil3 = new Automovil(true, false, false);
        Automovil automovil4 = new Automovil(true, true, false);

        ArrayList<Automovil> automoviles = new ArrayList<>();
        automoviles.add(automovil1);
        automoviles.add(automovil2);
        automoviles.add(automovil3);
        automoviles.add(automovil4);

        Taller taller = new Taller(mecanicos, electricos, pintores, automoviles);

        AdministradorRecursos.guardarMecanicos(mecanicos);
        AdministradorRecursos.agregarEmpleado("Meca", "Nuevo", TipoEmpleado.MECANICO);
        ArrayList<Mecanico> nuevo = AdministradorRecursos.obtenerMecanicos();
        taller.repararAutos();

    }
}
