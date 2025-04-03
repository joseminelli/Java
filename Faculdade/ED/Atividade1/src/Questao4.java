import java.util.Random;
import java.util.Scanner;

public class Questao4 {
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        try {
            System.out.print("Digite o tamanho do vetor: ");
            int tamanho = scanner.nextInt();
            int[] vetor = new int[tamanho];

            for (int i = 0; i < tamanho; i++) {
                vetor[i] = random.nextInt(1000);
            }

            bubbleSort(vetor);

            System.out.println("Vetor ordenado:");
            for (int num : vetor) {
                System.out.print(num + " ");
            }
            System.out.println();

            System.out.print("Digite o numero que deseja buscar: ");
            int valor = scanner.nextInt();
            int resultado = buscaBinaria(vetor, valor, true);

            if (resultado != -1) {
                System.out.println("numero encontrado na posição: " + resultado);
            } else {
                System.out.println("numero não encontrado.");
            }
        } catch (Exception e) {
            System.out.println(' ');
            System.out.println("Ooops... algo deu errado");
        }
    }

    private static void bubbleSort(int[] vetor) {
        int n = vetor.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {

                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                }
            }
        }
    }

    private static int buscaBinaria(int[] vetor, int valor, boolean comparar) {
        int inicio = 0, fim = vetor.length - 1;
        int comparacoes = 0;

        while (inicio <= fim) {
            int meio = (inicio + fim) / 2;
            comparacoes++;

            if (vetor[meio] == valor) {
                System.out.println("numero de comparações: " + comparacoes);
                return meio;
            } else if (vetor[meio] < valor) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        if (comparar)
            System.out.println("numero de comparações: " + comparacoes);
        return -1;
    }
}
