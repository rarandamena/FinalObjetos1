import java.io.*;
import java.util.ArrayList;
import java.util.UUID;

/**
 * Se encarga de administrar (crear, editar o eliminar) tanto empleados como clientes.
 */
public class AdministradorRecursos
{

    /**
     * Devuelve una lista de todos los mecanicos del taller
     * @return Mecanicos
     */
    public static ArrayList<Mecanico> obtenerMecanicos() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(Constantes.ARCHIVO_MECANICOS);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Mecanico> mecanicos = (ArrayList<Mecanico>) ois.readObject();
        ois.close();

        return mecanicos;
    }

    /**
     * Devuelve una lista de todos los electricos del taller
     * @return Electricos
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<Electrico> obtenerElectricos() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(Constantes.ARCHIVO_ELECTRICOS);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Electrico> electricos = (ArrayList<Electrico>) ois.readObject();
        ois.close();

        return electricos;
    }

    /**
     * Devuelve una lista de todos los pintores del taller
     * @return Pintores
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<Pintor> obtenerPintores() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(Constantes.ARCHIVO_PINTORES);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Pintor> pintores = (ArrayList<Pintor>) ois.readObject();
        ois.close();

        return pintores;
    }

    /**
     * Deveulve una lista con todos los clientes del taller.
     * @return Clientes
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static ArrayList<Cliente> obtenerClientes() throws IOException, ClassNotFoundException {
        FileInputStream fis = new FileInputStream(Constantes.ARCHIVO_CLIENTES);
        ObjectInputStream ois = new ObjectInputStream(fis);
        ArrayList<Cliente> clientes = (ArrayList<Cliente>) ois.readObject();
        ois.close();

        return clientes;
    }

    /**
     * Guarda la lista de todos los mecanicos del taller en un archuvo
     * @param mecanicos Lista de mecanicos
     * @throws IOException
     */
    public static void guardarMecanicos(ArrayList<Mecanico> mecanicos) throws IOException {
        try
        {
            FileOutputStream fos = new FileOutputStream(Constantes.ARCHIVO_MECANICOS);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(mecanicos);
            oos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Guarda una lista de todos los electricos del taller en un archivo
     * @param electricos Lista de electricos
     * @throws IOException
     */
    public static void guardarElectricos(ArrayList<Electrico> electricos) throws IOException {
        try
        {
            FileOutputStream fos = new FileOutputStream(Constantes.ARCHIVO_ELECTRICOS);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(electricos);
            oos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Guarda una lista de todos los pintoes del taller en un archivo
     * @param pintores Lista de pintores
     * @throws IOException
     */
    public static void guardarPintores(ArrayList<Pintor> pintores) throws IOException {
        try
        {
            FileOutputStream fos = new FileOutputStream(Constantes.ARCHIVO_PINTORES);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(pintores);
            oos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Guarda una lista de todos los clientes del taller
     * @param clientes Lista de clientes
     * @throws IOException
     */
    public static void guardarClientes(ArrayList<Cliente> clientes) throws IOException {
        try
        {
            FileOutputStream fos = new FileOutputStream(Constantes.ARCHIVO_CLIENTES);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(clientes);
            oos.close();
        }
        catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Añade un empleado al taller y guarda la lista actualizada en un archivo
     * @param nombre Nombre del empleado
     * @param apellido Apellido del empleado
     * @param tipoEmpleado Tipo de empleado
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void agregarEmpleado(String nombre, String apellido, TipoEmpleado tipoEmpleado) throws IOException, ClassNotFoundException {
        switch (tipoEmpleado)
        {
            case MECANICO:
                Mecanico mecanico = new Mecanico(nombre, apellido);
                ArrayList<Mecanico> listaMecanicos = obtenerMecanicos();
                listaMecanicos.add(mecanico);
                guardarMecanicos(listaMecanicos);
                break;
            case ELECTRICO:
                Electrico empleado = new Electrico(nombre, apellido);
                ArrayList<Electrico> listaElectricos = obtenerElectricos();
                listaElectricos.add(empleado);
                guardarElectricos(listaElectricos);
                break;
            case PINTOR:
                Pintor pintor = new Pintor(nombre, apellido);
                ArrayList<Pintor> listaPintores = obtenerPintores();
                listaPintores.add(pintor);
                guardarPintores(listaPintores);
                break;
                default:
                    break;
        }
    }

    /**
     * Agregar un cliente al taller y guarda la lista actualizada en un archivo
     * @param nombre Nombre del cliente
     * @param apellido Apellido del cliente
     * @param automovil Automovil asociado al cliente
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void agregarCliente(String nombre, String apellido, Automovil automovil) throws IOException, ClassNotFoundException {
        Cliente cliente = new Cliente(nombre, apellido, automovil);
        ArrayList<Cliente> listaClientes = obtenerClientes();
        listaClientes.add(cliente);
        guardarClientes(listaClientes);
    }

    /**
     * Elimina un empleado del taller (atraves del numero de segurida social) y guarda la lista actualizada en un archivo
     * @param nss Numero de seguridad social
     * @param tipoEmpleado Tipo de empleado
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void eliminarEmpleado(UUID nss, TipoEmpleado tipoEmpleado) throws IOException, ClassNotFoundException {
        switch (tipoEmpleado)
        {
            case MECANICO:
                ArrayList<Mecanico> listaMecanicos = obtenerMecanicos();
                for(Mecanico mecanico : listaMecanicos)
                {
                    if (mecanico.getNss() == nss)
                    {
                        listaMecanicos.remove(mecanico);
                        break;
                    }
                }
                guardarMecanicos(listaMecanicos);
                break;
            case ELECTRICO:
                ArrayList<Electrico> listaElectricos = obtenerElectricos();
                for(Electrico electrico : listaElectricos)
                {
                    if (electrico.getNss() == nss)
                    {
                        listaElectricos.remove(electrico);
                        break;
                    }
                }
                guardarElectricos(listaElectricos);
                break;
            case PINTOR:
                ArrayList<Pintor> listaPintores = obtenerPintores();
                for(Pintor pintor : listaPintores)
                {
                    if (pintor.getNss() == nss)
                    {
                        listaPintores.remove(pintor);
                        break;
                    }
                }
                guardarPintores(listaPintores);
                break;
            default:
                break;
        }
    }

    /**
     * Elimina un empleado del taller (atraves de su numero de cliente) y guarda la lista actualizada en un archivo
     * @param nc Numero de cliente
     * @throws IOException
     * @throws ClassNotFoundException
     */
    public static void eliminarCliente(UUID nc) throws IOException, ClassNotFoundException {
        ArrayList<Cliente> listaClientes = obtenerClientes();
        for(Cliente cliente : listaClientes)
        {
            if (cliente.getNumeroCliente() == nc)
            {
                listaClientes.remove(cliente);
                break;
            }
        }
        guardarClientes(listaClientes);
    }

}
