package punto2;

public class Provedores {
    private String nombreDeLaEmpresa;
    private String clasificacion;

    private String descripcion;

    public Provedores(String nombre,String clasificacion,String descripcion){
        setDescripcion(descripcion);
        setClasificacion(clasificacion);
        setNombreDeLaEmpresa(nombre);
    }
    public String getClasificacion(){
        return clasificacion;
    }

    public void setClasificacion(String clasificacion) {
        this.clasificacion = clasificacion;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombreDeLaEmpresa() {
        return nombreDeLaEmpresa;
    }

    public void setNombreDeLaEmpresa(String nombreDeLaEmpresa) {
        this.nombreDeLaEmpresa = nombreDeLaEmpresa;
    }
}
