import java.util.Scanner;

public class CadastroVetor {
    public static void main(String[] args) {
        final int totAlunos = 5;
        Aluno[] alunos = new Aluno[totAlunos];
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < alunos.length; i++) {
            alunos[i] = new Aluno();
            System.out.println("Digite o nome do aluno " + (i + 1) + ":");
            alunos[i].setNome(scanner.nextLine());
            System.out.println("Digite a nota do(a) " + alunos[i].getNome() + ":");
            alunos[i].setNota(scanner.nextInt());

            scanner.nextLine();
        }

        for (Aluno aluno : alunos) {
            System.out.println("Nome: " + aluno.getNome() + " - Nota: " + aluno.getNota());
        }
    }
}
