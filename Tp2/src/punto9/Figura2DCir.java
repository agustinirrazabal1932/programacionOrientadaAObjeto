package punto9;

public class Figura2DCir extends Figura2D {


    public void calcularArea(double radio){
        double radio2= Math.pow(radio,2);
        double area= Math.PI*radio2;

        setArea(area);
    }

    @Override
    public double getArea() {
        return super.getArea();
    }
}
