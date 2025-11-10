package Tema2.Extra.Filosofos;

public class Filosofo implements Runnable {
    private int id;
    private Mesa mesa;

    public Filosofo(int id, Mesa mesa) {
        this.id = id;
        this.mesa = mesa;
    }

    @Override
    public void run() {
        while (true) {
            pensar();
            mesa.tomarCubiertos(id);
            comer();
            mesa.dejarCubiertos(id);
        }
    }

    private void pensar() {
        System.out.println("Filósofo " + id + " está pensando...");
        try {
            Thread.sleep((int) (Math.random() * 4000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void comer() {
        System.out.println("Filósofo " + id + " está comiendo...");
        try {
            Thread.sleep((int) (Math.random() * 3000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Filósofo " + id + " ha terminado de comer.");
    }
}

