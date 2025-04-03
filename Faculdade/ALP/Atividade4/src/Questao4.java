//
// @Autor: José Minelli
// Data: 24/03/2025

import java.util.Scanner;

public class Questao4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a quantidade de Graus Celsius: ");
        double celsius = scanner.nextDouble();

        System.out.println("A temperatura em Fahrenheit é: " + (celsius * 9/5 + 32));
    }
}
