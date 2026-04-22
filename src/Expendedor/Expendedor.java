package Expendedor;

import Expendedor.monedas.*;
import Expendedor.productos.*;
import Expendedor.excepciones.*;
import Expendedor.deposito.*;

public class Expendedor {
    private int cantProducto; //Variable a utilizar para rellenar los depósitos
    private Deposito<Producto> dCocaCola;
    private Deposito<Producto> dFanta;  //Declaramos los depósitos
    private Deposito<Producto> dSprite;
    private Deposito<Producto> dSnickers;
    private Deposito<Producto> dSuper8;

    public Expendedor(int cantProducto){
        this.cantProducto = cantProducto;
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

}
