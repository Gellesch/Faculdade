public class Circuito extends FiguraGeometrica implements Cacula {
    private double x;
    private double y;
    private double raio;
    private final double PI = 3.14;

    public Circuito(double x, double y, double raio, String cor) {
        super(cor);
        this.x = x;
        this.y = y;
        this.raio = raio;
    }

    @Override
    public boolean compare(FiguraGeometrica outra) {
        if (outra instanceof Circuito) {
            Circuito c = (Circuito) outra;
            return x == c.x && y == c.y && raio == c.raio;
        }
        return false;

    }

    @Override
    public double Area() {
        return PI * raio * raio;
    }

    @Override
    public double Perimetro() {
        return 2 * PI * raio;
    }

    public boolean interseccao(Circuito c) {
        double distancia = Math.sqrt((x - c.x) * (y - c.y) * (y - c.y));
        return distancia <= raio + c.raio;
    }
}