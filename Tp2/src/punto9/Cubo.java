package punto9;

public class Cubo extends Figura3D{

    public void calcularAreaYVolumen(double arista){
        double base=Math.pow(arista,2);
        double area=base*6;
        super.setArea(area);
        double volumen=Math.pow(arista,3);
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
