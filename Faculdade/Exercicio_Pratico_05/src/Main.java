public class Main {
    public static void main(String[] args) {
        Carro carro = new Carro("Ford", "Mustang", 2018, 2);
        carro.exibirDados();
        System.out.println();
        carro.setNumPortas(4);
        carro.exibirDados();
        System.out.println();

        Moto moto = new Moto("Honda", "CG 125", 2015, true);
        moto.exibirDados();
    }
}
