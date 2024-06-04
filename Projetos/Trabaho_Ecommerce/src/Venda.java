import java.util.Date;
import java.util.List;
import java.text.NumberFormat;

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
        this.status = "Concluída";
        vendas.add(this);
        file.WriteArrayJson("src/vendas.json", vendas);
    }

    public static void MostrarVenda(){
        File file = new File();
        List<Venda> vendas = file.ReadArrayJson("src/vendas.json", Venda.class);
        for (Venda venda : vendas) {
            Color.RandomColor();
            System.out.println("\n===== VENDA ID: " + venda.id + " =====");
            Color.RESET();
            System.out.println("Cliente: " + venda.cliente.getNome());
            System.out.println("Data: " + venda.data);
            System.out.println("Status: " + venda.status);
            System.out.println("\nItens: ");
            for (ItemVenda item : venda.itens) {
                System.out.println("Produto: " + item.getProduto().getNome());
                System.out.println("Quantidade: " + item.getQuantidade());
                System.out.println("Preço unitário: " + NumberFormat.getCurrencyInstance().format(item.getProduto().getPreco()));
                System.out.println("Subtotal: " + NumberFormat.getCurrencyInstance().format(item.getSubtotal()));
            }
            System.out.println("\nTotal: " + NumberFormat.getCurrencyInstance().format(venda.calcularTotal()));

        }
    }

    public static List<Venda> getVendas(){
        File file = new File();
        return file.ReadArrayJson("src/vendas.json", Venda.class);
    }


    public String VendaToString() {
        StringBuilder output = new StringBuilder();
        File file = new File();
        List<Venda> vendas = file.ReadArrayJson("src/vendas.json", Venda.class);
        for (Venda venda : vendas) {
            output.append("\n===== VENDA ID: ").append(venda.id).append(" =====\n");
            output.append("Cliente: ").append(venda.cliente.getNome()).append("\n");
            output.append("Data: ").append(venda.data).append("\n");
            output.append("Status: ").append(venda.status).append("\n\n");
            output.append("Itens: \n");
            for (ItemVenda item : venda.itens) {
                output.append("Produto: ").append(item.getProduto().getNome()).append("\n");
                output.append("Quantidade: ").append(item.getQuantidade()).append("\n");
                output.append("Preço unitário: ").append(NumberFormat.getCurrencyInstance().format(item.getProduto().getPreco())).append("\n");
                output.append("Subtotal: ").append(NumberFormat.getCurrencyInstance().format(item.getSubtotal())).append("\n\n");
            }
            output.append("Total: ").append(NumberFormat.getCurrencyInstance().format(venda.calcularTotal())).append("\n\n");
        }
        return output.toString();
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

    public Date getData() {
        return data;
    }

    public String getStatus() {
        return status;
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