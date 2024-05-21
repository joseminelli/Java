import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int opcao;
        do{
            System.out.println("\n1 - Testar Produto");
            System.out.println("2 - Testar Pacote");
            System.out.println("3 - Sair");
            opcao = scanner.nextInt();
            switch (opcao){
                case 1:
                    testaProduto();
                    break;
                case 2:
                    testaPacote();
                    break;
                    case 3:
                        System.out.println("Saindo...");
                        break;
                default:
                    System.out.println("Opção inválida");
            }
        }while (opcao != 3);

    }

    private static void testaPacote() {
        PacoteExpresso pacoteExpresso = new PacoteExpresso(10);
        PacoteSimples pacoteSimples = new PacoteSimples(10);

        System.out.println("Custo do pacote expresso: " + pacoteExpresso.calcularCustoEnvio());
        System.out.println("Custo do pacote simples: " + pacoteSimples.calcularCustoEnvio());
    }

    public static void testaProduto(){

        Produto produto1 = new Produto("Caneta", 1.50);
        Produto produto2 = new Produto("Caderno", 5.00);


        System.out.println("Preço total (10 unidades de Caneta): R$" + produto1.calcularPrecoTotal(10));
        System.out.println("Preço total (15 unidades de Caderno): R$" + produto2.calcularPrecoTotal(15));
    }
}
