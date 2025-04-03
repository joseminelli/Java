import java.util.Scanner;

public class Questao1 {
    public static void main(String[] args) {
       int vetor[] = new int[10];

        Scanner scanner = new Scanner(System.in);
       for (int i = 0; i < vetor.length; i++) {
           System.out.println("Digite o valor da posicao " + i);
           vetor[i] = scanner.nextInt();
       }

       System.out.println("\nnumeros pares: ");
        for (int i : vetor) {
            if (i % 2 == 0) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");
        System.out.println("numeros impares: ");
        for (int i : vetor) {
            if (i % 2 == 1) {
                System.out.print(i + " ");
            }
        }
    }
}