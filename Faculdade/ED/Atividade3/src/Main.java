// @autor: José Minelli
public class Main {
    public static void main(String[] args) {
        ListaEncadeadaVetor lista = new ListaEncadeadaVetor();

        linhaSeparadora("Lista completa inicial");
        lista.adicionarNoFim(1);
        lista.adicionarNoFim(2);
        lista.adicionarNoFim(4);
        lista.adicionarNoFim(5);
        lista.print();

        linhaSeparadora("Adicionando no início");
        lista.adicionarNoInicio(0);
        lista.print();

        linhaSeparadora("Adicionando 3 na posição 3");
        lista.adicionarNaPosicao(3, 3);
        lista.print();

        linhaSeparadora("Removendo do início");
        lista.removerDoInicio();
        lista.print();

        linhaSeparadora("Removendo do final");
        lista.removerDoFinal();
        lista.print();

        linhaSeparadora("Removendo na posição 2");
        lista.removerNaPosicao(2);
        lista.print();

        linhaSeparadora("Pesquisando número 4 (não existe)");
        lista.pesquisarNumero(4);

        linhaSeparadora("Pesquisando número 2");
        lista.pesquisarNumero(2);

        System.out.println("\nTamanho da lista: " + lista.tamanho());
    }

    public static void linhaSeparadora(String titulo) {
        System.out.println("\n=============================");
        System.out.println(titulo);
        System.out.println("=============================");
    }
}
