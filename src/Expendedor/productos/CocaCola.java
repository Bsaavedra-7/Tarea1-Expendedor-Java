package Expendedor.productos;

public class CocaCola extends Bebida {

    @Override
    public String beber() {
        return "gluglu";
    }

    @Override
    public String getNombre() {
        return "CocaCola";
    }
}