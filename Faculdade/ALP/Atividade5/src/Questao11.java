// @Author: José Minelli
// Date: 31/03/2025
// RA: 12124432

import java.util.Scanner;

public class Questao11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o salario: ");
        float num = scanner.nextFloat();
        int reajuste = 0;
        scanner.close();

        if (num < 500) {
            reajuste = 15;
        } else if (num >= 500 && num <= 1000) {
            reajuste = 10;
        } else if (num > 1000) {
            reajuste = 5;
        }

        System.out.println("Reajuste: " + reajuste + "%");
        System.out.println("Novo salario: " + (num + (num * reajuste / 100)));
    }
}
