public class Forma extends Geometria{

    private double ladoa;
    private double ladob;
    private float base;
    private float alt;

    public Forma() {
    }

    public Forma(double ladoa, double ladob) {
        this.ladoa = ladoa;
        this.ladob = ladob;
    }

    public Forma(double raio){
        super.raio = raio;
    }

    public double getLadoa() {
        return ladoa;
    }

    public void setLadoa(double ladoa) {
        this.ladoa = ladoa;
    }

    public double getLadob() {
        return ladob;
    }

    public void setLadob(double ladob) {
        this.ladob = ladob;
    }

    public float getBase() {
        return base;
    }

    public void setBase(float base) {
        this.base = base;
    }

    public float getAlt() {
        return alt;
    }

    public void setAlt(float alt) {
        this.alt = alt;
    }

    public double calcular (double ladoa, double ladob){
        this.ladoa = ladoa;
        this.ladob = ladob;
        double area = this.ladoa * this.ladob;
        return area;
    }

    public float calcular (int base, int altura){
        this.base = base;
        this.alt = altura;
        float area = (this.base * this.alt) / 2;
        return area;
    }

}
