package Tema2.Extra.EstancoAlternativo;

public class Estanquero implements Runnable {
    private final Estanco monitor;

    public Estanquero(Estanco monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            int fumadorSeleccionado = (int) (Math.random() * 3); // 0, 1 o 2
            monitor.colocarIngredientes(fumadorSeleccionado);

            try {
                Thread.sleep(1000); // Pequeña pausa antes de volver a colocar
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

