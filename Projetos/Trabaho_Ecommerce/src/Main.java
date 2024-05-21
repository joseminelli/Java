import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        File file = new File();
        List<Produto> produtos = file.ReadArrayJson("src/produtos.json", Produto.class);

        Cliente cliente = file.ReadJson("src/clientes.json", Cliente.class);
        if (cliente == null) {
            cliente = CadastroCliente(scanner);
        }
        Carrinho carrinho = new Carrinho(cliente);

        carrinho.setCliente(cliente);

        while (true) {
            Color.Blue();
            System.out.println("\n### MENU PRINCIPAL ###");
            Color.RESET();
            System.out.println("1. Cadastrar Produto");
            System.out.println("2. Ver Todos os Produtos");
            System.out.println("3. Adicionar Produto ao Carrinho");
            System.out.println("4. Ver Carrinho");
            System.out.println("5. Finalizar Compra");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    CadastroProduto(scanner, produtos);
                    Encerrar();
                    break;
                case 2:
                    ListarProdutos(produtos);
                    Encerrar();
                    break;
                case 3:
                    AddCarrinho(carrinho, scanner, produtos, cliente);
                    Encerrar();
                    break;
                case 4:
                    ListarCarrinho(carrinho);
                    Encerrar();
                    break;
                case 5:
                    carrinho = FinalizarCompra(carrinho);
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

    private static void AddProdutosBase(List<Produto> produtos) {
        List<Produto> produtosBase = new ArrayList<>();
        produtosBase.add(new Blusa(1, "Camisa Nirvana", 29.90, 3, "Amarela"));
        produtosBase.add(new Vinil(2, "Vinil - Enema Of The State", 79.90, 4, "Blink 182"));
        produtosBase.add(new Blusa(3, "Camisa Ramones", 29.90, 10, "Preta"));
        produtosBase.add(new Blusa(4, "Camisa Metallica", 19.90, 10, "Cinza"));

        File file = new File();
        file.WriteArrayJson("src/produtos.json", produtosBase);
    }


    private static Carrinho FinalizarCompra(Carrinho carrinho) {
        if (carrinho == null || carrinho.getItens().isEmpty()) {
            System.out.println("Carrinho vazio. Não é possível finalizar a compra.");
        } else {
            FormaPagamento formaPagamento = new FormaPagamento();
            System.out.println("\nEscoha a forma de pagamento:");
            System.out.println("1. Cartão de Crédito");
            System.out.println("2. Boleto");
            System.out.println("3. Pix");
            Scanner scanner = new Scanner(System.in);
            int opcao = scanner.nextInt();
            switch (opcao) {
                case 1:
                    formaPagamento.setCartaoCredito();
                    break;
                case 2:
                    formaPagamento.setBoleto();
                    break;
                case 3:
                    formaPagamento.setPix();
                    break;
                default:
                    System.out.println("Opção inválida. Forma de pagamento não definida.");
            }

            carrinho.setFormaPagamento(formaPagamento);
           if(!carrinho.FinalizarCompra()){
                Color.Red();
                System.out.println("Erro ao finalizar a compra.");
                Color.RESET();
                return carrinho;
           }
            System.out.println("\nPedido total de: R$" + carrinho.calcularTotal());
            System.out.println("\nDetalhes da compra:");
            for (ItemVenda item : carrinho.getItens()) {
                System.out.println(item.getProduto().getNome() + ": " + item.getQuantidade() + " unidade(s) - R$" + item.getSubtotal()+ " (R$" + item.getProduto().getPreco() + " cada)");
            }
            System.out.println("\nForma de pagamento: " + carrinho.getFormaPagamento().getNome());

            if (carrinho.getCliente() != null) {
                System.out.println("\nDetalhes da entrega:");
                System.out.println("Cliente: " + carrinho.getCliente().getNome());
                System.out.println("Endereço: " + carrinho.getCliente().getEndereco().getRua() + ", " + carrinho.getCliente().getEndereco().getCidade() + " - " + carrinho.getCliente().getEndereco().getCep());
            } else {
                System.out.println("Detalhes da entrega: Cliente não cadastrado.");
            }
            Color.Green();
            System.out.println("\nCompra finalizada com sucesso!");
            Color.RESET();
        }
        return carrinho;
    }


    private static void ListarCarrinho(Carrinho carrinho) {
        if (carrinho == null) {
            System.out.println("Carrinho vazio.");
        } else {
            Color.Cyan();
            System.out.println("\n### CARRINHO ###");
            Color.RESET();
            for (ItemVenda item : carrinho.getItens()) {
                System.out.println(item.getProduto().getNome() + ": " + item.getQuantidade() + " unidade(s) - R$" + item.getProduto().getPreco() + " cada");
            }
        }
    }

    private static void AddCarrinho(Carrinho carrinho, Scanner scanner, List<Produto> produtos, Cliente cliente) {
        if (carrinho == null) {
            System.out.println("Carrinho não encontrado...");
        } else {
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
                carrinho.adicionarItem(new ItemVenda(produtoSelecionado, 1));
                Color.Green();
                System.out.println("O Produto '"+ produtoSelecionado.getNome() + "' adicionado ao carrinho.");
                Color.RESET();
            } else {
                Color.Red();
                System.out.println("Produto não encontrado.");
                Color.RESET();
            }
        }
    }

    private static void ListarProdutos(List<Produto> produtos) {
        Color.Cyan();
        System.out.println("\n### LISTA DE PRODUTOS ###");
        Color.RESET();
        for (Produto produto : produtos) {
            System.out.println(produto.getId() + ". " + produto.getNome() + " - R$" + produto.getPreco());
        }
    }

    private static void CadastroProduto(Scanner scanner, List<Produto> produtos) {
        System.out.print("Digite o nome do produto: ");
        String nomeProduto = scanner.nextLine();
        System.out.print("Digite o preço do produto: ");
        double precoProduto = scanner.nextDouble();
        System.out.print("Escolha a categoria do produto \n [1] Blusa \n [2] Vinil \nDigite o número correspondente a categoria do produto:");
        int categoriaProduto;
        do {
            categoriaProduto = scanner.nextInt();
        } while (categoriaProduto < 1 || categoriaProduto > 2);

        System.out.print("Digite a quantidade do produto: ");
        int quantidadeProduto = scanner.nextInt();
        File file = new File();
        switch (categoriaProduto) {
            case 1:
                System.out.print("Digite a cor da blusa: ");
                String corBlusa = scanner.next();
                Produto novaBlusa = new Blusa(produtos.size() + 1, nomeProduto, precoProduto, quantidadeProduto, corBlusa);
                file.AddObjectJson("src/produtos.json", novaBlusa);
               // produtos.add(novaBlusa);
                break;
            case 2:
                System.out.print("Digite o nome da banda do vinil: ");
                String bandaVinil = scanner.next();
                Produto novoVinil = new Vinil(produtos.size() + 1, nomeProduto, precoProduto, quantidadeProduto, bandaVinil);
                file.AddObjectJson("src/produtos.json", novoVinil);
               // produtos.add(novoVinil);
                break;
        }
        Color.Green();
        System.out.println("Produto cadastrado com sucesso!");
        Color.RESET();
    }

    private static Cliente CadastroCliente(Scanner scanner) {
        File file = new File();

        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite o email do cliente: ");
        String emailCliente = scanner.nextLine();
        System.out.print("Digite a rua do endereço do cliente: ");
        String ruaEndereco = scanner.nextLine();
        System.out.print("Digite a cidade do endereço do cliente: ");
        String cidadeEndereco = scanner.nextLine();
        System.out.print("Digite o CEP do endereço do cliente: ");
        String cepEndereco = scanner.nextLine();
        Endereco enderecoCliente = new Endereco(ruaEndereco, cidadeEndereco, cepEndereco);
        file.WriteJson("src/clientes.json", new Cliente(1, nomeCliente, emailCliente, enderecoCliente));
        Cliente cliente = new Cliente(1, nomeCliente, emailCliente, enderecoCliente);
        Color.Green();
        System.out.println("Cliente cadastrado com sucesso!");
        Color.RESET();
        return cliente;
    }

    public static void Encerrar() {

        System.out.println("Pressione ENTER para continuar");
        try {
            int read = System.in.read(new byte[1]);
            Color.Yellow();
            System.out.println("voltando...");
            Color.RESET();
        } catch (Exception e) {
            System.out.println("Erro ao encerrar");
        }
    }
}
