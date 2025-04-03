public class TestaCarro{
    public static void Encerrar() {

        System.out.println("Pressione ENTER 2 vezes para encerrar");
        try {
            int read = System.in.read(new byte[1]);
            System.out.println("Encerrando...");
        } catch (Exception e) {
            System.out.println("Erro ao encerrar");
        }
    }
    public static void main(String[] arg){
        Carro c1 = new Carro("Azul", "Mazda", "Miata", 150, 2, 0);
        c1.Specs();
        Encerrar();
    }
}