public class PacoteSimples extends Pacote{
    private double tarifa = 2;

    public PacoteSimples(double peso) {
        super(peso);
    }


    public double getTarifa() {
        return tarifa;
    }

    public void setTarifa(double tarifa) {
        this.tarifa = tarifa;
    }

    public double calcularCustoEnvio() {
        return getPeso() * tarifa;
    }
}
