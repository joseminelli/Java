public class Funcionario {
    protected String nome;
    protected double salarioHora;
    protected int horasTrabalhadas;

    protected Funcionario(String nome, double salario, int horasTrabalhadas) {
        this.nome = nome;
        this.salarioHora = salario;
        this.horasTrabalhadas = horasTrabalhadas;
    }

    public void setSalario(double salario) {
        this.salarioHora = salario;
    }
    public double getSalario() {
        return salarioHora;
    }

    public void setHorasTrabalhadas(int horasTrabalhadas) {
        this.horasTrabalhadas = horasTrabalhadas;
    }
    public int getHorasTrabalhadas() {
        return horasTrabalhadas;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }

    public void imprimeDados() {
        System.out.println("Nome: " + nome);
        System.out.println("Salário por hora: " + salarioHora);
        System.out.println("Horas trabalhadas: " + horasTrabalhadas);
    }

}
