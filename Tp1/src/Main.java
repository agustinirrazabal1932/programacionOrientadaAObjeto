import ar.edu.unlu.punto12.AdministradorTareas;
import ar.edu.unlu.punto5.ListaDeTarea;
import ar.edu.unlu.punto4.Cola;
import ar.edu.unlu.punto11.Juego;
import ar.edu.unlu.punto11.Jugador;
import ar.edu.unlu.punto6.Bliblioteca;
import ar.edu.unlu.punto7.Calculo;
import ar.edu.unlu.punto8.Contraseña;
import ar.edu.unlu.punto9.Fecha;
import ar.edu.unlu.punto1.ListaEnlazadaSimple;

import java.time.LocalDate;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean bandera = true;
        while (bandera) {
            System.out.println("---Bienvenido al tp1---");
            System.out.println("punto 1");
            System.out.println("punto 2");
            System.out.println("punto 3");
            System.out.println("punto 4");
            System.out.println("punto 5");
            System.out.println("punto 6");
            System.out.println("punto 7");
            System.out.println("punto 8");
            System.out.println("punto 9");
            System.out.println("punto 10");
            System.out.println("punto 11");
            System.out.println("punto 12");
            System.out.println("punto 13");
            System.out.println("que opcion desea: ");
            System.out.println("ingrese 0 para salir del programa.");
            Scanner opcion = new Scanner(System.in);
            int opcionNumero= opcion.nextInt();
            if (opcionNumero==1){
                ListaEnlazadaSimple lista= new ListaEnlazadaSimple();
                lista.agregar("agus");
                lista.agregar("hola");
                lista.agregar("agus");
                lista.agregar("emanuel");
                lista.agregar("agus");
                lista.agregar("primera lista");
                lista.agregar("agus");
                System.out.println(lista);
                int largo=lista.longitud();
                System.out.println(largo);
                lista.eliminar("agus");
                System.out.println(lista);
                lista.insertar("pp",3);
                System.out.println(lista);
            } 
            else if (opcionNumero==2) {
                
            } 
            else if (opcionNumero==3) {
                
            } 
            else if (opcionNumero==4) {
                Cola nuevaCola = new Cola();
                nuevaCola.agregar("agus");
                nuevaCola.agregar("emanuel");
                nuevaCola.agregar("bienvenido");
                nuevaCola.agregar("a programacion");
                nuevaCola.agregar("orientada a objeto");
                System.out.println(nuevaCola);
                Object pp=nuevaCola.desencolar();
                System.out.println(pp);
                Object fin=nuevaCola.verFinal();
                Object inicio=nuevaCola.verPrincipio();
                System.out.println("fin de la cola: "+fin);
                System.out.println("inicio de la cola: "+inicio);
                System.out.println(nuevaCola);
            } else if (opcionNumero==5) {

                ListaDeTarea lt= new ListaDeTarea();
                String decripcion="Ir al supermercado mañana.";
                String estado="incompleta";
                LocalDate fecha= LocalDate.of(2023,10,12);
                LocalDate fechaRecordatorio= LocalDate.of(2023,8,12);
                lt.agregarTarea(decripcion,estado,fecha,fechaRecordatorio);
                decripcion="Consultar repuestos del auto";
                estado="completa";
                fecha= LocalDate.now();
                fecha= fecha.minusDays(1);
                fechaRecordatorio= LocalDate.of(2023,7,20);
                lt.agregarTarea(decripcion,estado,fecha,fechaRecordatorio);
                decripcion="Ir al cine a ver la nueva película de Marvel";
                estado="incompleta";
                fecha= LocalDate.now();
                fecha= fecha.minusDays(1);
                fechaRecordatorio= LocalDate.of(2023,5,10);
                lt.agregarTarea(decripcion,estado,fecha,fechaRecordatorio);
                lt.mostarListaDeTarea();
                lt.editarDescripcion("hacer la tarea de prog",1);
                decripcion="Futbol a las 20hs";
                estado="incompleta";
                fecha= LocalDate.of(2023,10,17);
                fechaRecordatorio= LocalDate.now();
                lt.agregarTarea(decripcion,estado,fecha,fechaRecordatorio);
                lt.mostarListaDeTarea();
                lt.borrarTarea(3);
                lt.mostarListaDeTarea();
            } else if (opcionNumero==6) {

                Bliblioteca biblio= new Bliblioteca();
                String autor= "agusgim.";
                Object nombre= "stoper y sus desgracias";
                int cantH= 222;
                int cantD=10;
                biblio.agregarLibro(autor,nombre,cantH,cantD);
                autor= "destru";
                nombre= "el fifa y mis enojos";
                cantH= 100;
                cantD=1;
                biblio.agregarLibro(autor,nombre,cantH,cantD);
                autor= "marcelo";
                nombre= "La carpinteria";
                cantH= 340;
                cantD=4;
                biblio.agregarLibro(autor,nombre,cantH,cantD);
                autor= "Nicoarg";
                nombre= "mi vida, twich";
                cantH= 500;
                cantD=10;
                biblio.agregarLibro(autor,nombre,cantH,cantD);
                biblio.prestarLibro(1);
                biblio.prestarLibro(2);
                biblio.verLibros();
                biblio.calcularPaginas(1,2);
                biblio.librosPrestadosEnTotal();
            } else if (opcionNumero==7) {

                Calculo formulaResolvente = new Calculo();
                formulaResolvente.agregarCalculo(1,6,5);
                formulaResolvente.solucion();
            } else if (opcionNumero==8) {

                Contraseña contra = new Contraseña();
                for (int i=0; i<5;i++) {
                    contra.generarContraseñaFuerte(10);
                }
            } else if (opcionNumero==9) {

                Fecha fecha1 = new Fecha();
                Fecha fecha2 = new Fecha();
                Scanner sc = new Scanner(System.in);
                for (int i=1;i<3;i++){
                    System.out.println("pasame el dia para la fecha "+i+": ");
                    int dia=sc.nextInt();
                    System.out.println("pasame el mes para la fecha "+i+": ");
                    int mes=sc.nextInt();
                    System.out.println("pasame el año para la fecha "+i+": ");
                    int año=sc.nextInt();
                    if (i == 1) {
                        fecha1.agregarFecha(dia,mes,año);
                    }
                    else{
                        fecha2.agregarFecha(dia,mes,año);
                    }
                }
                fecha1.esMayorLaFecha(fecha2);
            } else if (opcionNumero==10) {
                System.out.println("esta implementado en el punto 5.");

            } else if (opcionNumero==11) {

                Jugador agus = new Jugador();
                Jugador feli = new Jugador();
                Juego juego = new Juego();
                agus.agregarJugador("agustin");
                feli.agregarJugador("felipe");
                juego.iniciarJuego(agus);
                juego.iniciarJuego(feli);
                System.out.println(agus);
                System.out.println(feli);
                agus.quienTieneMasPuntos(feli);
            } else if (opcionNumero==12) {
                AdministradorTareas administador=new AdministradorTareas();
                String decripcion="limpiar la consola";
                String estado="incompleta";
                LocalDate fecha= LocalDate.of(2023,9,8);
                String prioridad="urgente";
                administador.crearYAgregarTarea(decripcion,estado,fecha,prioridad);
                decripcion="armar un avion de papel";
                estado="incompleta";
                fecha= LocalDate.of(2023,9,20);
                prioridad="irrelevante";
                administador.crearYAgregarTarea(decripcion,estado,fecha,prioridad);
                decripcion="revisar la PC";
                estado="incompleta";
                fecha= LocalDate.of(2023,9,10);
                prioridad="urgente";
                administador.crearYAgregarTarea(decripcion,estado,fecha,prioridad);
                decripcion="pasear al perro";
                estado="incompleta";
                fecha= LocalDate.of(2023,9,11);
                prioridad="normal";
                administador.crearYAgregarTarea(decripcion,estado,fecha,prioridad);
                decripcion="jugar a la pelota";
                estado="incompleta";
                fecha= LocalDate.of(2023,9,12);
                prioridad="urgente";
                administador.crearYAgregarTarea(decripcion,estado,fecha,prioridad);
                decripcion="sacar la basura";
                estado="incompleta";
                fecha= LocalDate.of(2023,9,7);
                prioridad="normal";
                administador.crearYAgregarTarea(decripcion,estado,fecha,prioridad);
                decripcion="ordenar la habitacion";
                estado="incompleta";
                fecha= LocalDate.of(2023,9,3);
                prioridad="normal";
                administador.crearYAgregarTarea(decripcion,estado,fecha,prioridad);
                administador.mostarListaDeTarea();
                boolean estaLaTarea;
                estaLaTarea=administador.BuscarPorTitulo("limpiar la consola");
                if (estaLaTarea){
                    administador.marcarTareaComoHecha("limpiar la consola");
                }
            } else if (opcionNumero==13) {

            } else if (opcionNumero==0) {
                bandera=false;
                System.out.println("fin del programa.");
            }
            else {
                System.out.println("no ingreso un numero correcto");
            }
        }
    }
}
