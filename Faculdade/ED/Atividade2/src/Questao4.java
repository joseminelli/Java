import java.util.Scanner;

public class Questao4 {
    public static void main(String[] args) {
        double vetor[] = new double[100];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um numero");
        vetor[1] = scanner.nextInt();

        for (int i = 2; i < vetor.length; i++) {
            vetor[i] = vetor[i-1]/2;
        }

        for (double i : vetor) {
            System.out.print(i + " ");
       }
    }
}
