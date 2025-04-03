public class Main {
    public static void main(String[] args) {
        Aluno[] alunos = new Aluno[5];
        SetAlunos(alunos);
        for(Aluno aluno : alunos){
            System.out.println("Nome: " + aluno.getNome() + " - Nota: " + aluno.getNota());
        }
    }

    private static void SetAlunos(Aluno[] alunos) {
        alunos[0] = new Aluno("João", 10);
        alunos[1] = new Aluno("Maria", 9);
        alunos[2] = new Aluno("José", 8);
        alunos[3] = new Aluno("Ana", 7);
        alunos[4] = new Aluno("Carlos", 6);
    }
}
