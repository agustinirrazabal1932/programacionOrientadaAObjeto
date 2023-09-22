import punto1.ClubFutbol;
import punto1.Socio;
import punto2.SunBeach;
import punto3.Academia;
import punto8.Biblioteca;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {


        boolean bandera=true;
        Scanner sc= new Scanner(System.in);
        int opcion;
        while (bandera){
            System.out.println("Bienvenido al TP2");
            System.out.println("1. Punto 1");
            System.out.println("2. Punto 2");
            System.out.println("3. Punto 3");
            opcion= sc.nextInt();
            if (opcion==1){
                String nombre="agustin";
                String apellido="irrazabal";
                String correo="agustinirrazabal@gmail.com";
                String direccion="venancio flores 1932";
                int edad=21;
                String dni="44110829";
                String supcripcion="destacada";
                LocalDate fecha = LocalDate.of(2023,8,10);
                ClubFutbol clubBariloche= new ClubFutbol();
                clubBariloche.agregarYCrearSocio(nombre,apellido,correo,direccion,dni,edad,supcripcion,fecha);
                nombre="felipe";
                apellido="pataleo";
                correo="felipataleo@gmail.com";
                direccion="figueroa 220";
                edad=19;
                dni="45632721";
                supcripcion="basica";
                fecha=LocalDate.of(2023,8,25);
                clubBariloche.agregarYCrearSocio(nombre,apellido,correo,direccion,dni,edad,supcripcion,fecha);
                nombre="flabia";
                apellido="pescio";
                correo="flabiapes@gmail.com";
                direccion="ssan martin 1700";
                edad=30;
                dni="29150766";
                supcripcion="intermedia";
                fecha=LocalDate.of(2023,8,17);
                clubBariloche.agregarYCrearSocio(nombre,apellido,correo,direccion,dni,edad,supcripcion,fecha);
                nombre="micaela";
                apellido="martinez";
                correo="micamartinez@gmail.com";
                direccion="alberti 669";
                edad=26;
                dni="30803654";
                supcripcion="intermedia";
                fecha=LocalDate.of(2023,2,6);
                clubBariloche.agregarYCrearSocio(nombre,apellido,correo,direccion,dni,edad,supcripcion,fecha);
                clubBariloche.mostrarSociosDelUltimoMes();

                String titulo="entrada a la cancha de futbol 7";
                String tipoDeActividad="intermedia";
                clubBariloche.agregarYCrearActividad(titulo,tipoDeActividad);
                titulo="entrada al gimnasio";
                tipoDeActividad="destacada";
                clubBariloche.agregarYCrearActividad(titulo,tipoDeActividad);
                titulo="entrada al establecimiento";
                tipoDeActividad="basica";
                clubBariloche.agregarYCrearActividad(titulo,tipoDeActividad);
                titulo="entrada al estacionamiento privado";
                tipoDeActividad="intermedia";
                clubBariloche.agregarYCrearActividad(titulo,tipoDeActividad);
                titulo="entrada al estadio";
                tipoDeActividad="destacada";
                clubBariloche.agregarYCrearActividad(titulo,tipoDeActividad);
                clubBariloche.mostrarActividadesEnOrden();
                clubBariloche.mostrarSociosEnOrden();


            } else if (opcion==2) {
                //carga de provedores y paquetes

                String nombreEmpresa="Fabebus";
                String clasificion="medioTransporte";
                String descripcion="medios de transporte terrestre que pueden viajar a todo americca del sur.";
                SunBeach administracionSunBeach = new SunBeach();
                administracionSunBeach.agregarProvedores(nombreEmpresa,clasificion,descripcion);
                nombreEmpresa="Hoteles Medellin.";
                clasificion="hospedaje";
                descripcion="hosteles en toda la ciudad de medellin";
                administracionSunBeach.agregarProvedores(nombreEmpresa,clasificion,descripcion);
                nombreEmpresa="excursiones Colombia";
                clasificion="excursion";
                descripcion="Medellin ,tour por los monumentos ";
                administracionSunBeach.agregarProvedores(nombreEmpresa,clasificion,descripcion);
                administracionSunBeach.agregarDestino("Medellin");
                nombreEmpresa="aerolineas Argentina";
                clasificion="medioTransporte";
                descripcion="viajes a toda europa, con por lo menos 1 esscala";
                administracionSunBeach.agregarProvedores(nombreEmpresa,clasificion,descripcion);
                nombreEmpresa="Hôtels en France";
                clasificion="hospedaje";
                descripcion="hoteles en todo el pais de francia";
                administracionSunBeach.agregarProvedores(nombreEmpresa,clasificion,descripcion);
                nombreEmpresa="Museo de francia";
                clasificion="excursion";
                descripcion="Paris,recorrrido guiados por algunos de los museos mas importante de francia";
                administracionSunBeach.agregarProvedores(nombreEmpresa,clasificion,descripcion);
                nombreEmpresa="Museo de francia";
                clasificion="excursion";
                descripcion="Paris, viaje y entrada a la torre ifel";
                administracionSunBeach.agregarProvedores(nombreEmpresa,clasificion,descripcion);
                administracionSunBeach.agregarDestino("Paris");
                administracionSunBeach.mostrarPaquetes();

                //carga de clientes y pedidos
                String nombre ="josefina";
                String apellido="perez";
                String dni="29357084";
                int nro=1;
                LocalDate fechaDeCompra= LocalDate.of(2023,8,5);
                administracionSunBeach.agregarClienteYsuCompra(nombre,apellido,dni,fechaDeCompra,nro);
                nombre="micaela";
                apellido="coronado";
                dni="35987013";
                nro=2;
                fechaDeCompra=LocalDate.of(2023,9,2);
                administracionSunBeach.agregarClienteYsuCompra(nombre,apellido,dni,fechaDeCompra,nro);
                nombre="joel";
                apellido="lopez";
                dni="37852654";
                nro=1;
                fechaDeCompra=LocalDate.of(2023,8,30);
                administracionSunBeach.agregarClienteYsuCompra(nombre,apellido,dni,fechaDeCompra,nro);
                nombre="marcelo";
                apellido="brittos";
                dni="12682197";
                nro=2;
                fechaDeCompra=LocalDate.of(2023,9,2);
                administracionSunBeach.agregarClienteYsuCompra(nombre,apellido,dni,fechaDeCompra,nro);
                nombre="joel";
                apellido="lopez";
                dni="37852654";
                nro=1;
                fechaDeCompra=LocalDate.of(2023,8,20);

                
                administracionSunBeach.agregarClienteYsuCompra(nombre,apellido,dni,fechaDeCompra,nro);
                administracionSunBeach.mostrarComprasDeCliente();
                administracionSunBeach.informeDeFinDeMes();
                administracionSunBeach.mostrarDestinoFavorito();

            } else if (opcion==3) {
                Academia academiaDanza= new Academia();
                //cargar profe
                String nombre="ricardo";
                String apellido="montaner";
                String dni="21654852";
                academiaDanza.cargarProfesor(nombre,apellido,dni);

                nombre="juan";
                apellido="castro";
                dni="20179623";
                academiaDanza.cargarProfesor(nombre,apellido,dni);

                //cargar de clases
                String diciplina="tango";
                String nivel="intermedio";
                String dia="miercoles";
                LocalTime horaIni=LocalTime.of(19,0);
                LocalTime horaFin=LocalTime.of(21,0);
                academiaDanza.cargarClase("21654852",diciplina,nivel,dia,horaIni,horaFin);
                diciplina="bachata";
                nivel="basico";
                dia="jueves";
                horaIni=LocalTime.of(17,0);
                horaFin=LocalTime.of(19,0);
                academiaDanza.cargarClase("20179623",diciplina,nivel,dia,horaIni,horaFin);
                diciplina="regueton";
                nivel="avanzado";
                dia="viernes";
                horaIni=LocalTime.of(15,0);
                horaFin=LocalTime.of(17,0);
                academiaDanza.cargarClase("20179630",diciplina,nivel,dia,horaIni,horaFin);
                // carga de alumnos y devuelve la credencial.

                int alumnoJuan=academiaDanza.cargarAlumnos("juan","fernandez","36951753","011894136","bachata","basico");
                int alumnoSofia=academiaDanza.cargarAlumnos("sofia","scarnatto","32451963","2323204599","tango","intermedio");
                int alumnoPablo=academiaDanza.cargarAlumnos("pablo","silva","55679414","2323458810","bachata","basico");

                //ver asistencia
                boolean bander=true;
                LocalDate fechaHoy=LocalDate.now();
                LocalDate fechaDeUnMes=fechaHoy.minusMonths(1);
                System.out.println("fecha de un mes: "+fechaDeUnMes);
                //simular un mes dedanza
                while (bander){
                    dia= String.valueOf(fechaDeUnMes.getDayOfWeek());
                    academiaDanza.registrarAsistencia(alumnoJuan,"bachata","basico",dia);
                    academiaDanza.registrarAsistencia(alumnoSofia,"tango","intermedio",dia);
                    academiaDanza.registrarAsistencia(alumnoPablo,"bachata","basico",dia);
                    if (fechaDeUnMes.isEqual(fechaHoy)){
                        bander=false;
                    }
                    fechaDeUnMes=fechaDeUnMes.plusDays(1);
                }
                int salarioBachata=academiaDanza.pasarListadoYSalario("20179623");
                System.out.println(salarioBachata);
                academiaDanza.disciplinaQueMayorReditua();

            } else if (opcion==4) {

            }else if (opcion==5){
                System.out.println("el punto 5 esta implementado en el 4");
            }else if (opcion==6){

            }else if (opcion==7){
                System.out.println("el punto 7 esta immplementado en el 6");
            }else if (opcion==8){
                Biblioteca biblioteca=new Biblioteca();
                //cargar de libros a la biblioteca
                biblioteca.cargarLibro("frankesteer","100 cuentos","2323665812",24,1900);
                biblioteca.cargarLibro("pinocho","disney","011457863",55,1930);
                biblioteca.cargarLibro("frankesteer","100 cuentos","2323665812",99,1900);
                biblioteca.cargarLibro("la sirenita","disney","011457863",33,1920);

            }else if (opcion==9){

            }

        }
    }
}
