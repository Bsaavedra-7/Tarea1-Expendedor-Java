package Expendedor.productos;

abstract class Dulce extends Producto {
    public abstract String comer();

    @Override
    public String consumir() {
        return comer();
    }
}
