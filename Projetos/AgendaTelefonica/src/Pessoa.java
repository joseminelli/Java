public class Pessoa {

    private final String nome;
    private final int idade;
    private final String tel;

    public Pessoa(String nome, int idade, String tel) {
        this.nome = nome;
        this.idade = idade;
        this.tel = tel;
    }

    public void Apresentar() {
        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
        System.out.println("Telefone: " + tel);
    }

    public int getIdade() {
        return idade;
    }

    public String getNome() {
        return nome;
    }

    public String getTel() {
        return tel;
    }
}
