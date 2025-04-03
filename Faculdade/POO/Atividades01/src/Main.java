import java.util.Scanner;

public class Main {

    public static void Encerrar() {

        System.out.println("Pressione ENTER para continuar");
        try {
            int read = System.in.read(new byte[1]);
            System.out.println("Encerrando...");
        } catch (Exception e) {
            System.out.println("Erro ao encerrar");
        }
    }

    public static void Atividade01(){
        int count = 0;
        System.out.println("\n === Atividade 01 ===\n");
        for(int i = 1; i < 1000; i+=2){
            if(i % 3 == 0){
                System.out.print("|" + "   " + i + "   " + "|" + "   " );
                count++;
            }
            if(i % 33 == 0){
                System.out.println();
            }
        }
        System.out.println("\n\nTotal de números: " + count + "\n");
    }

    public static void Atividade02(){
        int[] nums = new int[10];
        float soma = 0;
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < 10; i++){
            System.out.println("Digite o " + (i+1) + "º número:");
            nums[i] = sc.nextInt();
            soma += nums[i];
        }
        System.out.println("A soma dos números é: " + soma);
        System.out.println("A média dos números é: " + soma / nums.length);
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
                    Atividade01();
                    Encerrar();
                    break;
                case 2:
                    Atividade02();
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

