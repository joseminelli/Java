import java.util.Objects;
import java.util.Scanner;

public class Menu {
    public static void Encerrar() {

        System.out.println("Pressione ENTER para continuar");
        try {
            int read = System.in.read(new byte[1]);
            System.out.println("Encerrando...");
        } catch (Exception e) {
            System.out.println("Erro ao encerrar");
        }
    }

    public static void main(String[] args) {

        int opcao = -1;
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.println(" ========= Menu ========= ");
            System.out.println("1. Cadastrar Cliente");
            System.out.println("2. Cadastrar produto");
            System.out.println("3. Cadastrar vendedor");
            System.out.println("0. Sair");
            System.out.println("==================================");
            System.out.println("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    System.out.println("Cadastrando cliente...");
                    Encerrar();
                    break;
                case 2:
                    System.out.println("Cadastrando produto...");
                    Encerrar();
                    break;
                case 3:
                    System.out.println("Cadastrando vendedor...");
                    Encerrar();
                    break;
                case 0:
                    Encerrar();
                    break;
                default:
                    System.out.println("Opção inválida");
                    Encerrar();
                    break;
            }
        } while (opcao != 0);
    }
}
