public class Color {
    public static void Yellow(){
        System.out.print("\u001B[33m");
    }
    public static void Red(){
        System.out.print("\u001B[31m");
    }
    public static void Green(){
        System.out.print("\u001B[32m");
    }
    public static void Blue(){
        System.out.print("\u001B[34m");
    }
    public static void Purple(){
        System.out.print("\u001B[35m");
    }
    public static void Cyan(){
        System.out.print("\u001B[36m");
    }
    public static void White(){
        System.out.print("\u001B[37m");
    }
    public static void RESET(){
        System.out.print("\u001B[0m");
    }

    public static void RandomColor(){
        int random = (int) (Math.random() * 6);
        switch (random){
            case 0:
                Yellow();
                break;
            case 1:
                Green();
                break;
            case 2:
                Blue();
                break;
            case 3:
                Purple();
                break;
            case 4:
                Cyan();
                break;
            case 5:
                White();
                break;
        }
    }

}