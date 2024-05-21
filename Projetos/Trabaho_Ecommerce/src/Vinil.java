public class Vinil extends Produto{
    private String artista;
    private final String categoria = "Vinil";

    public Vinil(int id, String nome, double preco, int quantidade, String artista) {
        super(id, nome, preco, quantidade);
        this.artista = artista;
    }

    public String getArtista() {
        return artista;
    }

    public void setArtista(String artista) {
        this.artista = artista;
    }

    public String getCategoria() {
        return categoria;
    }

}
