package psp.esteban;

import java.util.ArrayList;
import java.util.Random;

public class Caja{

    private Supermercado supermercado;
    private Float importe;
    private int clientesAtendidos;
    private String nameCaja;
    private int colaClientes;


    public Caja(Supermercado supermercado, String name) {
        this.supermercado = supermercado;
        this.clientesAtendidos=0;
        this.nameCaja=name;
        this.importe=0f;

    }


        public void entraCaja() throws InterruptedException {

            int randomPrecio = (int) (Math.random() * (100 - 1) + 1);
            int randomTiempo = (int) (Math.random() * (5000 - 1) + 1);

            colaClientes++;

            synchronized (this){

                colaClientes--;

                Thread.sleep(randomTiempo);

                this.supermercado.putLog(randomPrecio);
                this.clientesAtendidos++;
                this.importe+=randomPrecio;

                System.out.println("La caja: " + nameCaja + " ha atendido al: "+ Thread.currentThread() + " ha pagado: "+randomPrecio+ " y ha esperado : " + randomTiempo + " Clientes en cola: " + colaClientes);
            }

        }
    public String getInfoCaja(){

        String info  = "Total caja: "+this.nameCaja + " ha facturado: "+importe + " a un total de: "+ clientesAtendidos +" clientes";
        return info;
    }
}
