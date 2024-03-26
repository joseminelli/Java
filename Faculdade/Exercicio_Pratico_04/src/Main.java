public class Main {
    public static void main(String[] args) {
        Livro livro1 = new Livro("Refúgio", 2011, "Harlan Coben");
        Livro livro2 = new Livro("Fahrenheit 451", 1953, "Ray Bradbury");

        livro1.setEmprestimo(new E_CurtoPrazo(0.3f));

        livro2.setEmprestimo(new E_LongoPrazo(0.2f));

        livro1.getMulta(10);
        livro2.getMulta(10);

        System.out.println();

        Revista revista1 = new Revista("Super Interessante", 1987, "Abril");
        Revista revista2 = new Revista("Veja", 1968, "Abril");

        revista1.setEmprestimo(new E_CurtoPrazo(0.4f));
        revista2.setEmprestimo(new E_LongoPrazo(0.3f));

        revista1.getMulta(10);
        revista2.getMulta(10);
    }
}
