package Expendedor;

import Expendedor.monedas.*;
import Expendedor.productos.TipoProducto;
import Expendedor.excepciones.*;

import java.util.Scanner;

/**

 * Clase que contiene el main interactivo del programa.
 * Permite al usuario comprar productos desde consola mediante un menú.
 */
public class MainInteractivo {

    /**

     * Método principal que ejecuta el menú interactivo.
     * @param args argumentos de línea de comandos
     */
    public static void main(String[] args) {

        // Scanner para leer datos desde la consola
        Scanner scanner = new Scanner(System.in);

        // Se crea un expendedor con 5 productos de cada tipo
        Expendedor exp = new Expendedor(5);

        System.out.println("=== EXPENDEDOR ===");

        // Variable de control para mantener el programa en ejecución
        boolean seguir = true;

        // Bucle principal del programa
        while (seguir) {


            // Menu para seleccionar productos
            System.out.println("\n--- MENU DE PRODUCTOS ---");
            System.out.println("1. CocaCola ($1500)");
            System.out.println("2. Fanta ($1500)");
            System.out.println("3. Sprite ($1500)");
            System.out.println("4. Snickers ($500)");
            System.out.println("5. Super8 ($500)");
            System.out.println("0. Salir");

            // Se solicita al usuario seleccionar un producto
            System.out.print("Seleccione producto: ");
            int opcionProducto = scanner.nextInt();


            if (opcionProducto == 0) {
                System.out.println("Saliendo...");
                break;
            }
            TipoProducto tipo = null;


            switch (opcionProducto) {
                case 1: tipo = TipoProducto.COCA_COLA; break;
                case 2: tipo = TipoProducto.FANTA; break;
                case 3: tipo = TipoProducto.SPRITE; break;
                case 4: tipo = TipoProducto.SNICKERS; break;
                case 5: tipo = TipoProducto.SUPER8; break;
                default:
                    System.out.println("Opción inválida");
                    continue;
            }

            // Menú de selección de monedas
            System.out.println("\n--- MONEDAS ---");
            System.out.println("1. $100");
            System.out.println("2. $500");
            System.out.println("3. $1000");
            System.out.print("Seleccione moneda: ");

            int opcionMoneda = scanner.nextInt();

            // Variable que representará la moneda ingresada
            Moneda moneda = null;

            switch (opcionMoneda) {
                case 1: moneda = new Moneda100(); break;
                case 2: moneda = new Moneda500(); break;
                case 3: moneda = new Moneda1000(); break;
                default:
                    System.out.println("Moneda inválida");
                    continue;
            }

            try {
                Comprador comprador = new Comprador(moneda, tipo, exp);

                System.out.println("Consumiste: " + comprador.queConsumiste());

                System.out.println("Vuelto: $" + comprador.cuantoVuelto());

            } catch (PagoIncorrectoException |
                     PagoInsuficienteException |
                     NoHayProductoException e) {

                System.out.println("Error: " + e.getMessage());
            }

            System.out.println("\n¿Desea seguir?");
            System.out.println("1. Sí");
            System.out.println("2. No");

            int opcionSeguir = scanner.nextInt();

            if (opcionSeguir != 1) {
                seguir = false;
                System.out.println("Saliendo...");
            }


        }

        // Se cierra el Scanner para liberar recursos
        scanner.close();
    }
}
