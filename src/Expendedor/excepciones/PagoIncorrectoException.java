package Expendedor.excepciones;

public class PagoIncorrectoException extends Exception {
    public PagoIncorrectoException(){
        super("Pago incorrecto. No se entrega ni producto ni vuelto");
    }
}
