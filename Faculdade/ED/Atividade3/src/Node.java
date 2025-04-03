// @autor: José Minelli

public class Node {
    private int valor;
    private Node proximo;

    public Node(int value) {
        this.valor = value;
        this.proximo = null;
    }

    public int valor() {
        return this.valor;
    }

    public Node proximo() {
        return this.proximo;
    }

    public void setProximo(Node next) {
        this.proximo = next;
    }
}
