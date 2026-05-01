package Expendedor.monedas;

/**
 * Clase abstracta que representa una moneda.
 */
public abstract class Moneda implements Comparable<Moneda>{

    /**
     * Constructor de la moneda.
     */
    public Moneda(){
    }

    /**
     * Obtiene la serie de la moneda.
     *
     * @return serie de la moneda
     */
    public int getSerie(){
        return this.hashCode();
    }

    /**
     * Obtiene el valor de la moneda.
     *
     * @return valor de la moneda
     */
    public abstract int getValor();

    /**
     * Sobreescribimos pues compareTo es un método que ya existe desde la implementación de la interfaz
     *
     * @param otra otra moneda con la que se compara
     * @return Retorna de tal modo que sort pueda entender que moneda vale más que otra
     */
    @Override
    public int compareTo(Moneda otra){
        return this.getValor() - otra.getValor();
    }
}
