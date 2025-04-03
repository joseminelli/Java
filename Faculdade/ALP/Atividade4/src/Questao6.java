//
// @Autor: José Minelli
// Data: 24/03/2025

import java.util.Scanner;

public class Questao6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int distribuidor = 15;
        int impostos = 45;

        System.out.println("Digite o custo de fabrica do carro: ");
        double custoFabrica = scanner.nextDouble();

        double custoConsumidor = custoFabrica + (custoFabrica * distribuidor / 100) + (custoFabrica * impostos / 100);
        System.out.printf("O custo do consumidor é: R$%.2f\n", custoConsumidor);
    }
}
