import punto1.ClubFutbol;
import punto1.Socio;
import punto10.appEmpleados;
import punto11.SistemaAgenciaDeAuto;
import punto2.SunBeach;
import punto3.Academia;
import punto4.SistemaBilletera;
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
            System.out.println("8. Punto 8");
            System.out.println("9. Punto 9");
            System.out.println("10. Punto 10");
            System.out.println("11. punto 11");
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
                SistemaBilletera appVirtual=new SistemaBilletera();
                //cargo usuarios
                String clienteJuan=appVirtual.agregarClienteConCuenta("juan","fernandez","36951753");
                String clienteSofia=appVirtual.agregarClienteConCuentaYCuentaCredito("sofia","scarnatto","32451963");
                //ver cuenta
                appVirtual.VerLasCuentasUsuario(clienteJuan);
                appVirtual.VerLasCuentasUsuario(clienteSofia);
                //ingresar saldo;
                appVirtual.realizarPagoCuenta(clienteJuan,22000d);
                appVirtual.realizarPagoCuenta(clienteSofia,8000d);
                //algunas compras
                appVirtual.realizarCompraCuenta(clienteJuan,15800.50d);
                appVirtual.realizarCompraCuentaCredito(clienteSofia,18500.50d);
                appVirtual.realizarCompraCuentaCredito(clienteSofia,30000);
                //invertir
                appVirtual.realizarInversionCuenta(clienteJuan,5000d,LocalDate.of(2023,9,2));
                //ver cuenta
                appVirtual.VerLasCuentasUsuario(clienteJuan);
                appVirtual.VerLasCuentasUsuario(clienteSofia);
                //pagar y ver inversiones
                appVirtual.realizarPagoCuenta(clienteJuan,15000d);
                appVirtual.realizarPagoCuentaCredito(clienteSofia,10000d,1);
                appVirtual.realizarVerificacionInversionCuenta(clienteJuan,LocalDate.now());
                //comprar conmigo
                appVirtual.realizarCompraCuenta(clienteJuan,30000);




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
                biblioteca.cargarDiario("1000 noches","Bcc","011986563",15,6,1980);
                biblioteca.cargarLibro("frankesteer","100 cuentos","2323665812",101,1900);
                biblioteca.cargarRevista("Ole","La Nacion","2323780139",144,1980);
                biblioteca.cargarLibro("la sirenita","disney","011457863",66,1920);
                biblioteca.cargarTesis("La anarquia","tesis Argentina","2323647002","Juan","Fernandez",4,2011);


                biblioteca.cargarAutorLibro("pinocho","disney","Facundo","Gallardo");
                biblioteca.cargarAutorLibro("frankesteer","100 cuentos","Fernando","Gil");
                biblioteca.cargarAutorLibro("la sirenita","disney","Florencia","Guzman");
                //carga de socios
                int idDeAgustin=biblioteca.cargarSocio("agustin","irrazabal","2323648602");
                int idDeSol=biblioteca.cargarSocio("sol","martinez","2323556147");
                //el problema

                int librosDeFrankester=biblioteca.cantEjemplarLibro("frankesteer","100 cuentos");
                System.out.println("la caantidad de libros de frankester es de: "+librosDeFrankester);
                biblioteca.prestarLibro(idDeSol,"la sirenita","disney");
                biblioteca.prestarLibro(idDeAgustin,"frankesteer","100 cuentos");
                biblioteca.verLibrosPrestados();
                librosDeFrankester=biblioteca.cantEjemplarLibro("frankesteer","100 cuentos");
                System.out.println("la caantidad de libros de frankester es de: "+librosDeFrankester);

            }else if (opcion==9){

            } else if (opcion==10) {
                appEmpleados app=new appEmpleados();
                //carga de empleados
                LocalDate fechaCumpleaños=LocalDate.of(2000,8,14);
                String cuilJorge= app.cargarEmpleadoAsalariado("jorge","pataleo","2323914670","20400198750",fechaCumpleaños);
                fechaCumpleaños=LocalDate.of(1998,9,20);
                String cuilJuan= app.cargarEmpleadoPorComision("juan","rodriguez","2323664410","20398461530",fechaCumpleaños);
                String cuilFacu= app.cargarEmpleadoPorComisionConSalario("facundo","perez","2323054809","20359637410",fechaCumpleaños);
                fechaCumpleaños=LocalDate.of(1980,7,1);
                String cuilSeba=app.cargarEmpleadoPorHora("sebastian","ortiz","2323107820","20405566870",fechaCumpleaños);

                //cargar las ventas del fin de mes y el monto del salario
                float mes= 280350.23F;
                app.FinDeMesEmpleadoAsalariado(cuilJorge,mes);
                app.FinDeMesEmpleadoPorComision(cuilJuan,23,150,50);
                app.FinDeMesEmpleadoPorComisionConSalario(cuilFacu,35,190000,60,180);
                app.FinDeMesEmpleadoPorHora(cuilSeba,20,1200);

                //ver los sueldo;
                app.mostraSueldos();
            } else if (opcion==11) {
                SistemaAgenciaDeAuto sistemaAgenciaDeAuto=new SistemaAgenciaDeAuto();
                //carga de autos
                sistemaAgenciaDeAuto.cargarAutoCombi("AJP624",4500);
                sistemaAgenciaDeAuto.cargarAutoPasajero("JHI123",false,4);
                sistemaAgenciaDeAuto.cargarAutoPasajero("POO004",true,2);
                sistemaAgenciaDeAuto.cargarCamionetaFlete("VNT",110,600);
                sistemaAgenciaDeAuto.cargarCamion("JJL951",100000);
                sistemaAgenciaDeAuto.cargarAutoPasajero("RIV912",false,5);
                //carga de clientes
                String clienteJuan=sistemaAgenciaDeAuto.cargarCliente("juan","fernandez","36951753");
                String clienteSofia=sistemaAgenciaDeAuto.cargarCliente("sofia","scarnatto","32451963");
                //pedir Presupuesto
                LocalDate fechaInicio=LocalDate.of(2023,10,1);
                LocalDate fechaFinal=LocalDate.of(2023,10,7);
                int presupuestoJuan1=sistemaAgenciaDeAuto.hacerPresupuesto("JHI123",clienteJuan,fechaInicio,fechaFinal);
                int presupuestoSofia1=sistemaAgenciaDeAuto.hacerPresupuesto("VNT",clienteSofia,fechaInicio,fechaFinal);
                int presupuestoSofia2=sistemaAgenciaDeAuto.hacerPresupuesto("AJP624",clienteSofia,fechaInicio,fechaFinal);
                //confirmar Presupuesto
                sistemaAgenciaDeAuto.confirmarPresupuesto(clienteJuan,presupuestoJuan1);
                sistemaAgenciaDeAuto.confirmarPresupuesto(clienteSofia,presupuestoSofia1);
                sistemaAgenciaDeAuto.confirmarPresupuesto(clienteSofia,presupuestoSofia2);
//                //ver Alquileres
                sistemaAgenciaDeAuto.mostrarAlquileresDeUnCliente(clienteSofia);
                sistemaAgenciaDeAuto.verMontoDelSistema();
            } else if (opcion==12) {

            } else if (opcion==13) {

            } else if (opcion==14) {

            } else if (opcion==0) {
                bandera=false;
                System.out.println("salio del menu. Hasta luego");
            }

        }
    }
}
