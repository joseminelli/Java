import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File();
        List<Produto> produtos = file.ReadArrayJson("src/produtos.json", Produto.class);

        Cliente cliente = file.ReadJson("src/clientes.json", Cliente.class);
        if (cliente == null) {
            cliente = Cliente.CadastrarCliente();
        }
        Carrinho carrinho = new Carrinho(cliente);

        carrinho.setCliente(cliente);

        while (true) {
            TerminalColor.Blue();
            System.out.println("\n### RETRO STORE ###");
            TerminalColor.RESET();
            System.out.println("1. Gerenciar Produtos");
            System.out.println("2. Ver Todos os Produtos");
            System.out.println("3. Seu Carrinho");
            System.out.println("4. Sua conta");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    GerenciarProdutosMenu(scanner);
                    break;
                case 2:
                    Estoque.listarProdutos();
                    Encerrar();
                    break;
                case 3:
                    Carrinho(carrinho, produtos);
                    Encerrar();
                    break;
                case 4:
                    ContaMenu(scanner, cliente);
                    Encerrar();
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }

    private static void ContaMenu(Scanner scanner, Cliente cliente) {
        TerminalColor.Blue();
        System.out.println("\n### SUA CONTA ###");
        TerminalColor.RESET();
        System.out.println("1. Ver Dados da Conta");
        System.out.println("2. Editar Dados da Conta");
        System.out.println("3. Ver Compras");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                cliente.MostrarCliente();
                break;
            case 2:
                cliente.EditarConta();
                break;
            case 3:
                cliente.VerVendas();
            case 0:
                System.out.println("Voltando...");
                return;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
        }
    }

    private static void GerenciarProdutosMenu(Scanner scanner) {
        TerminalColor.Blue();
        System.out.println("\n### GERENCIAR PRODUTOS ###");
        TerminalColor.RESET();
        System.out.println("1. Adicionar Produto");
        System.out.println("2. Remover Produto");
        System.out.println("0. Voltar");
        System.out.print("Escolha uma opção: ");
        int opcao = scanner.nextInt();
        scanner.nextLine();

        switch (opcao) {
            case 1:
                Estoque.adicionarProduto();
                Encerrar();
                break;
            case 2:
                RemoverProdutoLoja(scanner);
            case 0:
                System.out.println("Voltando...");
                return;
            default:
                System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
        }
    }

    private static void RemoverProdutoLoja(Scanner scanner) {
        Estoque.listarProdutos();
        System.out.print("Digite o ID do produto que deseja remover: ");
        int idProduto = scanner.nextInt();
        scanner.nextLine();
        Estoque.removerProduto(idProduto);
    }

    static void Carrinho(Carrinho carrinho, List<Produto> produtos) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            TerminalColor.Blue();
            System.out.println("\n### CARRINHO ###");
            TerminalColor.RESET();
            System.out.println("1. Adicionar Produto ao Carrinho");
            System.out.println("2. Remover Produto do Carrinho");
            System.out.println("3. Ver carrinho");
            System.out.println("4. Finalizar Compra");
            System.out.println("0. Voltar");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    AddCarrinho(carrinho, scanner, produtos);
                    Encerrar();
                    break;
                case 2:
                    RemoverProdutoCarrinho(carrinho, scanner);
                    Encerrar();
                    break;
                case 3:
                    carrinho.ListarCarrinho(false);
                    Encerrar();
                    break;
                case 4:
                    carrinho.FinalizarCompra();
                    Encerrar();
                    break;
                case 0:
                    return;
                default:
                    System.out.println("Opção inválida. Por favor, escolha uma opção válida.");
            }
        }
    }


    public static void RemoverProdutoCarrinho(Carrinho carrinho, Scanner scanner) {
        if (carrinho == null) {
            System.out.println("Carrinho não encontrado...");
        } else {


            carrinho.ListarCarrinho(true);
            System.out.print("Digite o ID do produto que deseja remover do carrinho: ");
            int idProduto = scanner.nextInt();
            scanner.nextLine();
            Produto produtoSelecionado = null;
            for (ItemVenda item : carrinho.getItens()) {
                if (item.getProduto().getId() == idProduto) {
                    produtoSelecionado = item.getProduto();
                    break;
                }
            }
            if (produtoSelecionado != null) {
                if (!carrinho.removerItem(new ItemVenda(produtoSelecionado, 1))) {
                    TerminalColor.Red();
                    System.out.println("Erro ao remover o produto do carrinho.");
                    TerminalColor.RESET();
                    return;
                }
                TerminalColor.Green();
                System.out.println("O Produto '" + produtoSelecionado.getNome() + "' removido do carrinho.");
                TerminalColor.RESET();
            } else {
                TerminalColor.Red();
                System.out.println("Produto não encontrado.");
                TerminalColor.RESET();
            }
        }
    }

    private static void AddCarrinho(Carrinho carrinho, Scanner scanner, List<Produto> produtos) {
        if (carrinho == null) {
            System.out.println("Carrinho não encontrado...");
        } else {
            Estoque.listarProdutos();
            System.out.print("Digite o ID do produto que deseja adicionar ao carrinho: ");
            int idProduto = scanner.nextInt();
            scanner.nextLine();
            Produto produtoSelecionado = null;
            for (Produto produto : produtos) {
                if (produto.getId() == idProduto) {
                    produtoSelecionado = produto;
                    break;
                }
            }
            if (produtoSelecionado != null) {
                if (!carrinho.adicionarItem(new ItemVenda(produtoSelecionado, 1)))
                    return;
                TerminalColor.Green();
                System.out.println("O Produto '" + produtoSelecionado.getNome() + "' adicionado ao carrinho.");
                TerminalColor.RESET();
            } else {
                TerminalColor.Red();
                System.out.println("Produto não encontrado.");
                TerminalColor.RESET();
            }
        }
    }
    public static void Encerrar() {

        System.out.println("Pressione ENTER para continuar");
        try {
            int read = System.in.read(new byte[1]);
            TerminalColor.Yellow();
            System.out.println("voltando...");
            TerminalColor.RESET();
        } catch (Exception e) {
            System.out.println("Erro ao encerrar");
        }
    }
}
