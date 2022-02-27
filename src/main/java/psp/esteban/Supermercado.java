package psp.esteban;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicReferenceArray;

public class Supermercado {

    private ArrayList<Integer> ventasTotalesSupermercado;


    public Supermercado() {
        this.ventasTotalesSupermercado = new ArrayList<>();
    }


    public synchronized void putLog(int precio){

        this.ventasTotalesSupermercado.add(precio);
        notifyAll();
    }


    public synchronized String getLog() throws InterruptedException{

        if (this.ventasTotalesSupermercado.size()==0){
            wait();
        }else{
            notifyAll();
        }

        int precioTotal=0;
        int ventas = ventasTotalesSupermercado.size();



    for (int i = 0; i>=ventasTotalesSupermercado.size();i++){
        precioTotal+= ventasTotalesSupermercado.get(i);
    }

    this.ventasTotalesSupermercado.clear();
    String info = "Ventas totales: " +ventas+ " .Precio total : "+ precioTotal + ". Media precio: "+ precioTotal/ventas;

        return info;
    }

}
