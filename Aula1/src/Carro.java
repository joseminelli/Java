public class Carro {
    String cor,  marca, modelo;
    int tamanho, quantPortas, velocidade;

    void Acelerear(int valor){
        velocidade += valor;

        System.out.println("Velociade ajustada para " + velocidade);
    }

    void Reduzir(int valor){
        int velFinal = velocidade -= valor;
        if(velFinal < 0){
            velocidade -=velFinal;
            System.out.println("Velociade insuficiente");
            return;
        }
        System.out.println("Velociade ajustada para " + velocidade);
    }

    public Carro(String c, String marc, String model, int t, int qtd, int vel){
        cor = c;
        marca = marc;
        modelo = model;
        tamanho = t;
        quantPortas = qtd;
        velocidade = vel;
    }


    public void Specs(){
        System.out.println("==== " + marca + " " + modelo + " ====");
        System.out.println("Cor: " + cor + "\n" + "Tamanho: " + tamanho + "\n" + "Quantidade de portas: " + quantPortas + "\n" +"Velocidade máxima: " + velocidade + "\n");
    }
    void Buzinar(int quantidade){
        for(int i = 0; i < quantidade; i++){
            System.out.print("Fom ");
        }
    }
}
