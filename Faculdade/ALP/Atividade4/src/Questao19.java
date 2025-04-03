// @Autor: José Minelli
// Data: 24/03/2025

import java.util.Scanner;

public class Questao19 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int altura, base;

        System.out.println("Digite a altura do truangulo: ");
        altura = scanner.nextInt();

        System.out.println("Digite a base do truangulo: ");
        base = scanner.nextInt();

        System.out.printf("A area do triangulo é: %.2f\n", (base * altura) / 2.0);
    }
}
