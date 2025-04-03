public class Revista extends Material{
    String editora;

    public Revista(String titulo, int ano, String editora) {
        super(titulo, ano);
        this.editora = editora;
    }
}
