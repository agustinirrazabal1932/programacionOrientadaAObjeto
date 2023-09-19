package punto1;

import java.time.LocalDate;
import java.util.ArrayList;

public class ClubFutbol {

    private ArrayList<Socio> listaDeSocio =new ArrayList<Socio>();
    private ArrayList<Actividad> listaDeActividades =new ArrayList<Actividad>();


    public void agregarYCrearSocio(String nombre,String apellido,String correo,String direccion,String dni,int edad ,String suscripcion, LocalDate fecha){
        Socio socio= new Socio(nombre,apellido,dni,correo,direccion,edad);
        int credencial=listaDeSocio.size()+1;
        socio.setCredencial(credencial);
        socio.setSuscripcion(suscripcion);
        socio.setFechaDeSuscripcion(fecha);
        listaDeSocio.add(socio);
    }
    public void agregarYCrearActividad(String nombre,String tipoActividad){
        Actividad actividad=new Actividad(nombre,tipoActividad);
        listaDeActividades.add(actividad);

    }
    public void mostrarActividadesEnOrden(){
        MostrarActividadesBasica();
        MostrarActividadesintermedias();
        MostrarActividadesDestacadas();
    }
    public void mostrarSociosEnOrden(){
        mostrarSociosBasicos();
        mostrarSociosIntermedios();
        mostrarSociosDestacada();
    }

    public void mostrarSociosDelUltimoMes(){
        Socio actualSocio;
        LocalDate actualFecha= LocalDate.now();
        LocalDate unMesAnte= actualFecha.minusMonths(1);
        for (int i = 0; i < listaDeSocio.size(); i++) {
            actualSocio=listaDeSocio.get(i);
            LocalDate actualSocioFecha=actualSocio.getFechaDeSuscripcion();
            //System.out.println(unMesAnte);
            if ( unMesAnte.isBefore(actualSocioFecha) && actualFecha.isAfter(actualSocioFecha)){
                System.out.println("El socio");
                System.out.println("El nombre: "+actualSocio.getNombre());
                System.out.println("El apellido: "+actualSocio.getApellido());
                System.out.println("El dni: "+actualSocio.getDni());
                System.out.println("La credencial: "+actualSocio.getCredencial());
                System.out.println("la supcricion: "+actualSocio.getSuscripcion());

            }
        }
    }

    private void MostrarActividadesBasica(){
        Actividad actividadActual;
        System.out.println("Actividades Basicas");
        for (int i = 0; i < listaDeActividades.size(); i++) {
            actividadActual=listaDeActividades.get(i);
            if (actividadActual.getTipoDeActividad()=="basica"){
                System.out.println(actividadActual.getNombre());

            }
        }
    }
    private void MostrarActividadesintermedias(){
        Actividad actividadActual;
        System.out.println("Actividades Intermedias:");
        for (int i = 0; i < listaDeActividades.size(); i++) {
            actividadActual=listaDeActividades.get(i);
            if (actividadActual.getTipoDeActividad()=="intermedia"){
                System.out.println(actividadActual.getNombre());

            }

        }
    }

    private void MostrarActividadesDestacadas(){
        Actividad actividadActual;
        System.out.println("Actividades Destacadas:");
        for (int i = 0; i < listaDeActividades.size(); i++) {
            actividadActual=listaDeActividades.get(i);
            if (actividadActual.getTipoDeActividad()=="destacada"){
                System.out.println(actividadActual.getNombre());

            }

        }
    }
    
    private void mostrarSociosBasicos(){
        Socio socio;
        System.out.println("Lista de socios con supcripcion basica");
        for (int i = 0; i < listaDeSocio.size(); i++) {
            socio=listaDeSocio.get(i);
            if(socio.getSuscripcion().equals("basica")){

                System.out.println("El nombre: "+socio.getNombre());
                System.out.println("El apellido: "+socio.getApellido());
                System.out.println("El dni: "+socio.getDni());
                System.out.println("La credencial: "+socio.getCredencial());
                System.out.println("la supcricion: "+socio.getSuscripcion());
            }
        }
    }
    private void mostrarSociosIntermedios(){
        Socio socio;
        System.out.println("Lista de socios con supcripcion intermedios");
        for (int i = 0; i < listaDeSocio.size(); i++) {
            socio=listaDeSocio.get(i);
            if(socio.getSuscripcion().equals("intermedia")){

                System.out.println("El nombre: "+socio.getNombre());
                System.out.println("El apellido: "+socio.getApellido());
                System.out.println("El dni: "+socio.getDni());
                System.out.println("La credencial: "+socio.getCredencial());
                System.out.println("la supcricion: "+socio.getSuscripcion());
            }
        }
    }
    private void mostrarSociosDestacada(){
        Socio socio;
        System.out.println("Lista de socios con supcripcion destacada");
        for (int i = 0; i < listaDeSocio.size(); i++) {
            socio=listaDeSocio.get(i);
            if(socio.getSuscripcion().equals("destacada")){

                System.out.println("El nombre: "+socio.getNombre());
                System.out.println("El apellido: "+socio.getApellido());
                System.out.println("El dni: "+socio.getDni());
                System.out.println("La credencial: "+socio.getCredencial());
                System.out.println("la supcricion: "+socio.getSuscripcion());
            }
        }
    }
}
