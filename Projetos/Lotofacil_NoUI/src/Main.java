import javax.sound.midi.Soundbank;
import java.net.CookieHandler;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Main {

    public static void Encerrar() {

        System.out.println("Pressione ENTER para continuar");
        try {
            int read = System.in.read(new byte[1]);
            System.out.println("Encerrando...\n");
        } catch (Exception e) {
            System.out.println("Erro ao encerrar");
        }
    }

    public static int mostrarMenu(){
        Scanner Console = new Scanner(System.in);
        Color.Purple();
        System.out.println("======= Lotofácil =======");
        Color.RESET();
        System.out.println("[1] - Apostar de 0 a 100");
        System.out.println("[2] - Apostar de A à Z");
        System.out.println("[3] - Apostar em par ou ímpar");
        System.out.println("[0] - Sair");
        System.out.print("Escolha uma opção: ");
        return Console.nextInt();
    }

    public static void main(String[] args) throws Exception {
        Lotofacil lotofacil = new Lotofacil();
        int opcao;
        do {
            opcao = mostrarMenu();
            switch (opcao) {
                case 1:
                    lotofacil.numericGame();
                    Encerrar();
                    break;
                case 2:
                    lotofacil.letterGame();
                    Encerrar();
                    break;
                case 3:
                    lotofacil.parImpar();
                    Encerrar();
                    break;
                case 0:
                    System.err.println("Saindo...");
                    break;
                default:
                    Color.Red();
                    System.out.println("Opção inválida!\n");
                    Color.RESET();
            }
        } while (opcao != 0);
    }
}
