public class Funcionario {
    private String nome;
    private float salario;
    private String departamento;

    Funcionario(String nome, float salario, String departamento){
        this.nome = nome;
        this.salario = salario;
        this.departamento = departamento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public float getSalario() {
        return salario;
    }

    public void setSalario(float preco) {
        this.salario = preco;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }
}
