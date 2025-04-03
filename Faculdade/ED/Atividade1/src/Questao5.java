import java.util.Random;

public class Questao5 {
    public static void main(String[] args) {
        int tamanho = 100;
        int[] vetorAleatorio = new int[tamanho];
        int[] vetorDecrescente = new int[tamanho];

        for (int i = 0; i < tamanho; i++) {
            vetorAleatorio[i] = i;
        }
        embaralhar(vetorAleatorio);

        for (int i = 0; i < tamanho; i++) {
            vetorDecrescente[i] = tamanho - i;
        }

        System.out.println("Ordenando vetor aleatorio...");
        int[] copiaAleatorio = copiarVetor(vetorAleatorio);
        int trocasAleatorio = bubbleSort(copiaAleatorio);
        System.out.println("Número de trocas: " + trocasAleatorio);

        System.out.println("\nOrdenando vetor decrescente...");
        int[] copiaDecrescente = copiarVetor(vetorDecrescente);
        int trocasDecrescente = bubbleSort(copiaDecrescente);
        System.out.println("numero de trocas: " + trocasDecrescente);

        int valorBuscado = 50;
        int posicao = buscaBinaria(copiaAleatorio, valorBuscado, true);

        if (posicao != -1) {
            System.out.println("Numero encontrado na posição: " + posicao);
        } else {
            System.out.println("Numero não encontrado.");
        }
    }

    private static int[] copiarVetor(int[] vetor) {
        int[] copia = new int[vetor.length];
        for (int i = 0; i < vetor.length; i++) {
            copia[i] = vetor[i];
        }
        return copia;
    }

    private static int bubbleSort(int[] vetor) {
        int trocas = 0;
        int n = vetor.length;
        boolean trocou;

        for (int i = 0; i < n - 1; i++) {
            trocou = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (vetor[j] > vetor[j + 1]) {
                    int temp = vetor[j];
                    vetor[j] = vetor[j + 1];
                    vetor[j + 1] = temp;
                    trocas++;
                    trocou = true;
                }
            }
            if (!trocou) break;
        }
        return trocas;
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

    private static void embaralhar(int[] vetor) {
        Random random = new Random();
        for (int i = vetor.length - 1; i > 0; i--) {
            int j = random.nextInt(i + 1);
            int temp = vetor[i];
            vetor[i] = vetor[j];
            vetor[j] = temp;
        }
    }
}
