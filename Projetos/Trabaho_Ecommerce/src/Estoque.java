import java.util.List;
import java.util.Date;

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
    }

    public boolean verificarDisponibilidade(List<ItemVenda> itens) {
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
}