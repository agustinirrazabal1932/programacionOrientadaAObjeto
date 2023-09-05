package ar.edu.unlu.punto7;

public class Calculo {
    private Calculadora numeros = new Calculadora();

    public void agregarCalculo(int numeroA,int numeroB,int  numeroC){

        numeros.setNumeroA(numeroA);
        numeros.setNumeroB(numeroB);
        numeros.setNumeroC(numeroC);
    }
    public void solucion(){
        int inicio= -1*numeros.getNumeroB();
        int bALa2= (int) Math.pow(numeros.getNumeroB(), 2);
        int divisor= numeros.getNumeroA()*2;
        double parteDeRaiz= -1*(4* numeros.getNumeroA()* numeros.getNumeroC());
        parteDeRaiz+=bALa2;
        parteDeRaiz= Math.sqrt(parteDeRaiz);
        double raiz1= (inicio + parteDeRaiz)/divisor;
        double raiz2= (inicio - parteDeRaiz)/divisor;
        if (raiz2 != raiz1) {
            System.out.println("las raices son: " + raiz1 + " y " + raiz2);
        }
        else{
            System.out.println("las raices son iguales asi que el unico valor es: "+raiz1);
        }
    }
}
