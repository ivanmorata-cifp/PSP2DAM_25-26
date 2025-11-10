package Tema2.Extra.Estanco;

public class Main {
    public static void main(String[] args) {
        Estanco monitor = new Estanco();

        Thread estanquero = new Thread(new Estanquero(monitor));
        estanquero.start();

        for (int i = 0; i < 3; i++) {
            Thread fumador = new Thread(new Fumador(i, monitor));
            fumador.start();
        }
    }
}

