public class PacoteExpresso extends Pacote{
    private double tarifa = 3.5;

    public PacoteExpresso(double peso) {
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
