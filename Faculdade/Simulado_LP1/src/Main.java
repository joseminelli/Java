import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final Scanner scanner = new Scanner(System.in);

    public static int escolherPorta() {
        int portaEscolhida;
        do {
            System.out.println("Escolha uma porta (1, 2 ou 3): ");
            while (!scanner.hasNextInt()) {
                System.out.println("Entrada inválida! Por favor, insira um número.");
                scanner.next();
            }
            portaEscolhida = scanner.nextInt();
            if (portaEscolhida < 1 || portaEscolhida > 3) {
                System.out.println("Porta inválida! Escolha uma porta (1, 2 ou 3): ");
            }
        } while (portaEscolhida < 1 || portaEscolhida > 3);
        return portaEscolhida;
    }

    public static void jogo() {
        Random random = new Random();

        System.out.println("\n\nBem-vindo ao Monty Hall!");
        int portaPremiada = random.nextInt(3) + 1;
        int portaEscolhida = escolherPorta();
        int portaVazia;

        do {
            portaVazia = random.nextInt(3) + 1;
        } while (portaVazia == portaPremiada || portaVazia == portaEscolhida);

        System.out.println("A porta " + portaVazia + " está vazia. Deseja trocar de porta? (s/n)");
        scanner.nextLine();
        String trocar = scanner.nextLine().trim().toLowerCase();

        if ("s".equals(trocar)) {
            portaEscolhida = 6 - portaEscolhida - portaVazia;
        }

        if (portaEscolhida == portaPremiada) {
            System.out.println("\nVocê ganhou!\n");
        } else {
            System.out.println("\nVocê perdeu! A porta premiada era a " + portaPremiada + "\n");
        }

        System.out.println("Deseja jogar novamente? (s/n)");
        if ("s".equals(scanner.nextLine().toLowerCase())) {
            jogo();
        } else {
            System.out.println("Saindo...");
        }
    }

    public static void main(String[] args) {
        jogo();
    }
}