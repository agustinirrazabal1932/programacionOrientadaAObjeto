package punto4;
import java.time.LocalDate;
public class Cuenta {
	private double saldo;
	private double limiteGiroDescubierto;
	private double giroDescubierto;
	private double saldoInvertido;
	private boolean preCancelar;
	public static final double INTERES_POR_INVERSION = 0.4;
	public static final int PLAZO_DIAS_INVERSION = 30;
	private LocalDate fechaInversion;

	public Cuenta(double saldo, double limiteGiroDescubierto) {
		this.saldo = saldo;
		this.limiteGiroDescubierto = limiteGiroDescubierto;
		this.giroDescubierto = 0;
		this.saldoInvertido = 0;
		this.fechaInversion = null;
		this.preCancelar=false;
	}
	
	/**
	 * Dado un monto genera un gasto en la cuenta: quita del saldo el monto a gastar, si el monto es mayor
	 * al saldo entonces gira en descubierto (siempre y cuando todavía quede límite). 
	 * Si (saldo + limite descubierto disponible) < monto, entonces la operacion no se realiza y devuelve false.
	 * @param monto: el monto a gastar
	 * @return boolean: indica si la operación fué exitosa.
	 */
	
	public boolean gastar(double monto) {
		boolean res = false;
		LocalDate dia15=getFechaInversion().plusDays(15);
		
		if ((this.saldo + (this.limiteGiroDescubierto-this.giroDescubierto)) >= monto) {
			if (this.saldo < monto) {
				//Ver si esta activo el precancelar.
				if (isPreCancelar() && getSaldoInvertido() > 0 && (dia15.isEqual(LocalDate.now()) || dia15.isBefore(LocalDate.now())) ) {
					//Giro en descubierto
					double invertir=(getSaldoInvertido()*0.5)+getSaldoInvertido();
					this.saldo+=invertir;
					this.saldoInvertido=0;
					this.fechaInversion=null;
					//revisa si el monto es mayor al saldo
					if (monto>this.saldo) {
						this.giroDescubierto += monto - this.saldo;
						this.saldo = 0;
					}
					else {
						this.saldo-=monto;
					}
				}else{
					this.giroDescubierto += monto - this.saldo;
					this.saldo = 0;
				}
			}else {
				// El saldo me alzanza para el gasto
				this.saldo -= monto;
			}
			res = true;
		}
		
		return res;
	}
	
	/**
	 * Deposita el monto en la cuenta. Si existe giro en descubierto, primero intenta cubrirlo y si queda 
	 * dinero disponible aumenta el saldo.
	 * @param monto
	 */
	public void depositar(double monto) {
		// TODO Implementar....
		if (getGiroDescubierto()>0){
			if (getGiroDescubierto()<=monto){
				monto-=this.giroDescubierto;
				this.giroDescubierto=0;
				this.saldo+=monto;
			} else{
				this.giroDescubierto-=monto;
			}
		}
		else{
			this.saldo+=monto;
		}
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
		// TODO Implementar
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

	public double getGiroDescubierto() {
		return this.giroDescubierto;
	}
	
	public double getLimiteGiroDescubierto() {
		return this.limiteGiroDescubierto;
	}
	
	public double getMontoInvertido() {
		return this.saldoInvertido;
	}
	
	public double getInteresAGanar() {
		if (this.fechaInversion != null)
			return this.saldoInvertido * Cuenta.INTERES_POR_INVERSION;
		return 0.0d;
	}

	public boolean isPreCancelar() {
		return preCancelar;
	}

	public void setPreCancelar(boolean preCancelar) {
		this.preCancelar = preCancelar;
	}
}
