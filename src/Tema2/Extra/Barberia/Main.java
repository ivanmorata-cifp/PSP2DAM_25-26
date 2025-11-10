package Tema2.Extra.Barberia;

public class Main {
    public static void main(String[] args) {
        int sillas = 3;
        int clientes = 10;

        Barberia barberia = new Barberia(sillas);

        Thread barbero = new Thread(new Barbero(barberia));
        barbero.start();

        for (int i = 1; i <= clientes; i++) {
            Thread cliente = new Thread(new Cliente(barberia, i));
            cliente.start();
        }
    }
}