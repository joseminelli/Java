import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;

public class Estoque {

    public void atualizarEstoque(List<ItemVenda> itens) {
        File file = new File();
        List<Produto> produtos = file.ReadArrayJson("src/produtos.json", Produto.class);
        for (ItemVenda item : itens) {
            Produto produto = item.getProduto();
            for (Produto p : produtos) {
                if (p.getId() == produto.getId()) {
                    p.setQuantidade(p.getQuantidade() - item.getQuantidade());
                }
            }
        }

        file.WriteArrayJson("src/produtos.json", produtos);
        RemoverEstoque0();
    }

    private void RemoverEstoque0() {
        File file = new File();
        List<Produto> produtos = file.ReadArrayJson("src/produtos.json", Produto.class);
        produtos.removeIf(produto -> produto.getQuantidade() == 0);
        file.WriteArrayJson("src/produtos.json", produtos);
    }

    public boolean verificarDisponibilidadeArray(List<ItemVenda> itens) {
        File file = new File();
        List<Produto> produtos = file.ReadArrayJson("src/produtos.json", Produto.class);
        for (ItemVenda item : itens) {
            Produto produto = item.getProduto();
            for (Produto p : produtos) {
                if (p.getId() == produto.getId() && p.getQuantidade() < item.getQuantidade()) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void adicionarProduto() {
        Scanner scanner = new Scanner(System.in);
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
        List<Produto> produtos = file.ReadArrayJson("src/produtos.json", Produto.class);
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
        TerminalColor.Green();
        System.out.println("Produto cadastrado com sucesso!");
        TerminalColor.RESET();
    }


    public static void addprodutoGUI(String nomeProduto, double precoProduto, String categoriaProduto, int quantidadeProduto, String corBanda){
        File file = new File();
        List<Produto> produtos = file.ReadArrayJson("src/produtos.json", Produto.class);
        switch (categoriaProduto) {
            case "Blusa":
                Produto novaBlusa = new Blusa(produtos.size() + 1, nomeProduto, precoProduto, quantidadeProduto, corBanda);
                file.AddObjectJson("src/produtos.json", novaBlusa);
                break;
            case "Vinil":
                Produto novoVinil = new Vinil(produtos.size() + 1, nomeProduto, precoProduto, quantidadeProduto, corBanda);
                file.AddObjectJson("src/produtos.json", novoVinil);
                break;
        }
    }

    public static void removerProduto(int id) {
        File file = new File();
        List<Produto> produtos = file.ReadArrayJson("src/produtos.json", Produto.class);
        for (Produto produto : produtos) {
            if (produto.getId() == id) {
                produtos.remove(produto);
                file.WriteArrayJson("src/produtos.json", produtos);
                TerminalColor.Green();
                System.out.println("Produto removido com sucesso!");
                TerminalColor.RESET();
                return;
            }
        }
        TerminalColor.Red();
        System.out.println("Produto não encontrado!");
        TerminalColor.RESET();
    }

    public static void listarProdutos() {
        File file = new File();
        List<Produto> produtos = file.ReadArrayJson("src/produtos.json", Produto.class);
        TerminalColor.Cyan();
        System.out.println("\n### LISTA DE PRODUTOS ###");
        TerminalColor.RESET();
        for (Produto produto : produtos) {
            TerminalColor.RandomColor();
            System.out.println("ID: " +produto.getId() + " - " + produto.getNome() + " - " + NumberFormat.getCurrencyInstance().format(produto.getPreco()) + " - " + produto.getQuantidade() + " unidade(s)");
            TerminalColor.RESET();
        }
    }

    public List<Produto> getProdutos() {
        File file = new File();
        List<Produto> produtos = file.ReadArrayJson("src/produtos.json", Produto.class);
        return produtos;
    }

    public boolean verificarDisponibilidade(ItemVenda item) {
        File file = new File();
        List<Produto> produtos = file.ReadArrayJson("src/produtos.json", Produto.class);
        Produto produto = item.getProduto();
        for (Produto p : produtos) {
            if (p.getId() == produto.getId() && p.getQuantidade() < item.getQuantidade()) {
                return false;
            }
        }
        return true;
    }

}