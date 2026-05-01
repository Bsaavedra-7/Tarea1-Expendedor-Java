package Expendedor.deposito;

import java.util.ArrayList;

/**
 * Clase que representa un depósito genérico.
 *
 * @param <T> tipo de objeto que guarda el depósito
 */
public class Deposito<T> {
    /**
     * Creamos el array genérico
     */
    private ArrayList<T> array;

    /**
     * Constructor del arreglo
     */
    public Deposito(){
        this.array = new ArrayList<>();
    }

    /**
     * Método para añadir una vez un objeto al arreglo
     *
     * @param tipo objeto que se quiere añadir al arreglo
     */
    public void add(T tipo){
        array.add(tipo);
    }

    /**
     * Método para retirar el objeto
     *
     * @return objeto retirado del depósito o null si está vacío
     */
    public T get(){
        if (array.isEmpty()){
            return null;
        } else {
            return array.removeFirst();
        }
    }
}
