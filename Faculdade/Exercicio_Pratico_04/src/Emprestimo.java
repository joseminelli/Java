public class Emprestimo {
    protected float taxa;

    public float calcularMulta(int diasAtraso) {
        return diasAtraso * taxa;
    }

    protected Emprestimo(float taxa) {
        this.taxa = taxa;
    }
}
