import java.util.Scanner;

public class Questao1 {
    public static void main(String[] args){
        int tamanho = 10;

        int[] vector1 = new int[tamanho];
        int[] vector2 = new int[tamanho];
        double[] media = new double[tamanho];

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Digite 10 números para o 1° vetor:");
            for (int i = 0; i < vector1.length; i++) {
                System.out.print("Vetor 1 - [" + (i + 1) + "]: ");
                vector1[i] = scanner.nextInt();
            }

            System.out.println("Digite 10 números para o 2° vetor:");
            for (int i = 0; i < vector2.length; i++) {
                System.out.print("Vetor 2 - [" + (i + 1) + "]: ");
                vector2[i] = scanner.nextInt();
            }

            for (int i = 0; i < media.length; i++) {
                media[i] = (double) (vector1[i] + vector2[i]) / 2;
            }

            System.out.println("media dos vetores:");
            for (int i = 0; i < media.length; i++) {
                System.out.println("Média [" + (i + 1) + "]: " + media[i]);
            }
        } catch (Exception e) {
            System.out.println(' ');
            System.out.println("Ooops... algo deu errado");
        }
    }
}
