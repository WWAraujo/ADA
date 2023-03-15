public class Main {

    public static void main(String[] args) {


        Forma retangulo = new Forma();
        retangulo.setLadoa(2);
        retangulo.setLadob(5);
        System.out.println("Área do Retangulo: " +
                retangulo.calcular(retangulo.getLadoa(), retangulo.getLadob()));

        Forma triangulo = new Forma();
        triangulo.setBase(4);
        triangulo.setAlt(5);

    }
}
