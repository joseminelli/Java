// @Author: José Minelli
// Date: 31/03/2025
// RA: 12124432


import java.util.Scanner;

public class Questao8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um numero: ");
        int num = scanner.nextInt();
        scanner.close();

        if (num >= 0) {
            System.out.println("O numero " + num + " é positivo");
        } else {
            System.out.println("O numero " + num + " é negativo");
        }
    }
}