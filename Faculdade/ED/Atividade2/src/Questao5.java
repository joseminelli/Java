import java.util.Scanner;

public class Questao5 {
    public static void main(String[] args) {
        long vetor[] = new long[100];
        vetor[0] = 0;
        vetor[1] = 1;

        Scanner scanner = new Scanner(System.in);

        System.out.println("digite um numero:");
        int n = scanner.nextInt();

        for (int i = 2; i < vetor.length; i++) {
            vetor[i] = vetor[i - 1] + vetor[i - 2];
        }

        if (n >= 0 && n < vetor.length) {
            System.out.println("o numero de fibonacci na posicao " + n + " é: " + vetor[n]);
        } else {
            System.out.println("numero fora do limite permitido");
        }

        scanner.close();
    }
}
