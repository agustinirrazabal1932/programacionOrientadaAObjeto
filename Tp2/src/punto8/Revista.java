package punto8;

public class Revista extends Publicaciones{
    private int issn;
    private int añoPublicacion;
    public Revista(String nombre,String editor,String te,int issn,int añoPublicacion){
        setNombre(nombre);
        setEditor(editor);
        setTe(te);
        setIssn(issn);
        setAñoPublicacion(añoPublicacion);
    }

    public int getIssn() {
        return issn;
    }

    public void setIssn(int issn) {
        this.issn = issn;
    }

    public int getAñoPublicacion() {
        return añoPublicacion;
    }

    public void setAñoPublicacion(int añoPublicacion) {
        this.añoPublicacion = añoPublicacion;
    }
}
