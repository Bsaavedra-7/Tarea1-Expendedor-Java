package Expendedor;

import Expendedor.excepciones.*;
import Expendedor.monedas.*;
import Expendedor.productos.TipoProducto;

import java.util.ArrayList;

/**
 * Clase principal del programa.
 */
public class Main {
    /**
     * Método principal del programa.
     *
     * @param args argumentos recibidos por consola
     */
    public static void main(String[] args) {

        System.out.println("Inicio del programa");

        /**
         * Instanciamos un expendedor con 12 elementos de cada producto
         */
        Expendedor exp = new Expendedor(12);

        /**
         * Instanciamos un expendedor vacío, para ejemplificar el caso de falta de stock
         */
        Expendedor expVacio = new Expendedor(0);

        /**
         * Este bloque se utiliza para testear una compra exitosa.
         */
        System.out.println("\n--- Caso 1: Compra exitosa ---\n");
        try {
            /**
             * Instanciamos un comprador con una moneda de 1000 y con orden de comprar un super8
             */
            Comprador c1 = new Comprador(new Moneda1000(), TipoProducto.SUPER8, exp);

            /**
             * Obtenemos el producto consumido por el comprador
             */
            System.out.println("Consumió: " + c1.queConsumiste());

            /**
             * Mostramos el vuelto recibido por el comprador
             */
            System.out.println("Vuelto recibido: $" + c1.cuantoVuelto());

        /**
         * Catch de excepciones
         */
        } catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException exception) {
            System.out.println("Error en la compra: " + exception.getMessage());
        }

        /**
         * Este bloque se utiliza para testear una compra con moneda insuficiente.
         */
        System.out.println("\n--- Caso 2: Compra con moneda insuficiente ---\n");
        try {
            /**
             * Instanciamos un comprador con una moneda de 100 y con orden de comprar una CocaCola
             */
            Comprador c2 = new Comprador(new Moneda100(), TipoProducto.COCA_COLA, exp);

        /**
         * Catch de la excepción de pago insuficiente
         */
        } catch (PagoInsuficienteException exception) {
            System.out.println(exception.getMessage());

            /**
             * Obtenemos la moneda devuelta por el expendedor
             */
            Moneda devuelta = exp.getVuelto();

            /**
             * Verificamos que la moneda devuelta no sea nula
             */
            if (devuelta != null) {
                /**
                 * Mostramos el vuelto recibido
                 */
                System.out.println("Vuelto recibido: $" + devuelta.getValor());
            }

        /**
         * Catch de excepciones
         */
        } catch (PagoIncorrectoException | NoHayProductoException exception){
            System.out.println("Error en la compra: " + exception.getMessage());
        }

        /**
         * Este bloque se utiliza para testear una compra con moneda nula.
         */
        System.out.println("\n--- Caso 3: Compra con moneda nula ---\n");
        try {
            /**
             * Instanciamos un comprador con una moneda nula y con orden de comprar una Sprite
             */
            Comprador c3 = new Comprador(null, TipoProducto.SPRITE, exp);

            /**
             * Obtenemos el producto consumido por el comprador
             */
            System.out.println("Consumió: " + c3.queConsumiste());

            /**
             * Mostramos el vuelto recibido por el comprador
             */
            System.out.println("Vuelto recibido: $" + c3.cuantoVuelto());

        /**
         * Catch de excepciones
         */
        } catch (NoHayProductoException | PagoIncorrectoException | PagoInsuficienteException exception) {
            System.out.println("Error en la compra: " + exception.getMessage());
        }

        /**
         * Este bloque se utiliza para testear la falta de Stock.
         */
        System.out.println("\n--- Caso 4: Falta de Stock ---\n");
        try {
            /**
             * Instanciamos un comprador con una moneda de 1000 y con orden de comprar un Snickers
             */
            Comprador c4 = new Comprador(new Moneda1000(), TipoProducto.SNICKERS, expVacio);

            /**
             * Obtenemos el producto consumido por el comprador
             */
            System.out.println("Consumió: " + c4.queConsumiste());

            /**
             * Mostramos el vuelto recibido por el comprador
             */
            System.out.println("Vuelto recibido: $" + c4.cuantoVuelto());

        /**
         * Catch de la excepción de falta de producto
         */
        } catch (NoHayProductoException exception) {
            /**
             * Mostramos el mensaje de la excepción
             */
            System.out.println(exception.getMessage());

            /**
             * Obtenemos la moneda devuelta por el expendedor vacío
             */
            Moneda devuelta = expVacio.getVuelto();

            /**
             * Verificamos que la moneda devuelta no sea nula
             */
            if (devuelta != null) {
                /**
                 * Mostramos la moneda devuelta
                 */
                System.out.println("Moneda devuelta: $" + devuelta.getValor());
            }

        /**
         * Catch de excepciones
         */
        } catch (PagoIncorrectoException | PagoInsuficienteException exception) {
            /**
             * Mostramos el mensaje de la excepción
             */
            System.out.println(exception.getMessage());
        }

        /**
         * Este bloque se utiliza para testear el compareTo incluido en la superclase Moneda.
         */
        System.out.println("\n--- Ordenar Monedas ---");

        /**
         * Instanciamos un ArrayList de Moneda
         */
        ArrayList<Moneda> monedas = new ArrayList<>();

        monedas.add(new Moneda1000());

        /**
         * Introducimos las monedas sin seguir un orden relacionado al valor
         */
        monedas.add(new Moneda100());
        monedas.add(new Moneda500());

        System.out.println("Antes de ordenar:");
        for (Moneda m : monedas) { //Similar a hacer un for m in monedas en python
            /**
             * Mostramos como están ordenadas antes
             */
            System.out.println("$" + m.getValor());
        }

        /**
         * Aplicamos sort, el argumento null es para que el orden vaya de acuerdo al compareTo sobreescrito en la superclase Moneda
         */
        monedas.sort(null);

        System.out.println("Después de ordenar:");
        for (Moneda m : monedas) { //Similar a hacer un for m in monedas en python
            /**
             * Mostramos como están ordenadas después
             */
            System.out.println("$" + m.getValor());
        }
    }
}
