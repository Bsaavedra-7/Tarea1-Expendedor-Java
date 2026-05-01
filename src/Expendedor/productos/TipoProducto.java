package Expendedor.productos;

/**
 * Enum que representa los tipos de producto.
 */
public enum TipoProducto{
    /**
     * Definimos las constantes
     */
    COCA_COLA(1, 1500),
    FANTA(2, 1500),
    SPRITE(3, 1500),
    SNICKERS(4, 500),
    SUPER8(5, 500);

    /**
     * Definimos el atributo numero para saber a que numero corresponde cada producto
     */
    private final int numero;

    /**
     * Definimos el atributo precio
     */
    private final int precio;

    /**
     * Método constructor
     *
     * @param numero numero que corresponde al producto
     * @param precio precio del producto
     */
    TipoProducto(int numero, int precio){
        this.numero = numero;
        this.precio = precio;
    }

    /**
     * Getter del numero
     *
     * @return numero del producto
     */
    public int getNumero(){
        return numero;
    }

    /**
     * Getter del precio
     *
     * @return precio del producto
     */
    public int getPrecio() {
        return precio;
    }
}
