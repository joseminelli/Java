// @Author: José Minelli
// Date: 31/03/2025
// RA: 12124432

import java.util.Scanner;

public class Questao7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um numero: ");
        int num = scanner.nextInt();
        scanner.close(); // Boa prática fe

        if (num == 2 || num == 3 || num == 5 || num == 7) {
            System.out.println("Numero " + num + " é primo");
        } else if (num <= 1 || num % 2 == 0 || num % 3 == 0 || num % 5 == 0 || num % 7 == 0) {
            System.out.println("Numero " + num + " não é primo");
        } else {
            System.out.println("Numero " + num + " é primo");
        }
    }
}
