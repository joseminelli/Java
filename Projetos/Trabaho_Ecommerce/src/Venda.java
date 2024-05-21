import java.util.Date;
import java.util.List;

public class Venda {
    private int id;
    private Cliente cliente;
    private List<ItemVenda> itens;
    private Date data;
    private FormaPagamento formaPagamento;
    private String status;


    public void NewVenda(Cliente cliente, List<ItemVenda> itens, FormaPagamento formaPagamento) {
        File file = new File();
        List<Venda> vendas = file.ReadArrayJson("src/vendas.json", Venda.class);
        this.id = vendas.size() + 1;
        this.cliente = cliente;
        this.itens = itens;
        this.formaPagamento = formaPagamento;
        this.data = new Date();
        this.status = "Em andamento";
        vendas.add(this);
        file.WriteArrayJson("src/vendas.json", vendas);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemVenda item : itens) {
            total += item.getSubtotal();
        }
        return total;
    }

    public int getId() {
        return id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public List<ItemVenda> getItens() {
        return itens;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }
}