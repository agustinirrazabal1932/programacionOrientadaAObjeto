package punto9;

public class Paralelepipedo extends Figura3D {

    public void calcularAreaYVolumen(double arista1,double arista2,double arista3) {
        double area=2*(arista1 * arista2 + arista1 * arista3 + arista2 * arista3);
        setArea(area);
        double volumen=arista1*arista2*arista3;
        setVolumen(volumen);

    }

    @Override
    public double getArea() {
        return super.getArea();
    }

    @Override
    public double getVolumen() {
        return super.getVolumen();
    }
}
