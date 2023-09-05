package ar.edu.unlu.punto13;

import java.time.LocalDate;

public class AdministradorTareas {

private ListaDeTarea lista=new ListaDeTarea();


    public void crearYAgregarTarea(Object descrip, String estado, LocalDate fecha, String prioridad){
        Tarea nuevaTarea= new Tarea();
        nuevaTarea.setDescripcion(descrip);
        nuevaTarea.setEstado(estado);
        nuevaTarea.setFecha(fecha);
        nuevaTarea.setPrioridad(prioridad);
        lista.agregarTarea(nuevaTarea);

    }
    public void creaYAgregarColaboradores(String nombre,int edad,String dni){
        Colaborador colaborador= new Colaborador();
        colaborador.setNombre(nombre);
        colaborador.setEdad(edad);
        colaborador.setDni(dni);
        lista.agregarColaborador(colaborador);
    }

    public void mostarListaDeTarea(){
        Tarea actualTarea= new Tarea();
        LocalDate tareaFecha;
        LocalDate actualFecha= LocalDate.now();
        this.lista=lista.ordenarPorPrioridad();
        this.lista=lista.ordenarPorFecha();



        for (int y = 0; y < lista.getCantidadTarea(); y++) {
            int cont= y+1;
            actualTarea=lista.buscarTarea(y);
            tareaFecha=actualTarea.getFecha();
            if ((actualTarea.getEstado()=="incompleta")&&(tareaFecha.isBefore(actualFecha))) {
            }
            else {
                System.out.println("----TAREA " + cont + "----");
                actualTarea = lista.buscarTarea(y);
                System.out.println("Prioridad: " + actualTarea.getPrioridad());
                System.out.println("Fecha: " + actualTarea.getFecha());
                System.out.println("Estado: " + actualTarea.getEstado());
                System.out.println("Descripcion: " + actualTarea.getDescripcion());
            }

        }
        System.out.println("fin de la lista de  tareas");
    }

    public boolean BuscarPorTitulo(String descrip){
        Tarea actualTarea= new Tarea();
        boolean bandera=false;
        for (int i = 0; i < lista.getCantidadTarea(); i++) {
            actualTarea=lista.buscarTarea(i);
            if (actualTarea.getDescripcion().equals(descrip)){
                bandera=true;
                return bandera;
            }
        }
        return bandera;
    }

    public void marcarTareaComoHecha(String titulo,Colaborador colaborador,LocalDate fechaActual){
        Tarea actualTarea= new Tarea();
        if (lista.BuscarColaborador(colaborador)) {
            for (int i = 0; i < lista.getCantidadTarea(); i++) {
                actualTarea = lista.buscarTarea(i);
                if (actualTarea.getDescripcion().equals(titulo)) {
                    actualTarea.setEstado("completa");
                    actualTarea.setFechaFinalizacion(fechaActual);
                    actualTarea.setColaboradorFinaliza(colaborador);
                }
            }
        }
    }

    public void mostrarTareaPorColaborador(Colaborador colaborador){
        if (lista.BuscarColaborador(colaborador)){
            Tarea actualTarea= new Tarea();
            for (int i = 0; i < lista.getCantidadTarea(); i++) {
                actualTarea=lista.buscarTarea(i);
                if (actualTarea.getColaboradorFinaliza().equals(colaborador)){
                    System.out.println("----TAREA----");
                    System.out.println("Prioridad: "+actualTarea.getPrioridad());
                    System.out.println("Fecha: "+actualTarea.getFecha());
                    System.out.println("Estado: "+actualTarea.getEstado());
                    System.out.println("Descripcion: "+ actualTarea.getDescripcion());
                }
            }
        }
        else{
            System.out.println("el colaborador no esta en la lista de tarea");
        }
    }

}
