//
// @Autor: José Minelli
// Data: 24/03/2025

import java.util.Scanner;

public class Questao5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Digite a capacidade do tanque: ");
        double capacidadeTanque = scanner.nextDouble();

        System.out.println("Digite a quantidade de litros abastecidos: ");
        double litrosAbastecidos = scanner.nextDouble();

        System.out.println("Digite a quilometragem percorrida desde o último abastecimento: ");
        double quilometragemPercorrida = scanner.nextDouble();

        double consumoMedio = quilometragemPercorrida / litrosAbastecidos;
        double autonomia = (capacidadeTanque - litrosAbastecidos) * consumoMedio;

        System.out.println("O consumo médio é: " + consumoMedio);
        System.out.println("A autonomia é: " + autonomia);

    }
}
