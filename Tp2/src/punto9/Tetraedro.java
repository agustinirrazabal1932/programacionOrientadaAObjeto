package punto9;

public class Tetraedro extends Figura3D{

    public void calcularAreaYVolumen(double arista){
        double elevado=Math.pow(arista,2);
        double raiz=Math.sqrt(3);
        double area=elevado*raiz;
        super.setArea(area);
        elevado=Math.pow(arista,3);
        raiz=Math.sqrt(2)/12;
        double volumen=elevado*raiz;
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
