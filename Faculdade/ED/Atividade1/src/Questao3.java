import java.util.Scanner;

public class Questao3 {
    public static void main(String args[]) {
        Scanner scanner = new Scanner(System.in);

        int[] par = new int[5];
        int[] impar = new int[5];

        int contadorPar = 0;
        int contadorImpar = 0;
        try {
            while (contadorPar < 5 || contadorImpar < 5) {
                System.out.print("Digite um numero: ");
                int numero = scanner.nextInt();

                if (numero % 2 == 0) {
                    if (contadorPar < 5) {
                        par[contadorPar] = numero;
                        contadorPar++;
                    } else {
                        System.out.println("O vetor de pares está cheio");
                    }
                } else {
                    if (contadorImpar < 5) {
                        impar[contadorImpar] = numero;
                        contadorImpar++;
                    } else {
                        System.out.println("O vetor de ímpares está cheio");
                    }
                }
            }

            System.out.println("Vetor de pares:");
            for (int i = 0; i < par.length; i++) {
                System.out.println("Par [" + (i + 1) + "]: " + par[i]);
            }

            System.out.println("\nVetor de ímpares:");
            for (int i = 0; i < impar.length; i++) {
                System.out.println("Ímpar [" + (i + 1) + "]: " + impar[i]);
            }

        } catch (Exception e) {
            System.out.println(' ');
            System.out.println("Ooops... algo deu errado\n");

            System.out.println("Vetor de pares lidos antes do erro:");
            for (int i = 0; i < contadorPar; i++) {
                System.out.println("Par [" + (i + 1) + "]: " + par[i]);
            }
            System.out.println("\nVetor de ímpares lidos antes do erro:");
            for (int i = 0; i < contadorImpar; i++) {
                System.out.println("Ímpar [" + (i + 1) + "]: " + impar[i]);
            }
        }


    }
}
