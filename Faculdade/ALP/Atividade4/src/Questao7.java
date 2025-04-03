//
// @Autor: José Minelli
// Data: 24/03/2025

import java.util.Scanner;

public class Questao7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int custoLata = 50;
        int LitroPorLata = 5;
        int MQuadradoPorLata = 3;

        int Area = 60;

        int qtdLatas = Area / MQuadradoPorLata;
        int custoTotal = qtdLatas * custoLata;

        System.out.printf("A quantidade de latas necessarias é: %d\n", qtdLatas);
        System.out.printf("O custo total é: R$%d\n", custoTotal);
    }
}
