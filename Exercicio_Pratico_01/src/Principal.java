public class Principal {
    public static void main(String[] arg) {
        Pessoa pessoa1 = new Pessoa(18, "Belo Horizonte", "José Minelli");
        Pessoa pessoa2 = new Pessoa(18, "Londres", "Charles");

        pessoa2.Apresentar();
        pessoa1.Apresentar();

        // TESTE CONTA BANCARIA
        /*
        ContaBancaria conta = new ContaBancaria(1234, "José Minelli");
        conta.ExibirSaldo();
        conta.Depositar(100);

        //Para testar depósito negativo e saque insuficiente (comente o outro deposito acima)
        //conta.Depositar(-4);

        conta.ExibirSaldo();
        conta.Sacar(50);
        conta.ExibirSaldo();
        */

        //TESTE CIRCULO
        /*
        Circulo circulo = new Circulo(5);
        circulo.CalcularArea();
        circulo.CalcularPerimetro();
         */
    }
}