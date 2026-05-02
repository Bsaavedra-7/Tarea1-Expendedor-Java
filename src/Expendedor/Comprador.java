package Expendedor;

import Expendedor.excepciones.NoHayProductoException;
import Expendedor.excepciones.PagoIncorrectoException;
import Expendedor.excepciones.PagoInsuficienteException;
import Expendedor.monedas.Moneda;
import Expendedor.productos.Producto;
import Expendedor.productos.TipoProducto;

/**
 * Clase que representa un comprador.
 */
public class Comprador {

    private String sabor;
    private int vuelto = 0;


    public Comprador(Moneda m, TipoProducto tipo, Expendedor exp)throws PagoIncorrectoException, PagoInsuficienteException, NoHayProductoException{

        sabor = null;

        Producto p = exp.comprarProducto(m, tipo);
        //habia un if pero se elimino porque era redundante, ya que si falla lanza una excepcion y si no p nunca es null
        sabor = p.consumir();


        Moneda moneda;
        while ((moneda = exp.getVuelto()) != null) {
            vuelto += moneda.getValor();
        }
    }


    /**

     Retorna lo que consumió el comprador.
     @return String con el nombre del producto consumido,
     o null si no pudo comprar

     */
    public String queConsumiste() {
        return sabor;
    }


    /**

     Retorna el total de dinero recibido como vuelto.
     @return monto total del vuelto
     */
    public int cuantoVuelto() {
        return vuelto;
    }

}


