package punto12;

import java.time.LocalDate;

public class CajaDeAhorro extends Cuenta{
    private double saldo;
    private double saldoInvertido;
    private boolean preCancelar;
    public static final double INTERES_POR_INVERSION = 0.4;
    public static final int PLAZO_DIAS_INVERSION = 30;
    private LocalDate fechaInversion;

    public CajaDeAhorro(double saldo) {
        this.saldo = saldo;
        this.saldoInvertido = 0;
        this.fechaInversion = null;
        this.preCancelar=false;
    }

    @Override
    public boolean comprar(double monto) {
        boolean res = false;
        LocalDate dia15=getFechaInversion().plusDays(15);

        if (this.saldo < monto){
                //Ver si esta activo el precancelar.
                if (isPreCancelar() && getSaldoInvertido() > 0 && (dia15.isEqual(LocalDate.now()) || dia15.isBefore(LocalDate.now())) ) {
                    //Giro en descubierto
                    double invertir=(getSaldoInvertido()*0.5)+getSaldoInvertido();
                    this.saldo+=invertir;
                    this.saldoInvertido=0;
                    this.fechaInversion=null;
                    //revisa si el monto es mayor al saldo
                    if (monto>this.saldo) {
                        System.out.println("el monto es mayor a el saldo mas el interes precancelado.");
                    }
                    else {
                        this.saldo-=monto;
                        res = true;
                    }
                }
        }else {
            this.saldo -= monto;
            res = true;
        }

        return res;
    }


    public void depositar(double monto) {
        this.saldo+=monto;
        System.out.println("el monto se ingreso correctamente");
    }

    /**
     * Realiza la inversion del monto indicado. Condiciones para que la operación sea exitosa:
     * 	a. Que el saldo sea >= monto
     *  b. Que no exista una inversión activa.
     *
     * Tambien establece la fecha de inversión.
     *
     * @param monto
     * @return
     */
    public boolean invertir(double monto,LocalDate fechaInversion) {
        // TODO Implementar ...
        boolean invertir=false;
        if (this.saldo>=monto){
            if (this.saldoInvertido==0 && this.fechaInversion==null){
                this.saldo-=monto;
                this.saldoInvertido=monto;
                this.fechaInversion=fechaInversion;
                return invertir=true;
            }
            else {
                System.out.println("tiene una inversion en curso");
            }
        }else {
            System.out.println("el monto que desea invertir es mayor al que posee en su saldo");
        }
        return invertir;
    }

    /**
     * Devuelve el monto invertido al saldo con el interes establecido. Se puede realizar siempre y cuando
     * hayan pasado los N días que dura la inversión.
     * @return
     */
    public boolean recuperarInversion(LocalDate fechaRetiro) {
        boolean invertir=false;
        double monto=0;
        if (this.saldoInvertido != 0){
            LocalDate fechaDespuesDePlazoDeInverison;
            fechaDespuesDePlazoDeInverison=getFechaInversion();
            fechaDespuesDePlazoDeInverison.plusDays(this.PLAZO_DIAS_INVERSION);
            if (fechaDespuesDePlazoDeInverison.isEqual(fechaRetiro) || fechaDespuesDePlazoDeInverison.isBefore(fechaRetiro)){
                monto= (getSaldoInvertido()*INTERES_POR_INVERSION) + getSaldoInvertido();
                this.saldo+=monto;
                this.saldoInvertido=0;
                this.fechaInversion=null;
                invertir=true;
            }
        }
        return invertir;
    }
    public void activarPreCancelar(){
        if (!isPreCancelar()) {
            setPreCancelar(true);
            System.out.println("se activo el preCancelar");
        }
    }

    public double getSaldo() {
        return this.saldo;
    }

    public LocalDate getFechaInversion() {
        return fechaInversion;
    }

    public double getSaldoInvertido() {
        return saldoInvertido;
    }


    public double getMontoInvertido() {
        return this.saldoInvertido;
    }

    public double getInteresAGanar() {
        if (this.fechaInversion != null)
            return this.saldoInvertido * punto4.Cuenta.INTERES_POR_INVERSION;
        return 0.0d;
    }

    public boolean isPreCancelar() {
        return preCancelar;
    }

    public void setPreCancelar(boolean preCancelar) {
        this.preCancelar = preCancelar;
    }
}

