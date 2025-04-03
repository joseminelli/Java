//
// @Autor: José Minelli
// Data: 24/03/2025

import java.util.Scanner;

public class Questao3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite o tamanho da base maior");
        double baseMaior = scanner.nextDouble();

        System.out.println("Digite o tamanho da base menor");
        double baseMenor = scanner.nextDouble();

        System.out.println("Digite a altura");
        double altura = scanner.nextDouble();

        System.out.println("A area do trapézio e: " + ((baseMaior + baseMenor) * altura) / 2);
    }
}
