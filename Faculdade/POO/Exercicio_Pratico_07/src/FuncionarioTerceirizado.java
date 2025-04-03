public class FuncionarioTerceirizado extends Funcionario{

    private double taxaAdicional;

    public FuncionarioTerceirizado(String nome, double salario, int horasTrabalhadas, double taxaAdicional) {
        super(nome, salario, horasTrabalhadas);
        this.taxaAdicional = taxaAdicional;
    }

    public double calculaSalario() {
        return salarioHora * horasTrabalhadas + taxaAdicional;
    }

    public void setTaxaAdicional(double taxaAdicional) {
        this.taxaAdicional = taxaAdicional;
    }
    public double getTaxaAdicional() {
        return taxaAdicional;
    }

    @Override
    public void imprimeDados() {
        super.imprimeDados();
        System.out.println("Taxa adicional: " + taxaAdicional);
    }
}
