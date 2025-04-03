//
// @Autor: José Minelli
// Data: 24/03/2025

import java.util.Scanner;

public class Questao10 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite sue nom:");
        String nome = scanner.nextLine();
        System.out.println("Digite sua altura:");
        float altura = scanner.nextFloat();

        System.out.println("Nome: " + nome);
        System.out.printf("Altura: %.2f metros\n", altura);
    }
}
