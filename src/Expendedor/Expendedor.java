package Expendedor;

import Expendedor.monedas.*;
import Expendedor.productos.*;
import Expendedor.excepciones.*;
import Expendedor.deposito.*;

public class Expendedor {
    private int cantProducto; //Variable a utilizar para rellenar los depósitos
    private Deposito<Moneda> dVuelto;
    private Deposito<Producto> dCocaCola;
    private Deposito<Producto> dFanta;  //Declaramos los depósitos
    private Deposito<Producto> dSprite;
    private Deposito<Producto> dSnickers;
    private Deposito<Producto> dSuper8;

    public Expendedor(int cantProducto){
        this.cantProducto = cantProducto;
        dVuelto = new Deposito<>(); //Instanciamos el depósito de vuelto
        dCocaCola = new Deposito<>();
        dFanta = new Deposito<>();  //Instanciamos los depósitos de bebidas
        dSprite = new Deposito<>();
        dSnickers = new Deposito<>();
        dSuper8 = new Deposito<>();
        llenarDepositos(); //Llamamos al método para que llene los depósitos al inicializarse el expendedor
    }

    private void llenarDepositos(){
        for(int i = 0; i < cantProducto; i++){ //Llenamos cada depósito cantProducto veces
            dCocaCola.add(new CocaCola());
            dFanta.add(new Fanta());
            dSprite.add(new Sprite());
            dSnickers.add(new Snickers());
            dSuper8.add(new Super8());
        }
    }

    private Producto sacarDelDeposito(TipoProducto tipo){ //Método para que el expendedor sepa a que depósito acceder
        switch (tipo){ //Switch case para todas las opciones
            case COCA_COLA: return dCocaCola.get();
            case FANTA: return dFanta.get();
            case SPRITE: return dSprite.get();
            case SNICKERS: return dSnickers.get();
            case SUPER8: return dSuper8.get();
            default: return null;
        }
    }

    private void darVuelto(Moneda moneda, TipoProducto tipo){
        int vuelto = moneda.getValor() - tipo.getPrecio(); //Obtenemos la cantidad de vuelto a entregar
        for(int i = 0; i < vuelto / 100; i++){ //Ciclo para poder dar el vuelto en monedas de 100
            dVuelto.add(new Moneda100()); //Se añade el vuelto al depósito de monedas
        }
    }

    private Producto comprarProducto(Moneda moneda, TipoProducto tipo)
        throws NoHayProductoException, PagoIncorrectoException, PagoInsuficienteException{ //Con throws indicamos que nuestro método es capaz de lanzar estas excepciones

        if(moneda == null){
            throw new PagoIncorrectoException(); //Lanza esta excepción en caso que la moneda sea nula
        }

        if(moneda.getValor() < tipo.getPrecio()){
            throw new PagoInsuficienteException(); //Lanza esta excepción en caso de que el dinero no alcance
        }

        Producto producto = sacarDelDeposito(tipo); //Obtenemos el producto deseado de su respectivo depósito

        if (producto == null){
            throw new NoHayProductoException(); //Lanza esta excepción en caso de que no quede producto
        }

        darVuelto(moneda, tipo); //Utilizamos el método para dar el vuelto correspondiente

        return producto; //Si llegó hasta aquí, es por que todo salió bien y puede retornar el producto
    }

}
