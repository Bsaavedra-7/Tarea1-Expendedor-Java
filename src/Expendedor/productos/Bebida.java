package Expendedor.productos;

/**
 * Clase abstracta que representa una bebida.
 */
abstract class Bebida extends Producto {
    /**
     * Bebe la bebida.
     *
     * @return nombre de la bebida
     */
    public abstract String beber();

    /**
     * Consume la bebida.
     *
     * @return resultado de beber la bebida
     */
    @Override
    public String consumir() {
        return beber();
    }
}