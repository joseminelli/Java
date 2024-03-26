public class TestarFuncionario {
    public static void main(String[] args) {
        FuncionarioTerceirizado f1 = new FuncionarioTerceirizado("João", 10, 40, 100);
        FuncionarioRegular f2 = new FuncionarioRegular("Maria", 10, 40);

        System.out.println("Salário de " + f1.getNome() + " é de " + f1.calculaSalario());
        System.out.println("Salário de " + f2.getNome() + " é de " + f2.calculaSalario());

        System.out.println();
        f1.imprimeDados();
        System.out.println();
        f2.imprimeDados();

    }
}
