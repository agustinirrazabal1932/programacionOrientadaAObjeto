package punto8;

import java.time.LocalDate;

public class Diario extends Publicaciones {
    private LocalDate fechaPublicacion;

    public Diario(String nombre,String editor,String te,int dia,int mes,int año){
        setNombre(nombre);
        setEditor(editor);
        setTe(te);
        LocalDate fechaP=LocalDate.of(año,mes,dia);
        setFechaPublicacion(fechaP);
    }

    public LocalDate getFechaPublicacion() {
        return fechaPublicacion;
    }

    public void setFechaPublicacion(LocalDate fechaPublicacion) {
        this.fechaPublicacion = fechaPublicacion;
    }
}
