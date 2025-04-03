import java.util.Scanner;

public class Questao3 {
    public static void main(String[] args) {
        int vetor[] = new int[10];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um numero");
        vetor[1] = scanner.nextInt();

        for (int i = 2; i < vetor.length; i++) {
            vetor[i] = vetor[i-1] * 2;
        }

        for (int i : vetor) {
            System.out.print(i + " ");
        }
    }
}
