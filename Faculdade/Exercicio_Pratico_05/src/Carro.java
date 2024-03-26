public class Carro extends Veiculo{
    protected int numPortas;

    public Carro(String marca, String modelo, int ano, int numPortas) {
        super(marca, modelo, ano);
        this.numPortas = numPortas;
    }

    public void setNumPortas(int numPortas) {
        this.numPortas = numPortas;
    }

    public int getNumPortas() {
        return numPortas;
    }

    public void exibirDados() {
        super.exibirDados();
        System.out.println("Número de portas: " + numPortas);
    }
}
