public class Principal {

    public static void main(String[] args) {
        Aluno aluno1 = new Aluno("José Minelli", "12124432", 18);
        System.out.println("Nome:" + aluno1.GetNome());
        System.out.println("Matrícula:" + aluno1.GetMatricula());
        System.out.println("Idade:" + aluno1.GetIdade());

        System.out.println("\nAlterando dados do aluno1...\n");

        aluno1.SetNome("Raissa Lauar");
        aluno1.SetMatricula("000000000");
        aluno1.SetIdade(19);

        System.out.println("Nome:" + aluno1.GetNome());
        System.out.println("Matrícula:" + aluno1.GetMatricula());
        System.out.println("Idade:" + aluno1.GetIdade());
    }
}
