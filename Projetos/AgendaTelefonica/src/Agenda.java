import java.util.ArrayList;
import java.util.Scanner;

public class Agenda {


	public void ListarPessoa(ArrayList<Pessoa> agenda) {
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

	public void ExcluirPessoa(ArrayList<Pessoa> agenda){
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

	public void CadastrarPessoa(ArrayList<Pessoa> agenda){
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

}
