public class Ebook extends Livro{
    String formato;
    public Ebook(String titulo, String autor, int anoPublicacao, double preco, String formato) {
        super(titulo, autor, anoPublicacao, preco);
        this.formato = formato;
    }
    public String getFormato() {
        return formato;
    }
    public void setFormato(String formato) {
        this.formato = formato;
    }
}
