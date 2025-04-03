// @Autor: José Minelli
// Data: 24/03/2025

import java.util.Scanner;

public class Questao17 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite um numero de 3 digitos: ");
        int num = scanner.nextInt();

        int centena = num / 100;
        int dezena = (num % 100) / 10;
        int unidade = num % 10;

        System.out.printf("O numero invertido é: %d%d%d\n", unidade, dezena, centena);
    }
}
