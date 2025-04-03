public class Moto extends Veiculo{
    protected boolean partidaEletrica;

    public Moto(String marca, String modelo, int ano, boolean partidaEletrica) {
        super(marca, modelo, ano);
        this.partidaEletrica = partidaEletrica;
    }

    public void setPartidaEletrica(boolean partidaEletrica) {
        this.partidaEletrica = partidaEletrica;
    }

    public boolean getPartidaEletrica() {
        return partidaEletrica;
    }

    public void exibirDados() {
        super.exibirDados();
        System.out.println("Partida elétrica: " + (partidaEletrica ? "Sim" : "Não"));
    }
}
