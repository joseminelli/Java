//
// @Autor: José Minelli
// Data: 24/03/2025

import java.util.Scanner;

public class Questao11 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        char letra1, letra2, letra3, letra4, letra5;

        System.out.println("Digite a primeira letra: ");
        letra1 = scanner.next().charAt(0);

        System.out.println("Digite a segunda letra: ");
        letra2 = scanner.next().charAt(0);

        System.out.println("Digite a terceira letra: ");
        letra3 = scanner.next().charAt(0);

        System.out.println("Digite a quarta letra: ");
        letra4 = scanner.next().charAt(0);

        System.out.println("Digite a quinta letra: ");
        letra5 = scanner.next().charAt(0);

        System.out.println("As letras digitadas foram: " + letra1 + ", " + letra2 + ", " + letra3 + ", " + letra4 + ", " + letra5);
    }
}
