//
// @Autor: José Minelli
// Data: 24/03/2025

import java.util.Scanner;

public class Questao13 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int num1, num2, num3, num4, num5;

        System.out.println("Digite o primeiro número: ");
        num1 = scanner.nextInt();

        System.out.println("Digite o segundo número: ");
        num2 = scanner.nextInt();

        System.out.println("Digite o terceiro número: ");
        num3 = scanner.nextInt();

        System.out.println("Digite o quarto número: ");
        num4 = scanner.nextInt();

        System.out.println("Digite o quinto número: ");
        num5 = scanner.nextInt();

        System.out.println("A soma dos números é: " + (num1 + num2 + num3 + num4 + num5));
        System.out.println("A média dos números é: " + ((num1 + num2 + num3 + num4 + num5) / 5));
    }
}
