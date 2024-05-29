public class Main {
    public static void main(String[] args){
        Produto[] p1 = new Produto[10];
        AddProdutos(p1);
        System.out.println("========== Produtos p1 ==========");
        MostrarProdutos(p1);
        CalcularMedia(p1);
    }

    private static void AddProdutos(Produto[] p){
        for(int i = 0; i < p.length; i++){
            p[i] = new Produto();
            p[i].setNome("Produto " + i);
            p[i].setPreco(i * 10);
        }
    }

    private static void MostrarProdutos(Produto[] p){
        for (Produto produto : p) {
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Preço: " + produto.getPreco());
        }
    }

    private static void CalcularMedia(Produto[] p){
        float soma = 0;
        for (Produto produto : p) {
            soma += produto.getPreco();
        }
        System.out.println("\nMédia: " + soma/p.length);
    }
}
