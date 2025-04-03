// @Autor: José Minelli
// Data: 24/03/2025

import java.util.Scanner;

public class Questao15 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int num1, num2, num3;

        System.out.println("Digite o primeiro numero: ");
        num1 = scanner.nextInt();

        System.out.println("\nDigite o segundo numero: ");
        num2 = scanner.nextInt();

        System.out.println("\nDigite o terceiro numero: ");
        num3 = scanner.nextInt();

        System.out.printf("\nA soma dos numeros é: %d\n", num1 + num2 + num3);
        System.out.printf("\nO produto dos numeros é: %d", num1 * num2 * num3);

    }
}
