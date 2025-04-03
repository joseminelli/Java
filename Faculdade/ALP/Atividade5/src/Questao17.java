// @Author: José Minelli
// Date: 31/03/2025
// RA: 12124432

import java.util.Scanner;

public class Questao17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        float inss;
        System.out.println("Digite o salario: ");
        float salario = scanner.nextFloat();
        scanner.close();

        if (salario < 1100) {
            inss = 7.5f;
        } else if (salario >= 1100.1f && salario <= 2203.48f) {
            inss = 9f;
        } else if (salario >= 2203.49f && salario <= 3305.22f) {
            inss = 12.0f;
        } else if (salario >= 3305.23f && salario <= 6433.5f) {
            inss = 14.0f;
        } else {
            inss = 14.0f;
        }

        System.out.println("INSS: " + inss + "%");
        System.out.println("Desconto: " + (salario * inss / 100));
        System.out.println("Salario liquido: " + (salario - (salario * inss / 100)));
        System.out.println("Salario bruto: " + salario);
    }
}
