//
// @Autor: José Minelli
// Data: 24/03/2025

import java.util.Scanner;

public class Questao1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um numero inteiro: ");
        int num = scanner.nextInt();

        System.out.println("O quadrado dele é: " + num*num);
    }
}