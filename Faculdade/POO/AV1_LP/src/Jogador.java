public class Jogador {
    protected String nome;
    protected int votos = 0;

    public int getVotos() {
        return votos;
    }

    public Jogador(String nome){
        this.nome = nome;
    }

    public void setVotos(int votos) {
        this.votos = votos;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public void incrementaUmVoto() {
        this.votos = getVotos() + 1;
    }

}
