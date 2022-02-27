package psp.esteban;

public class Cliente implements Runnable{
    private String name;
    private Caja[] cajas;

    public Cliente(String name, Caja[] cajas) {
        this.name=name;
        this.cajas=cajas;
    }

    @Override
    public void run() {


        int randomSleep  = (int) (Math.random() * (1000 - 1) + 1);
        int randomCaja = (int) (Math.random() * (cajas.length - 0) + 0);

        try {
            Thread.sleep(randomSleep);
            System.out.println(this.name +" va a la caja: " +randomCaja);

            cajas[randomCaja].entraCaja();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
            toString();
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "name='" + name + '\'' +
                '}';
    }
}
