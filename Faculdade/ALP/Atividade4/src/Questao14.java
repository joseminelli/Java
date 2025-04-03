//
// @Autor: José Minelli
// Data: 24/03/2025

import java.util.Scanner;

public class Questao14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char letra1, letra2;

        System.out.println("Digite a primeira letra: ");
        letra1 = scanner.next().charAt(0);

        System.out.println("Digite a segunda letra: ");
        letra2 = scanner.next().charAt(0);

        System.out.printf("As letras digitadas foram: %c%c%c%c%c\n", letra1, letra2, letra1, letra2, letra1);
    }
}
