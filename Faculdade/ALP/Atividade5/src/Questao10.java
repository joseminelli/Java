// @Author: José Minelli
// Date: 31/03/2025
// RA: 12124432

import java.util.Scanner;

public class Questao10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float preco = 0f, desconto = 0, valorFinal;

        System.out.println("Digite um código (1 a 40): ");
        int cod = scanner.nextInt();

        System.out.println("Digite a quantiade: ");
        int quant = scanner.nextInt();

        if (cod >= 1 && cod <= 10) {
            preco = 10.0f;
        } else if (cod >= 11 && cod <= 20) {
            preco = 15.0f;
        } else if (cod >= 21 && cod <= 30) {
            preco = 20.0f;
        } else if (cod >= 31 && cod <= 40) {
            preco = 30.0f;
        }

        float tot = preco * quant;

        if (tot < 250f) {
            desconto = 5;
        } else if (tot >= 250f && tot <= 500f) {
            desconto = 10;
        } else if (tot > 500f ) {
            desconto = 15;
        }

        valorFinal = tot - (tot * desconto / 100);

        System.out.println("Valor unitario: " + preco);
        System.out.println("Valor total: " + tot);
        System.out.println("Desconto: " + desconto + "%");
        System.out.println("Valor final: " + valorFinal);
        scanner.close();


    }
}
