import java.sql.SQLOutput;
import java.util.Scanner;

public class CadastroAlunos {

    public static void main(String[] args){
        Aluno[] alunos = new Aluno[5];

        for(int i = 0; i < alunos.length; i++){
            alunos[i] = new Aluno();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Digite o nome do aluno: ");
            alunos[i].nome = scanner.nextLine();
            System.out.println("Digite a idade do aluno: ");
            alunos[i].idade = scanner.nextInt();
        }


        System.out.println("\nAlunos cadastrados: ");
        for (Aluno aluno : alunos) {
            System.out.println("Nome: " + aluno.nome + " - Idade: " + aluno.idade);

        }
    }
}
