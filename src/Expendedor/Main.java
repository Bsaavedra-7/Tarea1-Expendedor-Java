package Expendedor;
import Expendedor.monedas.*;

import java.util.ArrayList;
public class Main {
    public static void main(String[] args) {

        System.out.println("Inicio del programa");
        Expendedor exp = new Expendedor(12); //Instanciamos nuestro expendedor con 12 instancias de cada producto en sus respectivos depósitos

        ArrayList<Moneda> arr = new ArrayList<>(); //Creamos un arreglo de monedas para mostrar el comparable
        arr.add(new Moneda1000());
        arr.add(new Moneda100()); //Añadimos monedas al arreglo en forma desordenada
        arr.add(new Moneda500());
        arr.sort(null); //Probamos el sort (null indica que la forma de sortear será con el compareTo que definimos en la superclase Moneda)
        for(Moneda m : arr){ //Similar a hacer un for Moneda in arr en Python
            System.out.println(m.getValor()); //Imprimimos el valor de la moneda en orden para ver si se sorteó correctamente
        }
    }
}
