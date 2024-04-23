import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Jogador> jogadores = new ArrayList<>();
        addJogadores(jogadores);
        ContabilizarVotos(jogadores);
        Jogador maisvotado = GetMaisVotado(jogadores);
        if(!maisvotado.getNome().equals("null")){
        System.out.println("Se eu conseguir mover montanhas, se eu conseguir surfar um tsunami, se eu conseguir\n" +
                "domar o sol, se eu conseguir fazer o mar virar sertão, e o sertão virar mar, se eu\n" +
                "conseguir dizer o que eu nunca vou conseguir dizer, aí terá chegado o dia em que eu\n" +
                "vou conseguir te eliminar com alegria. Com " +maisvotado.getVotos() + " votos, é você quem sai\n" +
                maisvotado.getNome());
        } else {
            System.err.println("Não houve nunhum voto");
        }
    }

    private static Jogador GetMaisVotado(ArrayList<Jogador> jogadores) {
        Jogador maisvotado = new Jogador("null");
        for(Jogador player : jogadores){
            if (player.getVotos() > maisvotado.getVotos()){
                maisvotado = player;
            }
        }
        return maisvotado;
    }

    private static void ContabilizarVotos(ArrayList<Jogador> jogadores) {
        String escolhido = null;
        Scanner sn = new Scanner(System.in);
        do {
            System.out.println("Digite o nome da pessoa escolhida:");
            escolhido = sn.nextLine();
            for(Jogador player : jogadores){
                if(player.getNome().toLowerCase().equals(escolhido.toLowerCase())){
                    player.incrementaUmVoto();
                }
            }
        } while(!escolhido.toLowerCase().equals("sair"));
    }


    public static void addJogadores(ArrayList jogadores){
        jogadores.add(new Jogador("Alane Dias"));
        jogadores.add(new Jogador("Beatriz Reis"));
        jogadores.add(new Jogador("Davi Brito"));
        jogadores.add(new Jogador("Deniziane Ferreira"));
        jogadores.add(new Jogador("Fernanda Bande"));
        jogadores.add(new Jogador("Giovanna Lima"));
        jogadores.add(new Jogador("Giovanna Pitel"));
        jogadores.add(new Jogador("sabelle Nogueira"));
        jogadores.add(new Jogador("Juninho"));
        jogadores.add(new Jogador("Leidy Elin"));
        jogadores.add(new Jogador("Lucas Henrique"));
        jogadores.add(new Jogador("Lucas Luigi"));
        jogadores.add(new Jogador("Lucas Pizane"));
        jogadores.add(new Jogador("Marcus Vinicius"));
        jogadores.add(new Jogador("Matteus Amaral"));
        jogadores.add(new Jogador("Maycon Cosmer"));
        jogadores.add(new Jogador("MC Bin Laden"));
        jogadores.add(new Jogador("Michel Nogueira"));
        jogadores.add(new Jogador("Raquele Cardozo"));
        jogadores.add(new Jogador("Rodriguinho"));
        jogadores.add(new Jogador("Thalyta Alves"));
        jogadores.add(new Jogador("Vanessa Lopes"));
        jogadores.add(new Jogador("Vinicius Rodrigues"));
        jogadores.add(new Jogador("Wanessa Camargo"));
        jogadores.add(new Jogador("Yasmin Brunet"));
    }
}
