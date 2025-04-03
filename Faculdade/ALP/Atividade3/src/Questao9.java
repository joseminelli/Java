public class Questao9 {
    public static void main(String[] args) {
        java.util.Scanner scanner = new java.util.Scanner(System.in);
        System.out.println("digite um numero: ");
        boolean bool1 = scanner.nextBoolean();
        System.out.println("digite outro numero: ");
        boolean bool2 = scanner.nextBoolean();

        if (bool1 && bool2) {
            System.out.println("o resultado deu: "+bool1);
        } else {
            System.out.println("o resultado deu: "+false);
        }
    }
}
