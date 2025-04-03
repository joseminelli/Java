// @Author: José Minelli
// Date: 31/03/2025
// RA: 12124432

import java.util.Scanner;

public class Questao13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int A, B, C;

        System.out.println("Digite o primeiro numero: ");
        A = scanner.nextInt();

        System.out.println("Digite o segundo numero: ");
        B = scanner.nextInt();

        if (A == B){
            C = A + B;
        } else{
            C = A * B;
        }

        System.out.println("A = " + A);
        System.out.println("B = " + B);
        System.out.println("C = " + C);


    }
}
