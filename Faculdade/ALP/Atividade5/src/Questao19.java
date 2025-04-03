// @Author: José Minelli
// Date: 31/03/2025
// RA: 12124432

import java.util.Scanner;

public class Questao19 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tipo de combustivel (A - Álcool, G - Gasolina): ");
        char tipo = scanner.next().toUpperCase().charAt(0);

        System.out.println("Digite a quantidade de litros vendidos: ");
        float litros = scanner.nextFloat();
        scanner.close();

        float precoLitro, desconto, valorTotal;

        if (tipo == 'A') {
            precoLitro = 4.60f;
            if (litros <= 20) {
                desconto = 0.03f;
            } else {
                desconto = 0.05f;
            }
        } else if (tipo == 'G') {
            precoLitro = 6.40f;
            if (litros <= 20) {
                desconto = 0.04f;
            } else {
                desconto = 0.06f;
            }
        } else {
            System.out.println("Tipo de combustivel invalido.");
            return;
        }

        valorTotal = litros * precoLitro * (1 - desconto);

        System.out.printf("Valor a ser pago: R$ %.2f%n", valorTotal);
    }
}
