package punto3;

import java.time.LocalTime;
import java.util.ArrayList;

public class Clase {
    private String diciplina;
    private String nivel;
    private Horario horario=new Horario();
    private ArrayList<Alumno>alumnnos=new ArrayList<Alumno>();
    private ArrayList<Alumno>asistencia=new ArrayList<Alumno>();
    private Profesor profesor;
    public Clase(String diciplina,String nivel){
        setDiciplina(diciplina);
        setNivel(nivel);
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public String getDiciplina() {
        return diciplina;
    }

    public void setDiciplina(String diciplina) {
        this.diciplina = diciplina;
    }

    public String getNivel() {
        return nivel;
    }

    public void setProfesor(Profesor profesor) {
        this.profesor = profesor;
    }

    public void setNivel(String nivel) {
        this.nivel = nivel;
    }
    public void agregarProfeALaClase(Profesor profe){
        setProfesor(profe);
    }
    public void agregarHorario(String dia, LocalTime horaInicio,LocalTime horaFinal){

        horario.agregarHorario(dia,horaInicio,horaFinal);
    }

    public void sumarAlumno(Alumno alumno){
        alumnnos.add(alumno);
    }

    public void validarAsistencia(int credencial,String dia){
        for (int i = 0; i < alumnnos.size(); i++) {
            Alumno alumnoActual=alumnnos.get(i);
            if (alumnoActual.getCredencial()==credencial){
                if (horario.validarDia(dia)) {
                    asistencia.add(alumnoActual);
                    System.out.println("se  encontro el alumno");
                }
                else{
                    System.out.println("el dia no es el correcto de la clase");
                }
            }
        }
    }
    public int mostrarAlumnosyDevolverSalario(){
        int salario=0;
        System.out.println("---Listado de alumnos que hicieron presencia");
        for (int i = 0; i < asistencia.size(); i++) {
            Alumno alumnoActual=asistencia.get(i);
            System.out.println("nombre: "+alumnoActual.getNombre());
            System.out.println("apellido: "+alumnoActual.getApellido());
            salario+=10;
        }
        return salario;
    }
    public int cantAlumnos(){
        return alumnnos.size();
    }

}
