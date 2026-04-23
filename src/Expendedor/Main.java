package Expendedor;

import Expendedor.monedas.*;
import Expendedor.productos.*;
import Expendedor.excepciones.*;

public class Main {
    public static void main(String[] args) {

        try {
            // Crear expendedor
            Expendedor exp = new Expendedor(3);

            // Crear moneda, modificable dependiendo del dinero que sea nesesario
            Moneda m1000 = new Moneda1000();

            // Comprar producto (usando el enum)
            Producto p1 = exp.comprarProducto(m1000, TipoProducto.COCA_COLA);

            // Mostrar resultado
            System.out.println("Producto comprado: " + p1.getNombre());

            // Mostrar vuelto, el vuelto por ahora es de solo monedas de 100 pero se puede actualizar para devolver la menor cantidad de monesdas posibles
            Moneda vuelto;
            while ((vuelto = exp.getVuelto()) != null) {
                System.out.println("Vuelto: " + vuelto.getValor());
            }

        } catch (PagoIncorrectoException e) {
            System.out.println("Error: Pago incorrecto");
        } catch (PagoInsuficienteException e) {
            System.out.println("Error: Dinero insuficiente");
        } catch (NoHayProductoException e) {
            System.out.println("Error: No hay stock");
        }
    }
}