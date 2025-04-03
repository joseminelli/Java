//
// @Autor: José Minelli
// Data: 24/03/2025

import java.util.Scanner;

public class Questao2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o preco do produto: ");
        double preco = scanner.nextDouble();

        System.out.println("Digite a quantidade de produtos: ");
        int quantidade = scanner.nextInt();

        System.out.println("O valor total é: " + preco*quantidade);
    }
}
