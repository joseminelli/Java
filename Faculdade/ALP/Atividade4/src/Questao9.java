//
// @Autor: José Minelli
// Data: 24/03/2025

import java.util.Scanner;

public class Questao9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite sue nom:");
        String nome = scanner.nextLine();
        System.out.println("Digite sua idade:");
        int idade = scanner.nextInt();

        System.out.println("Nome: " + nome);
        System.out.println("Idade: " + idade);
    }
}
