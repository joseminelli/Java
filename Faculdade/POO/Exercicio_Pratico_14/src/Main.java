public class Main {
    public static void main(String[] args){
        Funcionario[] funcionarios = new Funcionario[5];
        SetFuncionarios(funcionarios);
        MostrarSalarioFuncionarios(funcionarios);
        AumentarSalarios(funcionarios);
        System.out.println("\nSalários aumentados em 10%\n");
        MostrarSalarioFuncionarios(funcionarios);
    }

    public static void SetFuncionarios(Funcionario[] funcionarios){
        funcionarios[0] = new Funcionario("João", 1000, "Vendas");
        funcionarios[1] = new Funcionario("Maria", 2000, "RH");
        funcionarios[2] = new Funcionario("José", 3000, "TI");
        funcionarios[3] = new Funcionario("Ana", 4000, "Financeiro");
        funcionarios[4] = new Funcionario("Carlos", 5000, "Diretoria");
    }

    private static void MostrarSalarioFuncionarios(Funcionario[] funcionarios){
        for (Funcionario funcionario : funcionarios) {
            System.out.println("Nome: " + funcionario.getNome() + " - Salário: " + funcionario.getSalario());
        }
    }

    public static void AumentarSalarios(Funcionario[] funcionarios){
        for (Funcionario funcionario : funcionarios) {
            funcionario.setSalario(funcionario.getSalario() * 1.1f);
        }
    }
}
