package Tema2.Extra.Barberia;

public class Cliente implements Runnable {
    private Barberia barberia;
    private int idCliente;

    public Cliente(Barberia barberia, int idCliente) {
        this.barberia = barberia;
        this.idCliente = idCliente;
    }

    @Override
    public void run() {
        try {
            Thread.sleep((int) (Math.random() * 5000));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        barberia.llegaCliente(idCliente);
    }
}

