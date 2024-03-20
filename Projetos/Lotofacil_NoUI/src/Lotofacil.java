import java.util.Random;
import java.util.Scanner;

public class Lotofacil {

    public void numericGame() throws Exception {
        Scanner Console = new Scanner(System.in);
        Random random = new Random();
        int aposta = 0, sorteio;
        try {
            System.out.println("\n\nDigite um número de 0 a 100");
            aposta = Console.nextInt();
            if (aposta < 0 || aposta > 100) {
                throw new Exception("Número inválido");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Console.nextLine();
            this.numericGame();
        }
        sorteio = random.nextInt(101);
        if (aposta == sorteio) {
            Color.Green();
            System.out.println("Parabéns! Você acertou!");
            Color.RESET();
        } else {
            Color.Yellow();
            System.out.println("Que pena! Você errou! O número sorteado foi: " + sorteio);
            Color.RESET();
        }
    }

    public void letterGame() throws Exception {
        Scanner Console = new Scanner(System.in);
        char aposta = 'a', sorteio;
        try {
            System.out.println("\n\nDigite uma letra de A a Z");
            aposta = (char) System.in.read();
            Console.nextLine();
            if (!Character.isLetter(aposta)) {
                throw new Exception("Letra inválida");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            this.letterGame();
        }
        aposta = Character.toUpperCase(aposta);
        sorteio = 'J';
        if (aposta == sorteio) {
            Color.Green();
            System.out.println("Parabéns! Você acertou!");
            Color.RESET();
        } else {
            Color.Yellow();
            System.out.println("Que pena! Você errou! A letra sorteada foi: " + sorteio);
            Color.RESET();
        }
    }

    public void parImpar() throws Exception {
        Scanner Console = new Scanner(System.in);
        Random random = new Random();
        int aposta = 0;
        try {
            System.out.println("\n\nDigite um número de 0 a 100");
            aposta = Console.nextInt();
            if (Character.isLetter(aposta)){
                throw new Exception("Número inválido");
            }
        } catch (Exception e) {
            System.err.println(e.getMessage());
            Console.nextLine();
            this.numericGame();
        }

        if (aposta % 2 == 0) {
            Color.Green();
            System.out.println("Parabéns! Você acertou!");
            Color.RESET();
        } else {
            Color.Yellow();
            System.out.println("Que pena! Você errou!");
            Color.RESET();
        }
    }
}
