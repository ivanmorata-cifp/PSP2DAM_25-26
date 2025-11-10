package Tema2.Extra.EstancoAlternativo;

public class Estanco {
    private boolean hayTabaco = false;
    private boolean hayPapel = false;
    private boolean hayCerillas = false;
    private boolean mesaOcupada = false;

    public synchronized void colocarIngredientes(int ingredienteFaltante) {
        while (mesaOcupada) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        hayTabaco = false;
        hayPapel = false;
        hayCerillas = false;

        switch (ingredienteFaltante) {
            case 0: // Fumador con tabaco, faltan papel y cerillas
                hayPapel = true;
                hayCerillas = true;
                break;
            case 1: // Fumador con papel, faltan tabaco y cerillas
                hayTabaco = true;
                hayCerillas = true;
                break;
            case 2: // Fumador con cerillas, faltan tabaco y papel
                hayTabaco = true;
                hayPapel = true;
                break;
        }

        mesaOcupada = true;

        System.out.println("El estanquero coloca ingredientes. Puede fumar el fumador " + ingredienteFaltante);
        notifyAll();
    }

    public synchronized void recogerIngredientes(int idFumador) {
        while (!mesaOcupada || !puedeFumar(idFumador)) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        System.out.println("El fumador " + idFumador + " recoge los ingredientes y empieza a fumar.");
        limpiarMesa();
        notifyAll();
    }

    private boolean puedeFumar(int idFumador) {
        switch (idFumador) {
            case 0: // Tiene tabaco, necesita papel y cerillas
                return (hayPapel && hayCerillas);
            case 1: // Tiene papel, necesita tabaco y cerillas
                return (hayTabaco && hayCerillas);
            case 2: // Tiene cerillas, necesita tabaco y papel
                return (hayTabaco && hayPapel);
            default:
                return false;
        }
    }

    private void limpiarMesa() {
        hayTabaco = false;
        hayPapel = false;
        hayCerillas = false;
        mesaOcupada = false;
        System.out.println("El fumador limpia la mesa y avisa al estanquero.");
    }
}

