abstract class Pacote {
    private double peso;

    public Pacote(double peso) {
        this.peso = peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }
    public double getPeso() {
        return peso;
    }

    public abstract double calcularCustoEnvio();

}
