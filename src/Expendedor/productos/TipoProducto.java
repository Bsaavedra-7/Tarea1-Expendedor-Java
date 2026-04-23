package Expendedor.productos;

public enum TipoProducto{
    COCA_COLA(1, 500),
    FANTA(2, 500),
    SPRITE(3, 500), //Definimos las constantes
    SNICKERS(4, 500),
    SUPER8(5, 500);

    private final int numero; //Definimos el atributo numero para saber a que numero corresponde cada producto
    private final int precio; //Definimos el atributo precio

    TipoProducto(int numero, int precio){
        this.numero = numero;
        this.precio = precio; //Método constructor
    }

    public int getNumero(){
        return numero;
    } //Getter del numero

    public int getPrecio() {
        return precio; //Getter del precio
    }
}
