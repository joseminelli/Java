import java.util.Scanner;

public class Questao12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("digite um numero inteiro");
        int numero = scanner.nextInt();
        System.out.println("digite um caractere");
        char caractere = scanner.next().charAt(0);
        System.out.println("os valores digitados foram: " + numero + " e " + caractere);
    }
}
