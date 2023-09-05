package ar.edu.unlu.punto12;

import java.time.LocalDate;
import java.util.ArrayList;

public class ListaDeTarea {
    private ArrayList<Tarea> listaTarea =new ArrayList<Tarea>();
    private int cantidadTarea=0;

    public void agregarTarea(Tarea nuevaTarea){
        listaTarea.add(cantidadTarea,nuevaTarea);
        cantidadTarea++;
    }
    public void insertarTarea(int i,Tarea tarea){
        listaTarea.add(i,tarea);
        cantidadTarea++;
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

    public int getCantidadTarea() {
        return cantidadTarea;
    }

    public Tarea buscarTarea(int i){
        return listaTarea.get(i);
    }

    public ListaDeTarea ordenarPorPrioridad(){

        Tarea actualTarea= new Tarea();
        LocalDate actualFecha= LocalDate.now();
        ListaDeTarea listafinal= new ListaDeTarea();


        for (int i=0;i<this.listaTarea.size();i++){
            actualTarea=this.listaTarea.get(i);
            LocalDate tareaFecha= actualTarea.getFecha();

            if ((actualTarea.getEstado()=="incompleta")&&(tareaFecha.isAfter(actualFecha))){
                if (actualTarea.getPrioridad() == "urgente") {
                    listafinal.agregarTarea(actualTarea);
                }
            }
        }
        for (int i=0;i<this.listaTarea.size();i++){
            actualTarea=this.listaTarea.get(i);
            LocalDate tareaFecha= actualTarea.getFecha();

            if ((actualTarea.getEstado()=="incompleta")&&(tareaFecha.isAfter(actualFecha))){
                if (actualTarea.getPrioridad() == "normal") {
                    listafinal.agregarTarea(actualTarea);
                }
            }
        }
        for (int i=0;i<this.listaTarea.size();i++){
            actualTarea=this.listaTarea.get(i);
            LocalDate tareaFecha= actualTarea.getFecha();

            if ((actualTarea.getEstado()=="incompleta")&&(tareaFecha.isAfter(actualFecha))){
                if (actualTarea.getPrioridad() == "irrelevante") {
                    listafinal.agregarTarea(actualTarea);
                }
            }
        }
        return listafinal;

    }

    public ListaDeTarea ordenarPorFecha(){
        Tarea actualTarea;
        Tarea actualTarea2;
        ListaDeTarea listaFinal2= new ListaDeTarea();


        for (int i=0;i<this.listaTarea.size();i++){

            actualTarea=this.listaTarea.get(i);
            LocalDate tareaFecha= actualTarea.getFecha();
            int posi=0;
            boolean bandera= true;

            for (int y = 0; y < listaFinal2.getCantidadTarea(); y++) {
                actualTarea2=this.listaTarea.get(y);
                LocalDate tareaFecha2= actualTarea2.getFecha();

                if (actualTarea.getPrioridad().equals(actualTarea2.getPrioridad())){
                    if ( tareaFecha2.isAfter(tareaFecha) && bandera){
                        posi=y;
                        bandera=false;
                    }
                }
            }
            if (bandera){
                listaFinal2.agregarTarea(actualTarea);
            } else {
                listaFinal2.insertarTarea(posi,actualTarea);
            }
        }
        return listaFinal2;
    }

}
