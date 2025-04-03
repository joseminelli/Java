// @Author: José Minelli
// Date: 31/03/2025
// RA: 12124432

import java.util.Scanner;

public class Questao2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float num1, num2;

        System.out.println("Digite o primeiro numero: ");
        num1 = scanner.nextFloat();

        System.out.println("Digite o segundo numero: ");
        num2 = scanner.nextFloat();

        if (num1 > num2) {
            System.out.println("O primeiro numero é maior");
        } else if (num2 > num1) {
            System.out.println("O segundo numero é maior");
        } else {
            System.out.println("Os numero são iguais");
        }
    }
}
