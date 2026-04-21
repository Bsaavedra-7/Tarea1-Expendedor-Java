package Expendedor.monedas;


abstract class Moneda{

    public Moneda(){
    }

    public int getSerie(){
        return this.hashCode();
        // hashCode() sirve porque nos devuelve un numero unico asocioado al objeto que usaremos como serie o id
    }

    public abstract int getValor();
}
