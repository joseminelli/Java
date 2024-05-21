public class Blusa extends Produto{
    private final String categoria = "Blusa";
    private String cor;

    public Blusa(int id, String nome, double preco, int quantidade, String cor) {
        super(id, nome, preco, quantidade);
        this.cor = cor;
    }

    public String getTamanho() {
        return categoria;
    }


    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }
}
