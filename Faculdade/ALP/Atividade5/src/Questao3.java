// @Author: José Minelli
// Date: 31/03/2025
// RA: 1212443290

import java.util.Scanner;

public class Questao3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        float num1, num2, num3;

        System.out.println("Digite o primeiro numero: ");
        num1 = scanner.nextFloat();

        System.out.println("Digite o segundo numero: ");
        num2 = scanner.nextFloat();

        System.out.println("Digite o terceiro numero: ");
        num3 = scanner.nextFloat();

        if (num1 < num2 && num1 < num3) {
            if (num2 < num3) {
                System.out.println(num1 + " " + num2 + " " + num3);
            } else {
                System.out.println(num1 + " " + num3 + " " + num2);
            }
        } else if (num2 < num1 && num2 < num3) {
            if (num1 < num3) {
                System.out.println(num2 + " " + num1 + " " + num3);
            } else {
                System.out.println(num2 + " " + num3 + " " + num1);
            }
        } else {
            if (num1 < num2) {
                System.out.println(num3 + " " + num1 + " " + num2);
            } else {
                System.out.println(num3 + " " + num2 + " " + num1);
            }
        }
    }
}
