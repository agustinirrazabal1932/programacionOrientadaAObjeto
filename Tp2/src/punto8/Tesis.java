package punto8;

public class Tesis extends Publicaciones{
    private int mesPublicacion;
    private int añoPublicacion;
    private Autor autor;

    public Tesis(String nombre,String editor,String te,int mesPublicacion,int añoPublicacion,String nombreAutor,String apellidoAutor){
        setNombre(nombre);
        setEditor(editor);
        setTe(te);
        setMesPublicacion(mesPublicacion);
        setAñoPublicacion(añoPublicacion);
        Autor autorNuevo=new Autor(nombreAutor,apellidoAutor);
        setAutor(autorNuevo);
    }

    public int getMesPublicacion() {
        return mesPublicacion;
    }

    public void setMesPublicacion(int mesPublicacion) {
        this.mesPublicacion = mesPublicacion;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }

    public void setAutor(Autor autor) {
        this.autor = autor;
    }

    public Autor getAutor() {
        return autor;
    }
}
