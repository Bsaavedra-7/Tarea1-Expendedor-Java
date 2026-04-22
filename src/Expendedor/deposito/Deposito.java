package Expendedor.deposito;
import java.util.ArrayList;

public class Deposito<T> {
    private ArrayList<T> array; //Creamos el array genérico

    public Deposito(){  //Constructor del arreglo
        this.array = new ArrayList<>();
    }

    public void add(T tipo){ //Método para añadir una vez un objeto al arreglo
        array.add(tipo);
    }

    public T get(){ //Método para retirar el objeto
        if (array.size() == 0){return null;} //Podemos aprovechar esto para hacer el throw a la excepción en expendedor
        else{return array.removeFirst();} //Quita el primer elemento
    }

}
