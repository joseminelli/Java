import java.io.IOException;
public class Variaveis {
    public static void main(String[] args) throws IOException {
      char ch;
      ch = 'x';
      System.out.println("ch contains " + ch);
      ch++;
      System.out.println("ch is now " + ch);
      ch = 90;
      System.out.println("ch is now " + ch);

      byte tipoByte = 127;
      short tipoShort = 32767;
      char tipoChar = 'A';
      int tipoInt = 2147483647;
      float tipoFloat = 3.4028235E38f;
      long tipoLong = 9223372036854775807L;
      double tipoDouble = 1.7976931348623157E308;
      boolean tipoBoolean = true;

      System.out.println("tipoChar contains " + tipoChar);
      System.out.println("tipoBoolean contains " + tipoBoolean);
      System.out.println("tipoDouble contains " + tipoDouble);
      System.out.println("tipoLong contains " + tipoLong);
      System.out.println("tipoFloat contains " + tipoFloat);
      System.out.println("tipoByte contains " + tipoByte);
      System.out.println("tipoShort contains " + tipoShort);
      System.out.println("tipoInt contains " + tipoInt);
    }
}
