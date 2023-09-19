package punto3;

import java.time.LocalTime;
import java.util.ArrayList;

public class Academia {
    private int cantAlumnas=0;
    private ArrayList<Profesor> profesores= new ArrayList<Profesor>();
    private ArrayList<Clase>clases= new ArrayList<Clase>();

    public void cargarProfesor(String nombre,String apellido,String dni){
        Profesor nuevoProfe=new Profesor(nombre, apellido, dni);
        profesores.add(nuevoProfe);
    }
    public void cargarClase(String dniProfe, String diciplina, String nivel, String dia, LocalTime horanIcio,LocalTime horaFinal){
        Clase nuevaClase=new Clase(diciplina,nivel);
        for (int i = 0; i <profesores.size(); i++) {
            Profesor profeActual=profesores.get(i);
            if (dniProfe == profeActual.getDni()){
                nuevaClase.agregarProfeALaClase(profeActual);
                nuevaClase.agregarHorario(dia,horanIcio,horaFinal);
                clases.add(nuevaClase);
            }
        }
    }
    public int cargarAlumnos(String nombre,String apellido,String dni,String telefono,String disciplina,String nivel){
        int credencial=0;
        for (int i = 0; i < clases.size(); i++) {
            Clase clase=clases.get(i);
            if ((clase.getDiciplina()==disciplina)&&(clase.getNivel()==nivel)){
                cantAlumnas++;
                credencial=cantAlumnas;
                Alumno nuevoAlumno=new Alumno(nombre,apellido,dni,telefono,credencial);
                clase.sumarAlumno(nuevoAlumno);
            }
        }
        return credencial;
    }
    public void registrarAsistencia(int credencial,String disciplina,String nivel,String dia){
        for (int i = 0; i < clases.size(); i++) {
            Clase claseActual=clases.get(i);
            if ((claseActual.getNivel()==nivel) && (claseActual.getDiciplina()==disciplina)){
                claseActual.validarAsistencia(credencial,dia);
            }
        }
    }
    public int pasarListadoYSalario(String profesorDni){
        int salario=0;
        for (int i = 0; i < clases.size(); i++) {
            Clase clase=clases.get(i);
            if (clase.getProfesor().getDni()==profesorDni){
                salario=clase.mostrarAlumnosyDevolverSalario();
            }
        }
        return salario;
    }

    public void disciplinaQueMayorReditua(){
        int mayor=-1;
        Clase claseMayor=null;
        for (int i = 0; i < clases.size(); i++) {
            Clase clase=clases.get(i);
            int totalAlumno=clase.cantAlumnos();
            if (totalAlumno>mayor){
                mayor=totalAlumno;
                claseMayor=clase;
            }
        }
        System.out.println("la clase que mayor ingresa es la de diciplina: "+claseMayor.getDiciplina()+" y de nivel: "+claseMayor.getNivel());
    }
}
