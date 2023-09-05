package ar.edu.unlu.punto6;

import java.util.ArrayList;

public class Bliblioteca {
    private ArrayList<Libro> sistemaDeLaBiblio= new ArrayList<Libro>();

    public void agregarLibro(String autor,Object nombre, int cantPaginas,int cantUnidades){
        Libro nuevoLibro= new Libro();
        nuevoLibro.setAutor(autor);
        nuevoLibro.setNombre(nombre);
        nuevoLibro.setCantPaginas(cantPaginas);
        nuevoLibro.setCantDisponibles(cantUnidades);
        nuevoLibro.setCantPrestados(0);
        sistemaDeLaBiblio.add(nuevoLibro);
    }

    public void verLibros(){
        Libro libroActual= new Libro();
        for (int i=0;i<sistemaDeLaBiblio.size();i++){
            libroActual=sistemaDeLaBiblio.get(i);
            System.out.println("---LIBRO "+i+"---");
            System.out.println("AUTOR: "+libroActual.getAutor());
            System.out.println("NOMBRE: "+libroActual.getNombre());
            System.out.println("NUMEROS DE PAG: "+libroActual.getCantPaginas());
            System.out.println("DISPONIBLES: "+ libroActual.getCantDisponibles());
            System.out.println("PRESTARON: "+ libroActual.getCantPrestados());
        }

    }

    public void prestarLibro(int i){
        if (i > sistemaDeLaBiblio.size() || i<1){
            System.out.println("el numero de libro es invalido");
        }
        else{
            Libro libroActual = new Libro();
            libroActual=sistemaDeLaBiblio.get(i-1);
            if (libroActual.getCantDisponibles()>1){
                int elementoActual=libroActual.getCantDisponibles();
                elementoActual--;
                libroActual.setCantDisponibles(elementoActual);
                int elementosPrestadas=libroActual.getCantPrestados();
                elementosPrestadas++;
                libroActual.setCantPrestados(elementosPrestadas);
                System.out.println("el libro se presto correctamente");
            }
            else{
                System.out.println("el libro no puede prestarse, por que queda solo 1 unidad del libro");
            }
        }
    }

    public void calcularPaginas(int indexLib1,int indexLib2){
        if ( (indexLib1 > sistemaDeLaBiblio.size() || indexLib1<1) || (indexLib2 > sistemaDeLaBiblio.size() || indexLib2<1) ){
            System.out.println("el numero de libro es invalido");
        }
        else{
            Libro libro1 = new Libro();
            Libro libro2 = new Libro();
            libro1= sistemaDeLaBiblio.get(indexLib1-1);
            libro2=sistemaDeLaBiblio.get(indexLib2-1);
            if (libro1.getCantPaginas()>libro2.getCantPaginas()){
                System.out.println("el libro con mas paginas es el: "+libro1.getNombre());
            } else if (libro2.getCantPaginas() > libro1.getCantPaginas()){
                System.out.println("el libro con mas paginas es el: "+libro2.getNombre());
            }
            else {
                System.out.println("los libros "+libro1.getNombre()+" y "+libro2.getNombre()+" tienen las mismas cantidad de paginas");
            }
        }
    }
    public void librosPrestadosEnTotal(){
        int acumulador=0;
        Libro libroActual = new Libro();
        for (int i=0;i<sistemaDeLaBiblio.size();i++){
            libroActual = sistemaDeLaBiblio.get(i);
            acumulador+=libroActual.getCantPrestados();
        }
        System.out.println("la cantidad de libros prestados en la biblioteca en total son de: "+acumulador);
    }
}
