package punto3;



import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;

public class Horario {
    private ArrayList<String> dias = new ArrayList<String>();
    private ArrayList<LocalTime> horasInicio = new ArrayList<LocalTime>();
    private ArrayList<LocalTime> horasFinal= new ArrayList<LocalTime>();

    public void agregarHorario(String dia,LocalTime horaInicio,LocalTime horaFinal){
        if (dia=="lunes"){
            dia="MONDAY";
            dias.add(dia);
            horasInicio.add(horaInicio);
            horasFinal.add(horaFinal);
        } else if (dia=="martes") {
            dia="TUESDAY";
            dias.add(dia);
            horasInicio.add(horaInicio);
            horasFinal.add(horaFinal);
        } else if (dia=="miercoles") {
            dia="WEDNESDAY";
            dias.add(dia);
            horasInicio.add(horaInicio);
            horasFinal.add(horaFinal);

        } else if (dia=="jueves") {
            dia="THURSDAY";
            dias.add(dia);
            horasInicio.add(horaInicio);
            horasFinal.add(horaFinal);

        } else if (dia=="viernes") {
            dia="FRIDAY";
            dias.add(dia);
            horasInicio.add(horaInicio);
            horasFinal.add(horaFinal);

        }
    }
    public boolean validarDia(String dia){
        boolean bandera=false;
        for (int i = 0; i <dias.size() ; i++) {
            String diaActual=dias.get(i);
            if (diaActual==dia){
                bandera=true;
            }
        }
        return bandera;
    }
}
