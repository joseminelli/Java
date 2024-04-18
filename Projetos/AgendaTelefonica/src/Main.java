import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Agenda agendaClass = new Agenda();
        ArrayList<Pessoa> agenda = new ArrayList<>();


        agenda.add(new Pessoa("Ana", 25, "1234-5678"));
        agenda.add(new Pessoa("Bia", 20, "5678-1234"));
        agenda.add(new Pessoa("Carlos", 30, "9876-5432"));

        System.out.println("Como deseja ver a agenda?");
        System.out.println("[1] Terminal");
        System.out.println("[2] GUI");
        Scanner scanner = new Scanner(System.in);
        String escolha = scanner.nextLine();
        escolha = escolha.toLowerCase();
        do {
            if (escolha.equals("1") || escolha.equals("terminal")) {
                AgendaTerminal(agenda, scanner, agendaClass);
                break;
            } else if (escolha.equals("2") || escolha.equals("gui")) {
                new AgendaGUI(agenda);
                break;
            } else {
                System.out.println("Escolha inválida");
                escolha = scanner.nextLine();
            }
        } while (true);

    }

    public static void AgendaTerminal(ArrayList<Pessoa> agenda, Scanner scanner, Agenda agendaClass){
        int opcao;
        do{
            Color.Green();
            System.out.println("\n\nAgenda de Pessoas");
            Color.RESET();
            System.out.println("\n1 - Listar Pessoas");
            System.out.println("2 - Cadastrar Pessoa");
            System.out.println("3 - Excluir Pessoa");
            System.out.println("0 - Sair");
            System.out.print("Opção: ");
            opcao = scanner.nextInt();

            switch(opcao) {
                case 1:
                    try {
                        agendaClass.ListarPessoa(agenda);
                    } catch (Exception e) {
                        Color.Red();
                        System.out.println("\n\nErro ao listar pessoa: " + e.getMessage() + "\n\n");
                        Color.RESET();
                    }
                    Encerrar();
                    break;
                case 2:
                    try	{
                        agendaClass.CadastrarPessoa(agenda);
                    } catch (Exception e) {
                        Color.Red();
                        System.out.println("\n\nErro ao cadastrar pessoa: " + e.getMessage() + "\n\n");
                        Color.RESET();
                    }
                    Encerrar();
                    break;
                case 3:
                    try {
                        agendaClass.ExcluirPessoa(agenda);
                    } catch (Exception e) {
                        Color.Red();
                        System.out.println("\n\nErro ao excluir pessoa: " + e.getMessage() + "\n\n");
                        Color.RESET();
                    }
                    Encerrar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    Color.Red();
                    System.out.println("\n\nOpção inválida!\n\n");
                    Color.RESET();
                    Encerrar();
                    break;
            }
        } while(opcao != 0);
    }

    public static void Encerrar() {

        System.out.println("\nPressione ENTER para continuar");
        try {
            int read = System.in.read(new byte[1]);
            System.out.println("Encerrando...");
        } catch (Exception e) {
            System.out.println("Erro ao encerrar");
        }
    }
}
