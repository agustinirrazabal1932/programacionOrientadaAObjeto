package punto12;

import java.time.LocalDate;

public class Usuario {
	private String nombre;
	private String apellido;
	private String dni;
	private CuentaNormal cuenta;
	private CuentaCredito cuentaCredito;
	private CajaDeAhorro cajaDeAhorro;
	
	public Usuario(String nombre, String apellido, String dni, CuentaNormal cuenta, CuentaCredito cuentaCredito,CajaDeAhorro cajaDeAhorro) {
		this.cuenta = cuenta;
		this.cuentaCredito = cuentaCredito;
		this.cajaDeAhorro=cajaDeAhorro;
		setApellido(apellido);
		setDni(dni);
		setNombre(nombre);
	}

	public Usuario(String nombre, String apellido, String dni, CuentaNormal cuenta,CuentaCredito cuentaCredito) {
		this(nombre,apellido,dni,cuenta, cuentaCredito,null);
	}
	public Usuario(String nombre, String apellido, String dni, CuentaNormal cuenta) {
		this(nombre,apellido,dni,cuenta, null,null);
	}

	
	/**
	 * Muestra por consola el estado de su cuenta, imprime:
	 * 	a. El saldo
	 *  b. El limite de giro en descubierto y en parentesis el monto girado en descubierto.
	 *  c. El monto total invertido y entre parentesis el interes a ganar.
	 *  d. El monto disponible para compras a credito y la deuda total a pagar segun las compras.
	 */
	public void mostrarEstado() {
		System.out.println("-----------------------");
		System.out.println("Nombre y Apellido: "+getNombre()+" "+getApellido());
		System.out.println("Dni: "+getDni());
		System.out.println("Saldo: "+this.cuenta.getSaldo());
		System.out.println("Giro en descubierto: "+this.cuenta.getLimiteGiroDescubierto()+"("+this.cuenta.getGiroDescubierto()+")");
		System.out.println("Inversiones: "+this.cuenta.getMontoInvertido()+"("+this.cuenta.getInteresAGanar()+")");
		if (getCuentaCredito()!=null) {
			System.out.println("--- Cuenta crédito ----");
			System.out.println("");
			System.out.println("Disponible para compras: " + this.cuentaCredito.getMontoDisponibleParaCompras());
			System.out.println("Compras que deben: ");
			this.cuentaCredito.getMostarComprasNoPagadas();
			System.out.println("Saldo deudor: " + this.cuentaCredito.getSaldoDeudor());
		}else {
			System.out.println("No tiene habiliditada CuentaCredito");
		}
		if (getCajaDeAhorro()!=null){
			System.out.println("Nombre y Apellido: "+getNombre()+" "+getApellido());
			System.out.println("Dni: "+getDni());
			System.out.println("Saldo: "+this.cajaDeAhorro.getSaldo());
			System.out.println("Inversiones: "+this.cajaDeAhorro.getMontoInvertido()+"("+this.cajaDeAhorro.getInteresAGanar()+")");
		}else {
			System.out.println("No tiene habiliditada Cuenta caja de Ahorro");
		}
		System.out.println("-----------------------");
	}
	
	/**
	 * Intenta realizar un gasto sobre la cuenta. En caso de que el monto sea mayor al saldo, emite un mensaje que no se puede 
	 * realizar el gasto porque se va a girar en descubierto.
	 * @param monto
	 * @return
	 */
	public boolean realizarGasto(double monto) {
		if(monto > this.cuenta.getSaldo()) {
			System.out.println("No se puede realizar el gasto, se va a girar en descubierto..");
			return false;
		}else {
			return this.cuenta.comprar(monto);
		}
			
	}
	
	/**
	 * Intenta realizar un gasto sobre la cuenta por mas que se vaya a girar en descubierto
	 * @param monto
	 * @return
	 */
	public boolean realizarGastoYGirar(double monto) {
		return this.cuenta.comprar(monto);
	}
	public void activarPreCancelar(){
		this.cuenta.activarPreCancelar();
	}
	public void realizarPagoDeuda(double monto){
		this.cuenta.depositar(monto);
	}
	public boolean realizaInversion(double monto, LocalDate fechaInicio){
		return this.cuenta.invertir(monto,fechaInicio);
	}
	public boolean VerificarSiPuedoRetirar(LocalDate fechaRetiro){
		return this.cuenta.recuperarInversion(fechaRetiro);
	}

	
	// TODO de aca para abajo falta implementar todas las operaciones posibles sobre la cuenta credito.
	public boolean realizarGastoCuentaCredito(double monto) {
		boolean bandera=false;
		if (this.cuentaCredito!=null) {
			if (this.cuentaCredito.comprar(monto)) {
				System.out.println("la compra se hizo correctamente");
				bandera= true;
			} else {
				System.out.println("la compra no se puede hacer por que no hay espacio en el saldo");

			}
		}else {
			System.out.println("no tiene cuenta de credito");
		}
		return bandera;
	}
	public boolean realizarPago(double monto,int indiceCompra){
		boolean bandera=false;
		if (this.cuentaCredito!=null) {
			this.cuentaCredito.pagar(monto, indiceCompra);
			bandera=true;
		}
		else {
			System.out.println("no tiene cuenta de credito");
		}
		return bandera;
	}

	public boolean realizarCompraCaja(double monto){
		return this.cajaDeAhorro.comprar(monto);
	}
	public void realizarPagoCaja(double monto){
		this.cajaDeAhorro.depositar(monto);
	}
	public boolean realizarInversionCaja(double monto,LocalDate fechaI){
		return this.cajaDeAhorro.invertir(monto,fechaI);
	}
	public boolean verificarInversionCaja(LocalDate fechaRetiro){
		return this.cajaDeAhorro.recuperarInversion(fechaRetiro);
	}
	public void activarPrecancelarCaja(){
		this.cajaDeAhorro.activarPreCancelar();
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}
	public CuentaCredito getCuentaCredito(){
		return this.cuentaCredito;
	}

	public CajaDeAhorro getCajaDeAhorro() {
		return cajaDeAhorro;
	}

	public void setCajaDeAhorro(CajaDeAhorro cajaDeAhorro) {
		this.cajaDeAhorro = cajaDeAhorro;
	}

}
