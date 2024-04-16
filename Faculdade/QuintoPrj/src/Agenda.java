import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {
	public static void main(String[] args) {


		// [ A ] declarando e instanciando uma agenda de contatos
		ArrayList<Pessoa> agenda = new ArrayList<>();

		// [ B ] usando o método add() para gravar 4 contatos na agenda

		agenda.add(new Pessoa("Ana", 25, "1234-5678"));
		agenda.add(new Pessoa("Bia", 20, "5678-1234"));
		agenda.add(new Pessoa("Carlos", 30, "9876-5432"));

		int opcao;
        do{
			Scanner scanner = new Scanner(System.in);
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
					ListarPessoa(agenda);
					} catch (Exception e) {
						Color.Red();
						System.out.println("\n\nErro ao listar pessoa: " + e.getMessage() + "\n\n");
						Color.RESET();
					}
					Encerrar();
					break;
				case 2:
					try	{
						CadastrarPessoa(agenda);
					} catch (Exception e) {
						Color.Red();
						System.out.println("\n\nErro ao cadastrar pessoa: " + e.getMessage() + "\n\n");
						Color.RESET();
					}
					Encerrar();
					break;
				case 3:
					try {
						ExcluirPessoa(agenda);
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
					System.out.println("Opção inválida!");
					break;
			}
		} while(opcao != 0);
	}

	private static void ListarPessoa(ArrayList<Pessoa> agenda) {
		int i;
		// [ F ] mostrando os "n" contatos da agenda (usando for-each)
		Color.Blue();
		System.out.print("\nContatos da agenda:\n");
		Color.RESET();
		i = 0;
		for (Pessoa contato : agenda) {
			System.out.printf("Posição %d - %s / %s\n", i+1, contato.getNome(), contato.getTel());
			i++;
		}
	}

	public static void ExcluirPessoa(ArrayList<Pessoa> agenda){
		Scanner ler = new Scanner(System.in);
		int i;
		System.out.print("\nInforme a posição a ser excluída (0 pra cancelar):\n");
		i = ler.nextInt();

		try {
			i--; // ajuste de posição
			if(i != -1) {
				Color.Yellow();
				System.out.println("Contato excluído: " + agenda.get(i).getNome());
				Color.RESET();
				// [ E ] remove o i-ésimo contato da agenda
				agenda.remove(i);
			}
		} catch (IndexOutOfBoundsException e) {
			// exceção lançada para indicar que um índice (i)
			// está fora do intervalo válido (de 0 até agenda.size()-1)
			System.out.printf("\nErro: posição inválida (%s).", e.getMessage());
		}

	}

	public static void CadastrarPessoa(ArrayList<Pessoa> agenda){
		Scanner ler = new Scanner(System.in);
		int i;

		// [ D ] adicionando pessoas na agenda
		int novapessoa;

		do{
			try{
				System.out.print("\nInforme a posição a ser inserida (0 pra cancelar): ");
				i = ler.nextInt();
				i--; // ajuste de posição
				if(i != -1) {

					ler.nextLine();
					System.out.print("\nInforme o nome da pessoa: ");
					String nome = ler.nextLine();

					System.out.print("Informe a idade da pessoa: ");

					int idade = ler.nextInt();
					System.out.print("Informe o telefone da pessoa: ");

					String tel = ler.next();
					agenda.add(i, new Pessoa(nome, idade, tel));
				}
			} catch (IndexOutOfBoundsException e) {
				// exceção lançada para indicar que um índice (i)
				// está fora do intervalo válido (de 0 até agenda.size()-1)
				System.out.printf("\nErro: posição inválida (%s).", e.getMessage());
			} catch (Exception e) {
				System.out.printf("\nErro: %s.", e.getMessage());
			}

			System.out.print("\nDeseja adicionar mais uma pessoa? (1 - Sim / 0 - Não): ");
			novapessoa = ler.nextInt();
		}while(novapessoa == 1);
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
