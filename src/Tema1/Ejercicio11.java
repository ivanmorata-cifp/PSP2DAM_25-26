package Tema1;

import java.io.IOException;

public class Ejercicio11 {
    public static void main(String[] args) {
        ProcessBuilder pb = new ProcessBuilder("uptime", "-p");
        pb.inheritIO();
        try {
            Process proceso = pb.start();
            int codigoSalida = proceso.waitFor();
            System.out.println("Código de salida del proceso: " + codigoSalida);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
