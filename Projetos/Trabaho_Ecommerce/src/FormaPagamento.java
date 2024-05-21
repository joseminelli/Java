// Classe FormaPagamento
public class FormaPagamento {
    private String nome;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCartaoCredito() {
        this.nome = "Cartão de Crédito";
    }

    public void setBoleto() {
        this.nome = "Boleto";
    }

    public void setPix() {
        this.nome = "Pix";
    }
}