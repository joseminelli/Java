// @Author: José Minelli
// Date: 31/03/2025
// RA: 12124432

import java.util.Scanner;

public class Questao16 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int deposito, taxa;
        System.out.println("Digite o valor do deposito: ");
        deposito = scanner.nextInt();

        System.out.println("Digite o valor da taxa: ");
        taxa = scanner.nextInt();
        scanner.close();

        if (taxa < 0) {
            System.out.println("Taxa inválida");
        } else {
            double rendimento = deposito * taxa / 100.0;
            System.out.println("O rendimento no 1° mes é: " + rendimento);
            double rendimento2 = (deposito + rendimento) * taxa / 100.0;
            System.out.println("O rendimento no 2° mes é: " + rendimento2);
            double rendimento3 = (deposito + rendimento + rendimento2) * taxa / 100.0;
            System.out.println("O rendimento no 3° mes é: " + rendimento3);
        }

    }
}
