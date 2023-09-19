package punto9;

public class Figura2DTriangulo extends Figur2DRectangulo{

    @Override
    public void calcularArea(double base, double altura) {
        double area=(base*altura)/2;
        setArea(area);
    }

    @Override
    public double getArea() {
        return super.getArea();
    }
}
