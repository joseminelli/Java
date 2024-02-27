public class ContaBancaria {
    int numero;
    float saldo = 0;
    String nome;

    public void Depositar(int valor){
        if (valor > 0) {
            saldo += valor;
            return;
        }
        System.out.println("Valor inválido | [" + valor +"]");
    }

    public void Sacar(float valor){
        float valorFinal = saldo - valor;
        if (valorFinal < 0) {
            System.out.println("Valor insuficiente");
            return;
        }
        saldo -= valor;
    }

    public void ExibirSaldo(){
        System.out.println("Seu saldo atual é: " + saldo);
    }

    public ContaBancaria(int num, String name){
        numero = num;
        nome = name;
    }
}
