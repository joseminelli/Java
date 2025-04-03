import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Menu();
    }

    private static void Menu() {
        int option;
        Scanner scanner = new Scanner(System.in);
        try {
            do {
                // Menu
                System.out.println("[1] - Questão 1");
                System.out.println("[2] - Questão 2");
                System.out.println("[3] - Questão 3");
                System.out.println("[4] - Questão 4");
                System.out.println("[0] - Sair");
                System.out.print("Digite a opção desejada: ");
                option = scanner.nextInt();
                switch (option) {
                    case 1:
                        Questao1();
                        Encerrar();
                        break;
                    case 2:
                        Questao2();
                        Encerrar();
                        break;
                    case 3:
                        Questao3();
                        Encerrar();
                        break;
                    case 4:
                        Questao4();
                        Encerrar();
                        break;
                    case 0:
                        System.out.println("Saindo...");
                        Encerrar();
                        break;
                    default:
                        System.out.println(' ');
                        System.out.println(' ');
                        System.out.println(' ');
                        System.out.println("Opção inválida! Tente novamente.");
                        break;
                }
            } while (option != 0);
        } catch (Exception e) {
            System.out.println(' ');
            System.out.println("Ooops... algo deu errado");

            Menu();
        }
        scanner.close();
    }

    private static void Questao1() {
        int tamanho = 3;

        int[] vector1 = new int[tamanho];
        int[] vector2 = new int[tamanho];
        double[] media = new double[tamanho];

        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Digite 10 números para o primeiro vetor:");
            for (int i = 0; i < vector1.length; i++) {
                System.out.print("Vetor 1 [" + (i + 1) + "]: ");
                vector1[i] = scanner.nextInt();
            }

            System.out.println("Digite 10 números para o segundo vetor:");
            for (int i = 0; i < vector2.length; i++) {
                System.out.print("Vetor 2 [" + (i + 1) + "]: ");
                vector2[i] = scanner.nextInt();
            }

            for (int i = 0; i < media.length; i++) {
                media[i] = (double) (vector1[i] + vector2[i]) / 2;
            }

            System.out.println("Média dos vetores:");
            for (int i = 0; i < media.length; i++) {
                System.out.println("Média [" + (i + 1) + "]: " + media[i]);
            }
        } catch (Exception e) {
            System.out.println(' ');
            System.out.println("Ooops... algo deu errado");
        }
    }

    private static void Questao2() {
        int length = 100;
        int[] vector = new int[length];
        int[] smallVector = new int[length / 2];
        Random random = new Random();
        int lower = Integer.MAX_VALUE;
        int lowerPos = 0;
        int sum = 0;

        for (int i = 0; i < vector.length; i++) {
            vector[i] = random.nextInt(100);
        }

        for (int i = 0; i < vector.length; i++) {

            //menor num
            if (vector[i] < lower) {
                lower = vector[i];
                lowerPos = i;
            }

            //soma
            sum += vector[i];

            // soma da posicao oposta
            if (i < length / 2) {
                smallVector[i] = vector[i] + vector[length - i - 1];
            }
        }

    }

    private static void Questao3() {
        Scanner scanner = new Scanner(System.in);

        int[] par = new int[5];
        int[] impar = new int[5];

        int contadorPar = 0;
        int contadorImpar = 0;

        while (contadorPar < 5 || contadorImpar < 5) {
            System.out.print("Digite um número: ");
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

        System.out.println("Vetor de ímpares:");
        for (int i = 0; i < impar.length; i++) {
            System.out.println("Ímpar [" + (i + 1) + "]: " + impar[i]);
        }
    }

    public static void Questao4(){
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

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

        System.out.print("Digite o número que deseja buscar: ");
        int valor = scanner.nextInt();
        int resultado = buscaBinaria(vetor, valor, true);

        if (resultado != -1) {
            System.out.println("Número encontrado na posição: " + resultado);
        } else {
            System.out.println("Número não encontrado.");
        }
    }

    //  Bubble Sort
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
                System.out.println("Número de comparações: " + comparacoes);
                return meio;
            } else if (vetor[meio] < valor) {
                inicio = meio + 1;
            } else {
                fim = meio - 1;
            }
        }
        if (comparar)
            System.out.println("Número de comparações: " + comparacoes);
        return -1;
    }



    public static void Encerrar() {

        System.out.println("Pressione ENTER para continuar");
        try {
            int read = System.in.read(new byte[1]);
            System.out.println("Encerrando...");
        } catch (Exception e) {
            System.out.println("Erro ao encerrar");
        }
    }
}