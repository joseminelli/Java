// @Author: José Minelli
// Date: 31/03/2025
// RA: 12124432

import java.util.Scanner;

public class Questao4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float num1, num2, num3, num4;

        System.out.println("Digite o primeiro numero: ");
        num1 = scanner.nextFloat();

        System.out.println("Digite o segundo numero: ");
        num2 = scanner.nextFloat();

        System.out.println("Digite o terceiro numero: ");
        num3 = scanner.nextFloat();

        // até aqui em ordem crescente

        System.out.println("Digite o quarto numero: ");
        num4 = scanner.nextFloat(); // esse não está em ordem crescente

        if (num4 < num1) {
            System.out.println(num3 + " " + num2 + " " + num1 + " " + num4);
        } else if (num4 < num2) {
            System.out.println(num3 + " " + num2 + " " + num4 + " " + num1);
        } else if (num4 < num3) {
            System.out.println(num3 + " " + num4 + " " + num2 + " " + num1);
        } else {
            System.out.println(num4 + " " + num2 + " " + num3 + " " + num1);
        }

    }
}
