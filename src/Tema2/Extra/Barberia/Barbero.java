package Tema2.Extra.Barberia;

public class Barbero implements Runnable {
    private Barberia barberia;

    public Barbero(Barberia barberia) {
        this.barberia = barberia;
    }

    @Override
    public void run() {
        while (true) {
            int clienteId = barberia.siguienteCliente();
            atenderCliente(clienteId);
            barberia.liberarBarbero();
        }
    }

    private void atenderCliente(int idCliente) {
        System.out.println("El barbero está cortando el pelo al cliente " + idCliente);
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("El cliente " + idCliente + " ha terminado su corte.");
    }
}

