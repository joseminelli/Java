public class Produto {
    protected String nome;
    protected double precoUnit;
    protected int qtdEstoque;

    public Produto(String nome, double precoUnit, int qtdEstoque) {
        this.nome = nome;
        this.precoUnit = precoUnit;
        this.qtdEstoque = qtdEstoque;
    }

    public void addEstoque(int qtd) {
        this.qtdEstoque += qtd;
    }
    public void removeEstoque(int qtd) {
        this.qtdEstoque -= qtd;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return this.nome;
    }
    public void setPrecoUnit(double precoUnit) {
        this.precoUnit = precoUnit;
    }
    public double getPrecoUnit() {
        return this.precoUnit;
    }
    public void setQtdEstoque(int qtdEstoque) {
        this.qtdEstoque = qtdEstoque;
    }
    public int getQtdEstoque() {
        return this.qtdEstoque;
    }

}
