package Expendedor.excepciones;

public class NoHayProductoException extends Exception {
    public NoHayProductoException(){
        super("No hay producto disponible. Se devuelve el dinero"); //Usamos super ya que el constructor de la superclase Exception recibe un string como argumento
    }
}
