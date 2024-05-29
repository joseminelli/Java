import java.util.ArrayList;

public class Atividade1 {

    public static void main(String[] args){
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println("Valor da soma dos interos do array é: " + ArraySum(list, list.size() - 1));
    }

    private static int ArraySum(ArrayList<Integer> lista, int index){
        if(index == 0){
            return lista.get(index);
        }
        return lista.get(index) + ArraySum(lista, index - 1);
    }
}
