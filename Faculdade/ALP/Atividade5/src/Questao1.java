// @Author: José Minelli
// Date: 31/03/2025
// RA: 12124432

import java.util.Scanner;

public class Questao1 {
    public static void main(String[] args) {
        float nota1, nota2, nota3, mediaA;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a primeira nota: ");
        nota1 = scanner.nextFloat();

        System.out.println("Digite a segunda nota: ");
        nota2 = scanner.nextFloat();

        System.out.println("Digite a terceira nota: ");
        nota3 = scanner.nextFloat();

        mediaA = (nota1 + nota2 + nota3) / 3;

        System.out.println("A media é: " + mediaA);

        if (mediaA >= 6) {
            System.out.println("Aprovado");
        } else if (mediaA >= 3) {
            System.out.println("Exame");
        } else {
            System.out.println("Reprovado");
        }
    }


}
