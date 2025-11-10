package Tema2.Extra.Estanco;

public class Estanco {
    private int ingredienteEnMesa = -1;
    private boolean mesaOcupada = false;

    public synchronized void colocarIngredientes(int fumadorQuePuedeFumar) {
        while (mesaOcupada) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        ingredienteEnMesa = fumadorQuePuedeFumar;
        mesaOcupada = true;

        System.out.println("El estanquero coloca los ingredientes. Puede fumar el fumador " + fumadorQuePuedeFumar);
        notifyAll();
    }

    public synchronized void recogerIngredientes(int idFumador) {
        while (!mesaOcupada || ingredienteEnMesa != idFumador) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("El fumador " + idFumador + " recoge los ingredientes y empieza a fumar.");
        mesaOcupada = false;
        ingredienteEnMesa = -1;
        notifyAll();
    }
}

