// @Author: José Minelli
// Date: 31/03/2025
// RA: 12124432

import java.util.Scanner;

public class Questao12 {
    public static void main(String[] args) {
        // Classe eleitoral
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite sua idade: ");
        int idade = scanner.nextInt();
        scanner.close();

        if (idade < 16) {
            System.out.println("não eleitor");
        } else if (idade < 18 || idade > 65) {
            System.out.println("eleitor facultativo");
        } else {
            System.out.println("eleitor obrigatorio");
        }
    }
}
