public class Material {
    String titulo;
    int ano;
    Emprestimo emprestimo;

    protected Material(String titulo, int ano) {
        this.titulo = titulo;
        this.ano = ano;
    }

    public void setEmprestimo(Emprestimo emprestimo){
        this.emprestimo = emprestimo;
    }

    public void getMulta(int dias){
        System.out.println("O material '"+ this.titulo+"'" +" teve a multa de " + emprestimo.calcularMulta(dias));
    }
}
