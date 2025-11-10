package Tema2.Extra.Barberia;

import java.util.ArrayList;

public class Barberia {
    private int numSillas;
    private ArrayList<Integer> salaEspera;
    private boolean barberoOcupado = false;

    public Barberia(int numSillas) {
        this.numSillas = numSillas;
        this.salaEspera = new ArrayList<Integer>();
    }

    public synchronized void llegaCliente(int idCliente) {
        if (salaEspera.size() < numSillas) {
            salaEspera.add(idCliente);
            System.out.println("Cliente " + idCliente + " entra y se sienta. En espera: " + salaEspera.size());
            notifyAll();
        } else {
            System.out.println("Cliente " + idCliente + " se va, no hay sillas libres.");
        }
    }

    public synchronized int siguienteCliente() {
        while (salaEspera.isEmpty()) {
            try {
                System.out.println("El barbero está dormido esperando clientes...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        int idCliente = salaEspera.remove(0);
        barberoOcupado = true;
        return idCliente;
    }

    public synchronized void liberarBarbero() {
        barberoOcupado = false;
    }
}

