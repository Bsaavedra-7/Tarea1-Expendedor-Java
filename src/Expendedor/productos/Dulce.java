package Expendedor.productos;

/**
 * Clase abstracta que representa un dulce.
 */
abstract class Dulce extends Producto {
    /**
     * Come el dulce.
     *
     * @return nombre del dulce
     */
    public abstract String comer();

    /**
     * Consume el dulce.
     *
     * @return resultado de comer el dulce
     */
    @Override
    public String consumir() {
        return comer();
    }
}
