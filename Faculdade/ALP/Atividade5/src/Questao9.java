// @Author: José Minelli
// Date: 31/03/2025
// RA: 12124432


import java.util.Scanner;

public class Questao9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um numero: ");
        int num = scanner.nextInt();
        scanner.close();

        if (num >= 5 && num <= 7) {
            System.out.println("Categoria infantil");
        } else if (num >= 8 && num <= 10) {
            System.out.println("Categoria juvenil");
        } else if (num >= 11 && num <= 15) {
            System.out.println("Categoria adolescente");
        } else if (num >= 16 && num <= 30) {
            System.out.println("Categoria adulto");
        } else if (num > 30) {
            System.out.println("Categoria Sênior");
        }
    }
}
