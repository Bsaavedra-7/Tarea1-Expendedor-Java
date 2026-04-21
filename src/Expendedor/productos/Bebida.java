package Expendedor.productos;

abstract class Bebida extends Producto {
    public abstract String beber();

    @Override
    public String consumir() {
        return beber();
    }
}