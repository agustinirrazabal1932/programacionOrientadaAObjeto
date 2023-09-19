package punto9;

public class Figura2DCuadrado extends Figura2D{
    public void calcularArea(double lado){
        double area= lado*lado;
        setArea(area);
    }

    @Override
    public double getArea() {
        return super.getArea();
    }
}
