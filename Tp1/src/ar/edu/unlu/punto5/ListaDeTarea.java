package ar.edu.unlu.punto5;
import java.time.LocalDate;
import java.util.ArrayList;

public class ListaDeTarea {
    private ArrayList<Tarea> listaTarea =new ArrayList<Tarea>();
    private int cantidadTarea=0;

    public void agregarTarea(Object descrip, String estado, LocalDate fecha,LocalDate fechaRecordatorio){
        Tarea nuevaTarea= new Tarea();
        nuevaTarea.setDescripcion(descrip);
        nuevaTarea.setEstado(estado);
        nuevaTarea.setFecha(fecha);
        nuevaTarea.setFechaRecordatorio(fechaRecordatorio);
        listaTarea.add(cantidadTarea,nuevaTarea);
        cantidadTarea++;
    }

    public void mostarListaDeTarea(){
        Tarea actualTarea= new Tarea();
        LocalDate actualFecha= LocalDate.now();
        for (int i=0;i<cantidadTarea;i++){
            int cont= i+1;
            System.out.println("----TAREA "+ cont +"----");
            actualTarea=listaTarea.get(i);
            LocalDate tareaFecha= actualTarea.getFecha();

            if ((actualTarea.getestado()=="incompleta")&&(tareaFecha.isBefore(actualFecha))){
                System.out.println("(VENCIDA)");
            }
            if ((actualTarea.getFechaRecordatorio().isBefore(actualFecha) || actualTarea.getFechaRecordatorio().isEqual(actualFecha)) && actualTarea.getestado()=="incompleta" && tareaFecha.isAfter(actualFecha) ){
                System.out.println("La tarea esta por vencer");
            }
            System.out.println("descripcion: "+actualTarea.getDescripcion());
            System.out.println("estado: "+ actualTarea.getestado());
            System.out.println("fecha limite: "+ tareaFecha);
        }
    }

    public void editarDescripcion(Object descrip,int numDeTarea){
        if (numDeTarea > cantidadTarea || numDeTarea<1){
            System.out.println("el numero de tarea es invalido");
        }
        else{
            listaTarea.get(numDeTarea-1).setDescripcion(descrip);
        }
    }

    public void borrarTarea(int numDeTarea){
        if (numDeTarea > cantidadTarea || numDeTarea<1){
            System.out.println("el numero de tarea es invalido");
        }
        else{
            listaTarea.remove((numDeTarea-1));
            cantidadTarea--;
        }
    };

}
