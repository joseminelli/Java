import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class Carrinho {
    private Cliente cliente;
    private List<ItemVenda> itens;
    private FormaPagamento formaPagamento;

    public Carrinho(Cliente cliente) {
        this.cliente = cliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemVenda item) {
        File file = new File();
        List<ItemVenda> itens = file.ReadArrayJson("src/carrinho.json", ItemVenda.class);

        for( ItemVenda i : itens){
            if(i.getProduto().getId() == item.getProduto().getId()){
                i.setQuantidade(i.getQuantidade() + item.getQuantidade());
                file.WriteArrayJson("src/carrinho.json", itens);
                return;
            } else{
                file.AddObjectJson("src/carrinho.json", item);
                return;
            }
        }

        file.AddObjectJson("src/carrinho.json", item);

        itens.add(item);
    }

    public void removerItem(ItemVenda item) {
        itens.remove(item);
    }

    public double calcularTotal() {
        double total = 0.0;
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

    public boolean FinalizarCompra(){
        Estoque estoque = new Estoque();
        if (estoque.verificarDisponibilidade(this.getItens())) {
            Venda venda = new Venda();
            venda.NewVenda(cliente, this.getItens(), formaPagamento);
            estoque.atualizarEstoque(this.getItens());
            limparCarrinho();
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
}
