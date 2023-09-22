package punto8;

import java.util.ArrayList;

public class Libro extends Publicaciones{
    private int isbn;
    private int añoPublicacion;
    private boolean estadoPrestamo;
    private ArrayList<Autor> listaAutores = new ArrayList<Autor>();

    public Libro(String nombre,String editor,String te,int  isbn,int añoPublicacio){
        setNombre(nombre);
        setEditor(editor);
        setTe(te);
        setIsbn(isbn);
        setAñoPublicacion(añoPublicacio);
        setEstadoPrestamo(true);
    }

    @Override
    public String toString() {
        String cadena="";
        cadena+=getNombre()+"\n"+getEditor()+"\n"+getTe()+"\n"+getIsbn()+"\n"+getAñoPublicacion()+"\n"+isEstadoPrestamo();
        return cadena;
    }

    public void agregarAutor(String nombre, String apellido){
        Autor autor=new Autor(nombre,apellido);
        listaAutores.add(autor);
    }

    public int getIsbn() {
        return isbn;
    }

    public void setIsbn(int isbn) {
        this.isbn = isbn;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public boolean isEstadoPrestamo() {
        return estadoPrestamo;
    }

    public void setEstadoPrestamo(boolean estadoPrestamo) {
        this.estadoPrestamo = estadoPrestamo;
    }
}
