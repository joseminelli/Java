//
// @Autor: José Minelli
// Data: 24/03/2025

import java.util.Scanner;

public class Questao8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int acrescimo = 15;
        int desconto = 15;

        System.out.println("Digite o valor do produto: ");
        double valorProduto = scanner.nextDouble();

        double valorAcrescimo = valorProduto + (valorProduto * acrescimo / 100);
        double valorDesconto = valorAcrescimo - (valorAcrescimo * desconto / 100);

        System.out.printf("O valor final a pagar é: R$%.2f\n", valorDesconto);
        System.out.printf("O prejuízo do comerciante é: R$%.2f\n", valorProduto - valorDesconto);

    }
}
