public class Pessoa {
    String nome;
    int idade;

    Livro livroFavorito;

    public Pessoa(String nome, int idade, Livro livroFavorito) {
        this.nome = nome;
        this.idade = idade;
        this.livroFavorito = livroFavorito;
    }

    public void Aniversario() {
        this.idade++;
        System.out.println("Feliz aniversário! Agora o " + this.nome + " tem " + this.idade + " anos.");
    }

    public void GetLivroFavorito() {
        System.out.println("Livro favorito: " + this.livroFavorito.titulo + " de " + this.livroFavorito.autor);
    }
}
