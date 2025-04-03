import java.util.Scanner;

public class Questao2 {
    public static void main(String[] args) {
        int[] vetor = new int[10];
        int somaPonderada = 0, somaPesos = 0;
        double mediaPonderada = 0;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite 10 numeros inteiros");
        for (int i = 0; i < 10; i++) {
            System.out.print("Numero " + i + ": ");
            vetor[i] = scanner.nextInt();
            somaPonderada += vetor[i] * i;
            somaPesos += i;
        }

        scanner.close();

        if (somaPesos != 0) {
            mediaPonderada = (double) somaPonderada / somaPesos;
        }

        System.out.println("Media ponderada: " + mediaPonderada);
    }
}

