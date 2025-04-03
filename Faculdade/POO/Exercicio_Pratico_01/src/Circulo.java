public class Circulo {
    float raio;

    public void CalcularArea(){
        double area = (raio * raio) * 3.14;
        System.out.println("A área do seu círculo é: " + area);
    }

    public void CalcularPerimetro(){
        double perimetro = 2 * raio * 3.14;

        System.out.println("O perímetro do seu círculo é: " + perimetro);
    }

    public Circulo(float r){
        raio = r;
    }
}
