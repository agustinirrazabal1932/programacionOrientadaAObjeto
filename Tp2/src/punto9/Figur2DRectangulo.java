package punto9;

public class Figur2DRectangulo extends Figura2D {

    public void calcularArea(double base, double altura){
        double area=base*altura;
        setArea(area);
    }

    @Override
    public double getArea() {
        return super.getArea();
    }
}
