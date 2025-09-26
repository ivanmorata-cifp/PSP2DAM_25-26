package Tema1.Ejercicio12;

import java.io.IOException;

public class Ejercicio12 {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso: java Lanzador <n1> <n2>");
            System.exit(1);
        }
        try {
            ProcessBuilder pb = new ProcessBuilder("java", "Sumador", args[0], args[1]);
            pb.inheritIO();
            Process proceso = pb.start();
            int codigoSalida = proceso.waitFor();
            System.out.println("Código de salida: " + codigoSalida);
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
