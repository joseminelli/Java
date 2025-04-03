public class TesteFuncionario {
    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("João", 25, 2000);
        Gerente g1 = new Gerente("José", 35, 3000, "TI");

        f1.info();
        System.out.println("\nAlterando salário de João para 5000");
        f1.info();
        f1.setNome("Maria");
        f1.setIdade(30);
        System.out.println("\nAlterando nome de João para 'Maria' e a idade para 30");
        f1.info();
        g1.info();

    }
}
