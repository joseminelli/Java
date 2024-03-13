import java.util.Scanner;

public class Principal {

    public static void Encerrar() {

        System.out.println("Pressione ENTER para continuar");
        try {
            int read = System.in.read(new byte[1]);
            System.out.println("Encerrando...");
        } catch (Exception e) {
            System.out.println("Erro ao encerrar");
        }
    }

    public static void Atividade1() {
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[50];
        int even = 0;
        int odd = 0;
        int count = 0;

        int num;
        do {
            System.out.println("Digite um número (digite 0 para parar):");
            num = sc.nextInt();
            if (num != 0) {
                nums[count++] = num;
            }
        } while (num != 0);

        for (int i = 0; i < count; i++) {
            if (nums[i] % 2 == 0) {
                even++;
            } else {
                odd++;
            }
        }

        System.out.println("\n\n-------------------------");
        System.out.println("Pares: " + even);
        System.out.println("Ímpares: " + odd);
        System.out.println("-------------------------");
    }

    public static void Atividade2(){
        Scanner sc = new Scanner(System.in);
        int[] nums = new int[50];
        int result = 0;
        int count = 0;

        int num;
        do {
            System.out.println("Digite um número (digite -1 para parar):");
            num = sc.nextInt();
            if (num != -1) {
                nums[count++] = num;
            }
        } while (num != -1);

        for (int i = 0; i < count; i++) {
            result += nums[i];
        }
        System.out.println("\n\n-------------------------");
        System.out.println("Resultado: " + result);
        System.out.println("-------------------------");

    }

    public static void main(String[] args) {
        int opcao = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("============ Atividades ============");
            System.out.println("1 - Atividade 1");
            System.out.println("2 - Atividade 2");
            System.out.println("0 - Sair");
            System.out.println("Digite o número da atividade que deseja executar:");
            opcao = sc.nextInt();
            switch (opcao) {
                case 1:
                    Atividade1();
                    Encerrar();
                    break;
                case 2:
                    Atividade2();
                    Encerrar();
                    break;
                case 0:
                    System.out.println("Saindo...");
                    break;
                default:
                    System.out.println("Opção inválida");
                    break;
            }
        }while(opcao != 0);
    }
}
