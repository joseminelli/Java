public class TesteProduto {
    public static void main(String[] args){
        Produto p1 = new Produto("Produto 1", 10.0, 10);
        Produto p2 = new Produto("Produto 2", 20.0, 20);

        System.out.println("==== Produto 1 ====\n Nome:" + p1.getNome() + "\n Preço: " + p1.getPrecoUnit() + "\n Estoque: " + p1.getQtdEstoque());
        System.out.println();
        System.out.println("==== Produto 2 ====\n Nome:" + p2.getNome() + "\n Preço: " + p2.getPrecoUnit() + "\n Estoque: " + p2.getQtdEstoque());

        System.out.println();
        p1.addEstoque(10);
        System.out.println("Adicionando 10 unidades ao estoque do Produto 1");
        p2.removeEstoque(10);
        System.out.println("Removendo 10 unidades do estoque do Produto 2");

        System.out.println();
        System.out.println("==== Produto 1 ====\n Nome:" + p1.getNome() + "\n Preço: " + p1.getPrecoUnit() + "\n Estoque: " + p1.getQtdEstoque());
        System.out.println();
        System.out.println("==== Produto 2 ====\n Nome:" + p2.getNome() + "\n Preço: " + p2.getPrecoUnit() + "\n Estoque: " + p2.getQtdEstoque());
    }
}
