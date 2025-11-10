package Tema2.Extra.Filosofos;

public class Main {
    public static void main(String[] args) {
        int nFiolsofos = 5;

        Mesa mesa = new Mesa(nFiolsofos);
        Thread[] filosofos = new Thread[nFiolsofos];

        for (int i = 0; i < nFiolsofos; i++) {
            filosofos[i] = new Thread(new Filosofo(i, mesa));
            filosofos[i].start();
        }
    }
}

