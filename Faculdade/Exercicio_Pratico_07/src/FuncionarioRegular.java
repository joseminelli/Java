public class FuncionarioRegular extends Funcionario{
    public FuncionarioRegular(String nome, double salario, int horasTrabalhadas) {
        super(nome, salario, horasTrabalhadas);
    }

    public double calculaSalario() {
        return salarioHora * horasTrabalhadas;
    }
}
