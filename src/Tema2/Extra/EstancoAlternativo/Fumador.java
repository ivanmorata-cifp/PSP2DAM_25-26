package Tema2.Extra.EstancoAlternativo;

public class Fumador implements Runnable {
    private final int idFumador;
    private final Estanco monitor;

    public Fumador(int idFumador, Estanco monitor) {
        this.idFumador = idFumador;
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            monitor.recogerIngredientes(idFumador);
            fumar();
        }
    }

    private void fumar() {
        System.out.println("💨 El fumador " + idFumador + " está fumando...");
        try {
            Thread.sleep(3000); // Simula el tiempo de fumar
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("😌 El fumador " + idFumador + " ha terminado de fumar.");
    }
}

