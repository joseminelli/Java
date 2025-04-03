// @Autor: José Minelli
// Data: 24/03/2025

import java.util.Scanner;

public class Questao20 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float num1, num2, num3;

        System.out.println("Digite a primeira nota: ");
        num1 = scanner.nextFloat();

        System.out.println("Digite a segunda nota: ");
        num2 = scanner.nextFloat();

        System.out.println("Digite a terceira nota: ");
        num3 = scanner.nextFloat();

        System.out.printf("A media das notas é: %.2f\n", (num1 + num2 + num3) / 3);
    }
}
