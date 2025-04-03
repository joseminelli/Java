import java.util.Scanner;

public class Biblioteca {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        Livro[] livros = new Livro[40];
        AddDefaultBooks(livros);
        int opcao;

        do{
            ExibirMenu();
            opcao = scanner.nextInt();
            scanner.nextLine();
            switch (opcao) {
                case 1:
                    AddLivro(livros);
                    Encerrar();
                    break;
                case 2:
                    ListarLivros(livros, false);
                    Encerrar();
                    break;
                case 3:
                    ListarLivros(livros, true);
                    Encerrar();
                    break;
                case 4:
                    EmprestarLivro(livros);
                    Encerrar();
                    break;
                case 5:
                    DevolverLivro(livros);
                    Encerrar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;
            }
        } while (opcao != 0);
    }

    private static void ExibirMenu(){
        System.out.println("=========== Biblioteca ===========");
        System.out.println("1 - Adicionar livro");
        System.out.println("2 - Listar livros");
        System.out.println("3 - Listar livros disponíveis");
        System.out.println("4 - Emprestar livro");
        System.out.println("5 - Devolver livro");
        System.out.println("0 - Sair");
    }

    private static void AddLivro(Livro[] livros){
        Scanner scanner = new Scanner(System.in);
        for (int i = 0; i < livros.length; i++) {
            if (livros[i] == null) {
                System.out.println("Digite o título do livro: ");
                String titulo = scanner.nextLine();
                System.out.println("Digite o autor do livro: ");
                String autor = scanner.nextLine();
                livros[i] = new Livro(titulo, autor);
                System.out.println("Livro adicionado com sucesso!");
                return;
            }
        }
        System.out.println("Não foi possível adicionar o livro, pois a biblioteca está cheia.");
    }

    private static void ListarLivros(Livro[] livros, boolean somenteDisponivel){
        System.out.println(somenteDisponivel ? "====== Livros disponíveis ======" : "====== Livros ======");
        for (Livro livro : livros) {
            if (livro != null && (!somenteDisponivel || (somenteDisponivel && livro.isDisponivel()))) {
                System.out.println(livro);
            }
        }
    }

    private static void EmprestarLivro(Livro[] livros){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o título do livro que deseja emprestar: ");
        String titulo = scanner.nextLine();
        for (Livro livro : livros) {
            if (livro != null && livro.getTitulo().equalsIgnoreCase(titulo)) {
                if (livro.isDisponivel()) {
                    livro.setDisponivel(false);
                    System.out.println("Livro emprestado com sucesso!");
                } else {
                    System.out.println("Livro indisponível no momento.");
                }
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    private static void DevolverLivro(Livro[] livros){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Digite o título do livro que deseja devolver: ");
        String titulo = scanner.nextLine();
        for (Livro livro : livros) {
            if (livro != null && livro.getTitulo().equalsIgnoreCase(titulo)) {
                if (!livro.isDisponivel()) {
                    livro.setDisponivel(true);
                    System.out.println("Livro devolvido com sucesso!");
                } else {
                    System.out.println("Livro já está disponível.");
                }
                return;
            }
        }
        System.out.println("Livro não encontrado.");
    }

    private static void AddDefaultBooks(Livro[] livros) {
        livros[0] = new Livro("O Senhor dos Anéis", "J. R. R. Tolkien");
        livros[1] = new Livro("Harry Potter e a Pedra Filosofal", "J. K. Rowling");
        livros[2] = new Livro("O Pequeno Príncipe", "Antoine de Saint-Exupéry");
        livros[3] = new Livro("Dom Quixote", "Miguel de Cervantes");
        livros[4] = new Livro("1984", "George Orwell");
    }
    public static void Encerrar() {

        System.out.println("Pressione ENTER para continuar");
        try {
            int read = System.in.read(new byte[1]);
        } catch (Exception e) {
            System.out.println("Erro ao encerrar");
        }
    }
}