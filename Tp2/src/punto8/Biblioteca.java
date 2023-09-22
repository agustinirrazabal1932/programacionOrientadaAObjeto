package punto8;

import java.util.ArrayList;

public class Biblioteca {
    private ArrayList<Publicaciones> listaPublicaciones=new ArrayList<Publicaciones>();
    private ArrayList<Socio>listaSocios=new ArrayList<Socio>();
    private ArrayList<Prestamo>listaPrestamo=new ArrayList<Prestamo>();
    private int cantSocio=0;

    public void cargarLibro(String nombre,String editor,String te,int  isbn,int añoPublicacio){
        Libro libroNuevo=new Libro(nombre,editor,te,isbn,añoPublicacio);
        listaPublicaciones.add(libroNuevo);
    }
    public int cargarSocio(String nombre,String apellido, String telefono){
        cantSocio++;
        int id=cantSocio;
        Socio socio=new Socio(nombre,apellido,telefono,id);
        listaSocios.add(socio);
        return cantSocio;
    }
    public int cantEjemplarLibro(String nombre,String editor){
        int total=0;
        for (int i = 0; i < listaPublicaciones.size(); i++) {
            Publicaciones publicaciones=listaPublicaciones.get(i);
            if (publicaciones.getNombre().equals(nombre) && publicaciones.getEditor().equals(editor)){
                Libro libro= (Libro) publicaciones;
                if (libro.isEstadoPrestamo()){
                    total++;
                }
            }
        }
        return total;
    }
    public void prestarLibro(int idSocio,String nombre,String editor){
        boolean estaSocio=false;
        for (int i = 0; i < listaSocios.size(); i++) {
            Socio socioAuxiliar=listaSocios.get(i);
            if (socioAuxiliar.getId()==idSocio){
                estaSocio=true;
            }
        }
        if (estaSocio){
            int cantLibros=cantEjemplarLibro(nombre,editor);
            boolean bandera=true;
            if (cantLibros>1){
                for (int i = 0; i < listaPublicaciones.size(); i++) {
                    Publicaciones publicaciones=listaPublicaciones.get(i);
                    if (publicaciones.getNombre().equals(nombre) && publicaciones.getEditor().equals(editor)){
                        Libro libro= (Libro) publicaciones;
                        if (libro.isEstadoPrestamo()&&bandera){
                            Prestamo prestamo=new Prestamo(idSocio,libro);
                            listaPrestamo.add(prestamo);
                            libro.setEstadoPrestamo(false);
                            bandera=false;

                        }
                    }
                }
                System.out.println("el libro fue prestado.");

            }else{
                System.out.println("el libro solo tiene una copia en la biblioteca y no se puede prestar");
            }

        }else{
            System.out.println("el id de socio no esta reegistrado en la biblioteca");
        }

    }
    public void verLibrosPrestados(){
        for (int i = 0; i < listaPrestamo.size(); i++) {
            Prestamo prestamo=listaPrestamo.get(i);
            Libro libroPrestado=prestamo.getLibro();
            System.out.println(libroPrestado);
        }
    }

}
