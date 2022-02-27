package psp.esteban;

import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App
{

    private static final int numClientes = 20;
    private static final int numCajas = 6;


    public static void main( String[] args ) throws InterruptedException {

        Supermercado supermercado = new Supermercado();

        Thread[] clientes = new Thread[numClientes];

        Caja cajas[] = new Caja[numCajas];



        for (int i = 0; i < cajas.length; i++) {

            cajas[i] =  new Caja(supermercado, "Caja"+i);
        }


        for (int i = 0; i <numClientes ; i++) {

            Cliente cliente = new Cliente("Cliente"+i, cajas);
            clientes[i] =new Thread(cliente);
            clientes[i].start();

        }

        for (int i = 0; i <numClientes ; i++) {

            clientes[i].join();

        }

        System.out.println(supermercado.getLog());

        for (int i = 0; i < cajas.length; i++) {

            cajas[i].getInfoCaja();
        }




    }
}
