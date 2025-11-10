package Tema2.Extra.Estanco;

public class Estanquero implements Runnable {
    private Estanco monitor;

    public Estanquero(Estanco monitor) {
        this.monitor = monitor;
    }

    @Override
    public void run() {
        while (true) {
            int fumadorSeleccionado = (int) (Math.random() * 3); // 0, 1 o 2
            monitor.colocarIngredientes(fumadorSeleccionado);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

