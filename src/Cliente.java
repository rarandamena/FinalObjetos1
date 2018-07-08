/**
 * el cliente hace referencia a que puede tener mas de un coche, tiene las propiedades del humano, y tiene una direccion
 * de vivienda
 */

import java.util.ArrayList;

public class Cliente extends Humano{


    private String Direccion;
    private ArrayList<Coche> MisCoches;



    public Cliente(String nombre, String Apellido, int edad) {
        super(nombre, Apellido, edad);




    }
}
