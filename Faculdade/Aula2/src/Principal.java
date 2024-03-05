public class Principal {
    public static void main(String[] args){

        Livro l1 = new Livro("Refúgio", "Harlan Coben");

        Pessoa p1 = new Pessoa("José", 18, l1);

        System.out.println("Nome: " + p1.nome + "\n" + "Idade: " + p1.idade + " anos");

        p1.Aniversario();

        p1.GetLivroFavorito();

    }
}
