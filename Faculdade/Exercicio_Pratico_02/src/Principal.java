public class Principal {
    public static void main(String[] args){
        Disciplina d1 = new Disciplina("Orientação a objeto", 80);
        Aluno a1 = new Aluno("José Minelli", 12124432, 6,4,8,6,7, d1 );

        a1.Apresentar();

        double media = a1.CaucularMedia();

        System.out.println("A media do aluno " +a1.nome + " foi "+media);

        a1.SituacaoAluno();
    }
}