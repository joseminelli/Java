// @autor: José Minelli

public class ListaEncadeada {
    private Node primeiro;
    private Node ultimo;
    private int tamanho;

    public ListaEncadeada() {
        this.primeiro = null;
        this.ultimo = null;
        this.tamanho = 0;
    }

    public void adicionarNoFim(int valor) {
        Node novoNo = new Node(valor);
        if (this.primeiro == null) {
            this.primeiro = novoNo;
            this.ultimo = novoNo;
        } else {
            this.ultimo.setProximo(novoNo);
            this.ultimo = novoNo;
        }
        this.tamanho++;
    }

    public void adicionarNoInicio(int valor) {
        Node novoNo = new Node(valor);
        if (this.primeiro == null) {
            this.primeiro = novoNo;
            this.ultimo = novoNo;
        } else {
            novoNo.setProximo(this.primeiro);
            this.primeiro = novoNo;
        }
        this.tamanho++;
    }

    // a posicao leva em consideração que a primeira posição é 0
    public void adicionarNaPosicao(int valor, int posicao) {
        try {
            if (posicao == 0) {
                adicionarNoInicio(valor);
            } else if (posicao == this.tamanho) {
                adicionarNoFim(valor);
            } else {
                Node novoNo = new Node(valor);
                Node atual = this.primeiro;
                for (int i = 0; i < posicao - 1; i++) {
                    atual = atual.proximo();
                }
                novoNo.setProximo(atual.proximo());
                atual.setProximo(novoNo);
                this.tamanho++;
            }
        } catch (NullPointerException e) {
            System.out.println("Posição inválida");
        }
    }

    public void removerDoInicio() {
        if (this.primeiro == null) {
            System.out.println("Lista vazia");
            return;
        }
        this.primeiro = this.primeiro.proximo();
        this.tamanho--;
    }

    public void removerDoFinal() {
        if (this.primeiro == null) {
            System.out.println("Lista vazia");
            return;
        }
        Node atual = this.primeiro;
        while (atual.proximo() != this.ultimo) {
            atual = atual.proximo();
        }
        atual.setProximo(null);
        this.ultimo = atual;
        this.tamanho--;

    }

    // a posicao leva em consideração que a primeira posição é 0
    public void removerNaPosicao(int posicao) {
        try {
            if (posicao == 0) {
                removerDoInicio();
            } else if (posicao == this.tamanho - 1) {
                removerDoFinal();
            } else {
                Node atual = this.primeiro;
                for (int i = 0; i < posicao - 1; i++) {
                    atual = atual.proximo();
                }
                atual.setProximo(atual.proximo().proximo());
                this.tamanho--;
            }
        } catch (NullPointerException e) {
            System.out.println("Posição inválida");
        }
    }

    public void removerElemento(int valor) {
        Node atual = this.primeiro;
        Node anterior = null;
        while (atual != null) {
            if (atual.valor() == valor) {
                if (anterior == null) {
                    this.primeiro = atual.proximo();
                } else {
                    anterior.setProximo(atual.proximo());
                }
                this.tamanho--;
                return;
            }
            anterior = atual;
            atual = atual.proximo();
        }
        System.out.println("Elemento não encontrado");
    }

    public void print() {
        Node atual = this.primeiro;
        while (atual != null) {
            System.out.print(atual.valor() + " -> ");
            atual = atual.proximo();

        }
        System.out.println("null");
        System.out.println("");
    }

    public void pesquisarNumero(int valor) {
        Node atual = this.primeiro;
        int posicao = 0;
        while (atual != null) {
            if (atual.valor() == valor) {
                System.out.println("O número " + valor + " está na posição " + posicao);
                return;
            }
            atual = atual.proximo();
            posicao++;
        }
        System.out.println("Elemento não encontrado");
    }

    public int tamanho() {
        return this.tamanho;
    }
}

