import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main
{
    private static String Continuar = "si";


    public static void main(String[] args) throws IOException, ClassNotFoundException {

        //Se crean empleados"
        System.out.println("Bienvenido al Taller");

        while (Continuar.equals("si")) {
            Mecanico mecanico1 = new Mecanico("meca 1 alan", "Barrera");
            Mecanico mecanico2 = new Mecanico("meca 2 omar", "Ayala");

            ArrayList<Mecanico> mecanicos = new ArrayList<>();
            mecanicos.add(mecanico1);
            mecanicos.add(mecanico2);

            Electrico electrico1 = new Electrico("electrico 1 Rafael", "Aranda");
            Electrico electrico2 = new Electrico("electrico 2 Joan", "Malpica");

            ArrayList<Electrico> electricos = new ArrayList<>();
            electricos.add(electrico1);
            electricos.add(electrico2);

            Pintor pintor1 = new Pintor("pintor 1 Victor", "Lorenzo");
            Pintor pintor2 = new Pintor("Cesar pintor 2", "Pinto");

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
            AdministradorRecursos.guardarElectricos(electricos);
            AdministradorRecursos.guardarPintores(pintores);

            AdministradorRecursos.agregarEmpleado("Mecanico", "Nuevo", TipoEmpleado.MECANICO);
            AdministradorRecursos.agregarEmpleado("Electrico", "Nuevo", TipoEmpleado.ELECTRICO);
            AdministradorRecursos.agregarEmpleado("Pintor", "Nuevo", TipoEmpleado.PINTOR);



            ArrayList<Mecanico> nuevo1 = AdministradorRecursos.obtenerMecanicos();
            ArrayList<Electrico> nuevo2 = AdministradorRecursos.obtenerElectricos();
            ArrayList<Pintor> nuevo3 = AdministradorRecursos.obtenerPintores();


            taller.repararAutos();

            System.out.println("Continuamos?");
            Scanner iterar = new Scanner(System.in);
            Continuar = iterar.next();
        }
    }
}
