public class Principal {
    public static void main(String[] args){
        Pessoa p1 = new Pessoa("José", 18);

        System.out.println("Nome: " + p1.nome + "\n" + "Idade: " + p1.idade + " anos");

        p1.Aniversario();
    }
}
