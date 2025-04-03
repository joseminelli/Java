// @Author: José Minelli
// Date: 31/03/2025
// RA: 12124432

import java.util.Scanner;

public class Questao6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int num;

        System.out.println("Digite um numero: ");
        num = scanner.nextInt();

        if (num % 2 == 0) {
            System.out.println("O numero é par");
        } else {
            System.out.println("O numero é impar");
        }
    }
}
