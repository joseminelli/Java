import java.util.Random;

public class Questao2 {
    public static void main(String[] args){
        int length = 100;

        int[] vector = new int[length];
        int[] smallVector = new int[length / 2];

        Random random = new Random();

        int lower = Integer.MAX_VALUE;
        int lowerPos = 0;
        int sum = 0;

        for (int i = 0; i < vector.length; i++) {
            vector[i] = random.nextInt(100);
        }

        for (int i = 0; i < vector.length; i++) {

            //menor num
            if (vector[i] < lower) {
                lower = vector[i];
                lowerPos = i;
            }

            //soma
            sum += vector[i];

            // soma da posicao oposta
            if (i < length / 2) {
                smallVector[i] = vector[i] + vector[length - i - 1];
            }

        }

        System.out.println("Menor numero: " + lower);
        System.out.println("Posição do menor numero: " + lowerPos);
        System.out.println("aoma de todos os numero: " + sum);
        System.out.println("Vetor com a soma dos numero nas posições opostas: ");
        for (int j : smallVector) {
            System.out.print(j + " ");
        }
    }
}
