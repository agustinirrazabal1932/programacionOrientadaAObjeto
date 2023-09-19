package punto9;

public class Esfera extends Figura3D{

    public void calcularAreaYVolumen(double radio){

        double base=Math.pow(radio,2);
        double area= 4*Math.PI*base;
        super.setArea(area);
        base=Math.pow(radio,3);
        double volumen=(4/3)*Math.PI*base;
        super.setVolumen(volumen);

    }

    @Override
    public double getVolumen() {
        return super.getVolumen();
    }

    @Override
    public double getArea() {
        return super.getArea();
    }
}
