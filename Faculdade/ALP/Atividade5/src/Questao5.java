// @Author: José Minelli
// Date: 31/03/2025
// RA: 12124432

import java.util.Scanner;

public class Questao5 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int senha = 4531, num;

        System.out.println("Digite a senha: ");
        senha = scanner.nextInt();

        if (senha == 4531) {
            System.out.println("Acesso permitido");
        } else {
            System.out.println("Acesso negado");
        }
    }
}
