package Expendedor;

import Expendedor.monedas.*;
import Expendedor.productos.*;
import Expendedor.excepciones.*;
import Expendedor.deposito.*;

/**
 * Clase que representa un expendedor de productos.
 */
public class Expendedor {
    /**
     * Variable a utilizar para rellenar los depósitos
     */
    private int cantProducto;

    /**
     * Depósito donde se guarda el vuelto.
     */
    private Deposito<Moneda> dVuelto;

    /**
     * Depósito de CocaCola.
     */
    private Deposito<Producto> dCocaCola;

    /**
     * Declaramos los depósitos
     */
    private Deposito<Producto> dFanta;

    /**
     * Depósito de Sprite.
     */
    private Deposito<Producto> dSprite;

    /**
     * Depósito de Snickers.
     */
    private Deposito<Producto> dSnickers;

    /**
     * Depósito de Super8.
     */
    private Deposito<Producto> dSuper8;

    /**
     * Constructor del expendedor.
     *
     * @param cantProducto cantidad de productos con la que se rellenan los depósitos
     */
    public Expendedor(int cantProducto){
        this.cantProducto = cantProducto;
        dVuelto = new Deposito<>();
        dCocaCola = new Deposito<>();
        dFanta = new Deposito<>();
        dSprite = new Deposito<>();
        dSnickers = new Deposito<>();
        dSuper8 = new Deposito<>();
        llenarDepositos();
    }

    /**
     * Llena los depósitos con la cantidad de productos indicada.
     */
    private void llenarDepositos(){
        for(int i = 0; i < cantProducto; i++){
            dCocaCola.add(new CocaCola());
            dFanta.add(new Fanta());
            dSprite.add(new Sprite());
            dSnickers.add(new Snickers());
            dSuper8.add(new Super8());
        }
    }

    /**
     * Método para que el expendedor sepa a que depósito acceder
     *
     * @param tipo tipo de producto que se quiere sacar
     * @return producto sacado del depósito correspondiente
     */
    private Producto sacarDelDeposito(TipoProducto tipo){
        switch (tipo){
            case COCA_COLA: return dCocaCola.get();
            case FANTA: return dFanta.get();
            case SPRITE: return dSprite.get();
            case SNICKERS: return dSnickers.get();
            case SUPER8: return dSuper8.get();
            default: return null;
        }
    }

    /**
     * Método para dar vuelto en caso de que SI se haya podido efectuar la compra, en otro caso se devuelve la misma moneda con la que se intentó pagar
     *
     * @param moneda moneda usada para pagar
     * @param tipo tipo de producto comprado
     */
    private void darVuelto(Moneda moneda, TipoProducto tipo){
        int vuelto = moneda.getValor() - tipo.getPrecio();
        for(int i = 0; i < vuelto / 100; i++){
            dVuelto.add(new Moneda100());
        }
    }

    public Moneda getVuelto(){
        return dVuelto.get();
    }

    /**
     * Compra un producto usando una moneda.
     *
     * @param moneda moneda con la que se intenta pagar
     * @param tipo tipo de producto que se quiere comprar
     * @return producto comprado
     * @throws NoHayProductoException si no queda producto
     * @throws PagoIncorrectoException si la moneda es nula
     * @throws PagoInsuficienteException si el dinero no alcanza
     */
    public Producto comprarProducto(Moneda moneda, TipoProducto tipo)
        throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException{

        if(moneda == null){
            throw new PagoIncorrectoException();
        }

        if(moneda.getValor() < tipo.getPrecio()){
            dVuelto.add(moneda);
            throw new PagoInsuficienteException();
        }

        Producto producto = sacarDelDeposito(tipo);

        if (producto == null){
            dVuelto.add(moneda);
            throw new NoHayProductoException();
        }

        darVuelto(moneda, tipo);

        return producto;
    }
}
