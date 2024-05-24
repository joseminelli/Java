import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.text.NumberFormat;

public class Carrinho {
    private Cliente cliente;
    private List<ItemVenda> itens;
    private FormaPagamento formaPagamento;

    public Carrinho(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public boolean adicionarItem(ItemVenda item) {
        File file = new File();
        List<ItemVenda> itens = file.ReadArrayJson("src/carrinho.json", ItemVenda.class);

        for( ItemVenda i : itens){
            int quantidadeCarrinho = i.getProduto().getQuantidade();
            int quantidadeItem = item.getQuantidade();
            if (quantidadeItem == quantidadeCarrinho){
                Color.Red();
                System.out.println("Não é possível adicionar o produto ao carrinho. Estoque insuficiente.");
                Color.RESET();
                return false;
            }
            if(i.getProduto().getId() == item.getProduto().getId()){
                i.setQuantidade(i.getQuantidade() + item.getQuantidade());
                file.WriteArrayJson("src/carrinho.json", itens);
                return true;
            } else{
                file.AddObjectJson("src/carrinho.json", item);
                return true;
            }
        }

        file.AddObjectJson("src/carrinho.json", item);

        itens.add(item);
        return true;
    }

    public boolean removerItem(ItemVenda item) {
        File file = new File();
        List<ItemVenda> itens = file.ReadArrayJson("src/carrinho.json", ItemVenda.class);
        for (ItemVenda i : itens) {
            if (i.getProduto().getId() == item.getProduto().getId()) {
                itens.remove(i);
                file.WriteArrayJson("src/carrinho.json", itens);
                return true;
            }
        }
        return false;
    }

    public void ListarCarrinho(boolean gerenciar) {
        if (!this.getItens().isEmpty()) {
            Color.Cyan();
            System.out.println("\n###SEU CARRINHO ###");
            Color.RESET();
            if (gerenciar) {
                this.ListarCarrinhoGerenciar();
            } else {
                this.ListarCarrinhoGeral();
            }
        }else {
            Color.Red();
            System.out.println("Carrinho vazio.");
            Color.RESET();
        }
    }


    private void ListarCarrinhoGeral(){
        for (ItemVenda item : this.getItens()) {
            Color.RandomColor();
            System.out.println(item.getProduto().getNome() + ": " + item.getQuantidade() + " unidade(s) - " + NumberFormat.getCurrencyInstance().format(item.getProduto().getPreco()) + " cada");
            Color.RESET();
        }
    }

    private void ListarCarrinhoGerenciar(){
        for (ItemVenda item : this.getItens()) {
            Color.RandomColor();
            System.out.println("[" + item.getProduto().getId() +"] " + item.getProduto().getNome() + ": " + item.getQuantidade() + " unidade(s)" );
            Color.RESET();
        }
    }

    public double calcularTotal() {
        double total = 0.0;
        File file = new File();
        List<ItemVenda> itens = file.ReadArrayJson("src/carrinho.json", ItemVenda.class);
        for (ItemVenda item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public List<ItemVenda> getItens() {
        File file = new File();
        return file.ReadArrayJson("src/carrinho.json", ItemVenda.class);
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public boolean Finalizar(){
        Estoque estoque = new Estoque();
        if (estoque.verificarDisponibilidadeArray(this.getItens())) {
            Venda venda = new Venda();
            venda.NewVenda(cliente, this.getItens(), formaPagamento);
            estoque.atualizarEstoque(this.getItens());
            return true;
        }
        else {
            return false;
        }
    }
    public void limparCarrinho() {
        File file = new File();
        file.WriteJson("src/carrinho.json", new ArrayList<>());
        itens.clear();
    }

    public void FinalizarCompra() {
        if (this.getItens().isEmpty()) {
            System.out.println("Carrinho vazio. Não é possível finalizar a compra.");
        } else {
            if(!this.Finalizar()){
                Color.Red();
                System.out.println("Produto com estoque insuficiente.");
                Color.RESET();
                return;
            }
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

            this.setFormaPagamento(formaPagamento);
            System.out.println("\nPedido total de: " + NumberFormat.getCurrencyInstance().format(calcularTotal()));
            System.out.println("\nDetalhes da compra:");
            for (ItemVenda item : getItens()) {
                System.out.println(item.getProduto().getNome() + ": " + item.getQuantidade() + " unidade(s) - " + NumberFormat.getCurrencyInstance().format(item.getSubtotal())+ " (" + NumberFormat.getCurrencyInstance().format(item.getProduto().getPreco()) + " cada)");
            }
            System.out.println("\nForma de pagamento: " + this.getFormaPagamento().getNome());

            if (this.getCliente() != null) {
                System.out.println("\nDetalhes da entrega:");
                System.out.println("Cliente: " + this.getCliente().getNome());
                System.out.println("Endereço: " + this.getCliente().getEndereco().getRua() + ", " + this.getCliente().getEndereco().getCidade() + " - " + this.getCliente().getEndereco().getCep());
            } else {
                System.out.println("Detalhes da entrega: Cliente não cadastrado.");
            }
            Color.Green();
            System.out.println("\nCompra finalizada com sucesso!");
            Color.RESET();
            limparCarrinho();
        }
    }
}
