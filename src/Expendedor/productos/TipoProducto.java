package Expendedor.productos;

public enum TipoProducto{
    COCA_COLA(1500),
    FANTA(1500),
    SPRITE(1500), //Definimos las constantes
    SNICKERS(1000),
    SUPER8(500);

    private final int precio; //Definimos el atributo precio

    TipoProducto(int precio){
        this.precio = precio; //Método constructor
    }

    public int getPrecio() {
        return precio; //Getter del precio
    }
}
