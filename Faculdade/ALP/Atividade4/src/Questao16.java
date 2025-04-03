// @Autor: José Minelli
// Data: 24/03/2025

import java.util.Scanner;

public class Questao16 {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        int num1, num2;

        System.out.println("Digite o primeiro numero: ");
        num1 = scanner.nextInt();

        System.out.println("\nDigite o segundo numero: ");
        num2 = scanner.nextInt();

        System.out.println("Os numeros informados foram: " + num1 + " e " + num2 + ". E o resto é " + num1 % num2);
    }
}
