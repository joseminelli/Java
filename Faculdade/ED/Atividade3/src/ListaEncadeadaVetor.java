public class ListaEncadeadaVetor {
    private int[] elementos;
    private int tamanho;
    private static final int CAPACIDADE_INICIAL = 10;

    public ListaEncadeadaVetor() {
        this.elementos = new int[CAPACIDADE_INICIAL];
        this.tamanho = 0;
    }

    private void garantirCapacidade() {
        if (tamanho == elementos.length) {
            int[] novoArray = new int[elementos.length * 2];
            System.arraycopy(elementos, 0, novoArray, 0, elementos.length);
            elementos = novoArray;
        }
    }

    public void adicionarNoFim(int valor) {
        garantirCapacidade();
        elementos[tamanho] = valor;
        tamanho++;
    }

    public void adicionarNoInicio(int valor) {
        garantirCapacidade();
        System.arraycopy(elementos, 0, elementos, 1, tamanho);
        elementos[0] = valor;
        tamanho++;
    }

    public void adicionarNaPosicao(int valor, int posicao) {
        if (posicao < 0 || posicao > tamanho) {
            System.out.println("Posição invalida");
            return;
        }
        garantirCapacidade();
        System.arraycopy(elementos, posicao, elementos, posicao + 1, tamanho - posicao);
        elementos[posicao] = valor;
        tamanho++;
    }

    public void removerDoInicio() {
        if (tamanho == 0) {
            System.out.println("Lista vazia");
            return;
        }
        System.arraycopy(elementos, 1, elementos, 0, tamanho - 1);
        tamanho--;
    }

    public void removerDoFinal() {
        if (tamanho == 0) {
            System.out.println("Lista vazia");
            return;
        }
        tamanho--;
    }

    public void removerNaPosicao(int posicao) {
        if (posicao < 0 || posicao >= tamanho) {
            System.out.println("Posição invalida");
            return;
        }
        System.arraycopy(elementos, posicao + 1, elementos, posicao, tamanho - posicao - 1);
        tamanho--;
    }

    public void removerElemento(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] == valor) {
                removerNaPosicao(i);
                return;
            }
        }
        System.out.println("Elemento não encontrado");
    }

    public void print() {
        for (int i = 0; i < tamanho; i++) {
            System.out.print(elementos[i] + " -> ");
        }
        System.out.println("null");
    }

    public void pesquisarNumero(int valor) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i] == valor) {
                System.out.println("O numero " + valor + " está na posicao " + i);
                return;
            }
        }
        System.out.println("Elemento não encontrado");
    }

    public int tamanho() {
        return tamanho;
    }
}
