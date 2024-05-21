public class Produto {
    private String nome;
    private double precoUnitario;

    public Produto(String nome, double precoUnitario) {
        this.nome = nome;
        this.precoUnitario = precoUnitario;
    }

    // Método para calcular o preço total para uma única unidade
    public double calcularPrecoTotal() {
        return precoUnitario;
    }

    // Método sobrecarregado para calcular o preço total para várias unidades
    public double calcularPrecoTotal(int quantidade) {
        return precoUnitario * quantidade;
    }
}
