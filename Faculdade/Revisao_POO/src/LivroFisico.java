public class LivroFisico extends Livro{
    double peso;
    public LivroFisico(String titulo, String autor, int anoPublicacao, double preco, double peso) {
        super(titulo, autor, anoPublicacao, preco);
        this.peso = peso;
    }
    public double getPeso() {
        return peso;
    }
    public void setPeso(double peso) {
        this.peso = peso;
    }
}
