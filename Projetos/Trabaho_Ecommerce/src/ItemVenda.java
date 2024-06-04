
import java.text.NumberFormat;

public class ItemVenda {
    private Produto produto;
    private int quantidade;

    public ItemVenda(Produto produto, int quantidade) {
        this.produto = produto;
        this.quantidade = quantidade;
    }

    public double getSubtotal() {
        return produto.getPreco() * quantidade;
    }

    public double setSubtotal(double subtotal) {
        return produto.getPreco() * quantidade;
    }

    public Produto getProduto() {
        return produto;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String ItemVendaToString() {
        return produto.getNome() + ": " + quantidade + " unidade(s) - " + NumberFormat.getCurrencyInstance().format(produto.getPreco()) + " cada";
    }
}