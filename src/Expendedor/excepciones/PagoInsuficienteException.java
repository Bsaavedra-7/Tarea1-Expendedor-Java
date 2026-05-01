package Expendedor.excepciones;

public class PagoInsuficienteException extends Exception{
    public PagoInsuficienteException(){
        super("Pago insuficiente. Se devuelve el dinero");
    }
}
