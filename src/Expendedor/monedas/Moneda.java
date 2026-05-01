package Expendedor.monedas;


public abstract class Moneda implements Comparable<Moneda>{

    public Moneda(){
    }

    public int getSerie(){
        return this.hashCode();
        // hashCode() sirve porque nos devuelve un numero unico asocioado al objeto que usaremos como serie o id
    }

    public abstract int getValor();

    @Override //Sobreescribimos pues compareTo es un método que ya existe desde la implementación de la interfaz
    public int compareTo(Moneda otra){
        return this.getValor() - otra.getValor(); //Retorna de tal modo que sort pueda entender que moneda vale más que otra
    }
}
