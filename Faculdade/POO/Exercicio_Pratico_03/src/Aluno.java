public class Aluno {
    String nome, matricula;
    int idade;

    public Aluno(String nome, String matricula, int idade) {
        this.nome = nome;
        this.matricula = matricula;
        this.idade = idade;
    }

    public String GetNome() {
        return nome;
    }

    public String GetMatricula() {
        return matricula;
    }

    public int GetIdade() {
        return idade;
    }

    public void SetNome(String nome) {
        this.nome = nome;
    }

    public void SetMatricula(String matricula) {
        this.matricula = matricula;
    }

    public void SetIdade(int idade) {
        this.idade = idade;
    }
}
