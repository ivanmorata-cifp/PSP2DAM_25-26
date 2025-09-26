package Tema1.Ejercicio12;

public class Sumador {
    public static int sumarIntervalo(int n1, int n2) {
        int inicio = Math.min(n1, n2);
        int fin = Math.max(n1, n2);
        int suma = 0;
        for (int i = inicio; i <= fin; i++) {
            suma += i;
        }
        return suma;
    }

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Uso: java Sumador <n1> <n2>");
            System.exit(1);
        }

        try {
            int n1 = Integer.parseInt(args[0]);
            int n2 = Integer.parseInt(args[1]);

            int resultado = sumarIntervalo(n1, n2);
            System.out.println("La suma entre " + n1 + " y " + n2 + " es: " + resultado);

        } catch (NumberFormatException e) {
            System.err.println("Error: los parámetros deben ser números enteros.");
            System.exit(2);
        }
    }


}
