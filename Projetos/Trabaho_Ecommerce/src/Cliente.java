import java.util.Scanner;

public class Cliente {
    private int id;
    private String nome;
    private String email;
    private Endereco endereco;

    public Cliente(int id, String nome, String email, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.endereco = endereco;
    }

    public void MostrarCliente(){
        Color.Cyan();
        System.out.println("\n### DADOS DO CLIENTE ###");
        Color.RESET();
        System.out.println("Nome: " + this.nome);
        System.out.println("Email: " + this.email);
        System.out.println("Endereço: " + this.endereco.getRua() + ", " + this.endereco.getCidade() + " - " + this.endereco.getCep());
    }

    public void EditarConta(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o novo nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite o novo email do cliente: ");
        String emailCliente = scanner.nextLine();
        System.out.print("Digite a nova rua do endereço do cliente: ");
        String ruaEndereco = scanner.nextLine();
        System.out.print("Digite a nova cidade do endereço do cliente: ");
        String cidadeEndereco = scanner.nextLine();
        System.out.print("Digite o novo CEP do endereço do cliente: ");
        String cepEndereco = scanner.nextLine();
        this.nome = nomeCliente;
        this.email = emailCliente;
        this.endereco.setRua(ruaEndereco);
        this.endereco.setCidade(cidadeEndereco);
        this.endereco.setCep(cepEndereco);
        File file = new File();
        file.WriteJson("src/clientes.json", this);
        Color.Green();
        System.out.println("Conta editada com sucesso!");
        Color.RESET();
    }

    public void VerVendas(){
        Color.Cyan();
        System.out.println("\n### VENDAS DO CLIENTE ###");
        Color.RESET();
        Venda.MostrarVenda();
    }

    public static Cliente CadastrarCliente(){
        File file = new File();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite o nome do cliente: ");
        String nomeCliente = scanner.nextLine();
        System.out.print("Digite o email do cliente: ");
        String emailCliente = scanner.nextLine();
        System.out.print("Digite a rua do endereço do cliente: ");
        String ruaEndereco = scanner.nextLine();
        System.out.print("Digite a cidade do endereço do cliente: ");
        String cidadeEndereco = scanner.nextLine();
        System.out.print("Digite o CEP do endereço do cliente: ");
        String cepEndereco = scanner.nextLine();
        Endereco enderecoCliente = new Endereco(ruaEndereco, cidadeEndereco, cepEndereco);
        file.WriteJson("src/clientes.json", new Cliente(1, nomeCliente, emailCliente, enderecoCliente));
        Color.Green();
        System.out.println("Cliente cadastrado com sucesso!");
        Color.RESET();
        return new Cliente(1, nomeCliente, emailCliente, enderecoCliente);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }
}