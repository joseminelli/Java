import java.util.Scanner;

public class CadastroProdutos {
    public static void main(String[] args){
        Produto[] produtos = new Produto[3];

        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < produtos.length; i++) {
            Produto produto = new Produto();
            System.out.println("Digite o nome do produto: ");
            produto.nome = scanner.nextLine();
            System.out.println("Digite o preço do produto: ");
            produto.preco = scanner.nextDouble();
            System.out.println("Digite a quantidade do produto: ");
            produto.quantidade = scanner.nextInt();
            scanner.nextLine();
            produtos[i] = produto;
        }

        Produto maiorValor = new Produto();
        int MaiorvalorTot = 0;
        int valorTotal = 0;

        System.out.println("Produtos cadastrados: " );

        for(Produto produto : produtos){

            System.out.println("\nNome: " + produto.nome);
            System.out.println("Preço: " + produto.preco);
            System.out.println("Quantidade: " + produto.quantidade);
            System.out.println("Total: " + produto.preco * produto.quantidade);

            if (produto.preco * produto.quantidade > MaiorvalorTot){
                maiorValor = produto;
            }
            valorTotal += (int) (produto.preco * produto.quantidade);
        }

        System.out.println("Produto de maior valor: " + maiorValor.nome);

        System.out.println("Media de valor dos produtos: " + valorTotal / produtos.length);
    }
}
