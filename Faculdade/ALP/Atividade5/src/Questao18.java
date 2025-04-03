// @Author: José Minelli
// Date: 31/03/2025
// RA: 12124432

import java.util.Scanner;

public class Questao18 {
    public static void main(String[] args) {
        // calculo de imc

        float peso, altura, imc;
        String classificacao;

        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite seu peso: ");
        peso = scanner.nextFloat();

        System.out.println("Digite sua altura: ");
        altura = scanner.nextFloat();

        imc = peso / (altura * altura);
        System.out.println("Seu IMC é: " + imc);


        if ( imc < 20) {
            classificacao = "Abaixo do peso";
        } else if (imc >= 20 && imc < 24.9) {
            classificacao = "Peso normal";
        } else if (imc >= 25 && imc < 29.9) {
            classificacao = "Sobrepeso";
        } else if (imc >= 30 && imc < 34.9) {
            classificacao = "Obesidade";
        } else if (imc > 35) {
            classificacao = "Obesidade mórbida";
        }
    }
}
