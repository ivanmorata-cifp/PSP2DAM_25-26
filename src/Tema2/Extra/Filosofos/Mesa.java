package Tema2.Extra.Filosofos;

public class Mesa {
    private boolean[] cubiertos;

    public Mesa(int numFilosofos) {
        cubiertos = new boolean[numFilosofos];
        for (int i = 0; i < numFilosofos; i++) {
            cubiertos[i] = false;
        }
    }

    public synchronized void tomarCubiertos(int idFilosofo) {
        int izquierda = idFilosofo;
        int derecha = (idFilosofo + 1) % cubiertos.length;

        while (cubiertos[izquierda] || cubiertos[derecha]) {
            try {
                System.out.println("Filósofo " + idFilosofo + " espera sus cubiertos...");
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        cubiertos[izquierda] = true;
        cubiertos[derecha] = true;
        System.out.println("Filósofo " + idFilosofo + " ha tomado los cubiertos " + izquierda + " y " + derecha);
    }

    // Filósofo devuelve los cubiertos
    public synchronized void dejarCubiertos(int idFilosofo) {
        int izquierda = idFilosofo;
        int derecha = (idFilosofo + 1) % cubiertos.length;

        cubiertos[izquierda] = false;
        cubiertos[derecha] = false;

        System.out.println("Filósofo " + idFilosofo + " ha dejado los cubiertos " + izquierda + " y " + derecha);
        notifyAll();
    }
}

