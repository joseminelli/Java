public class Questao8 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("digite um numero inteiro: ");
        int num = scanner.nextInt();
        System.out.println("digite um caractere: ");
        char caractere = scanner.next().charAt(0);
        System.out.println("os valores digitados foram: " + num + " e " + caractere);
    }
}
