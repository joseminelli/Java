public class Pessoa {
    String cidade, nome;
    int idade;

    public void Apresentar(){
        System.out.println("Olá, sou o " + nome + ", tenho " + idade + " e moro em " + cidade);
    }

    public Pessoa(int age, String city, String name){
        cidade = city;
        idade = age;
        nome = name;
    }
}
