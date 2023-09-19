package punto9;

public class ModuloMatematicas {

    public void calcularAreaCuadradoYCirculo(String nombre,double parametro1){
        if (nombre=="cuadrado"){
            Figura2DCuadrado cuadrado=new Figura2DCuadrado();
            cuadrado.calcularArea(parametro1);
            System.out.println(cuadrado.getArea());
        } else if (nombre=="circulo") {
            Figura2DCir circulo=new Figura2DCir();
            circulo.calcularArea(parametro1);
            System.out.println(circulo.getArea());
        }
    }
    public void calcularAreaRectanguloYTriangulo(String nombre,double parametro1,double parametro2){
        if (nombre=="rectangulo"){
            Figur2DRectangulo rectangulo  = new Figur2DRectangulo();
            rectangulo.calcularArea(parametro1,parametro2);
            System.out.println(rectangulo.getArea());
        } else if (nombre=="triangulo") {
            Figura2DTriangulo triangulo = new Figura2DTriangulo();
            triangulo.calcularArea(parametro1,parametro2);
            System.out.println(triangulo.getArea());
        }
    }

    public void AreaYVolumenEsfera(double radio){
        Esfera esfera= new Esfera();
        esfera.calcularAreaYVolumen(radio);
        System.out.println("el area de la esfera es: "+esfera.getArea()+" y el volumen: "+esfera.getVolumen());
    }

    public void AreaYVolumenParalelepipedo(double arista1,double arista2,double arista3){
        Paralelepipedo paralelepipedo= new Paralelepipedo();
        paralelepipedo.calcularAreaYVolumen(arista1,arista2,arista3);
        System.out.println("el area del paralelepipedo es: "+paralelepipedo.getArea()+" y el volumen: "+paralelepipedo.getVolumen());
    }

    public void AreaYVolumenCubo(double arista){
        Cubo cubo=new Cubo();
        cubo.calcularAreaYVolumen(arista);
        System.out.println("el area del cubo es: "+cubo.getArea()+" y el volumen: "+cubo.getVolumen());
    }

    public void AreaYVolumenTetraedro(double arista){
        Tetraedro tetraedro=new Tetraedro();
        tetraedro.calcularAreaYVolumen(arista);
        System.out.println("el area del cubo es: "+tetraedro.getArea()+" y el volumen: "+tetraedro.getVolumen());
    }
}
