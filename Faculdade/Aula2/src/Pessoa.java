public class Pessoa {
    String nome;
    int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public void Aniversario() {
        this.idade++;
        System.out.println("Feliz aniversário! Agora o " + this.nome + " tem " + this.idade + " anos.");
    }
}
