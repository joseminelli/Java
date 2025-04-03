public class Aluno {
    String nome;
    int matricula;
    double nota_mat;
    double nota_por;
    double nota_fis;
    double nota_quim;
    double nota_geo;

    Disciplina disciplina;

    public Aluno(String n, int m, double nt_m, double nt_p, double nt_f, double nt_q, double nt_g, Disciplina d){
        nome = n;
        matricula = m;
        nota_mat = nt_m;
        nota_por = nt_p;
        nota_fis = nt_f;
        nota_quim = nt_q;
        nota_geo = nt_g;
        disciplina = d;
    }

    public double CaucularMedia(){
        return (nota_mat + nota_por + nota_fis + nota_quim + nota_geo) / 5;
    }

    public void SituacaoAluno(){
        double media = this.CaucularMedia();
        if(media >= 6){
           System.out.println("O aluno " + this.nome + " foi APROVADO");
        } else {
            System.out.println("O aluno " + this.nome + " foi REPROVADO");
        }

    }
    public void Apresentar(){
        System.out.println("Sou o " + this.nome + ", de metrícula " + this.matricula + " e faço " + this.disciplina.nome);
    }
}
