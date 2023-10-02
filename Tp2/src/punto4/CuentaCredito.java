package punto4;

import java.util.ArrayList;
import java.util.List;

public class CuentaCredito {
	private double limite;
	private List<Double> compras;
	private List<Double> pagado;
	
	
	public CuentaCredito(double limite) {
		this.limite = limite;
		this.compras = new ArrayList<Double>();
		this.pagado = new ArrayList<Double>();
	}
	
	/**
	 * Registra una nueva compra en caso que todavía quede saldo disponible para compras. 
	 * 
	 * @param monto
	 * @return boolean: true si la compra fue existosa, false en caso contrario.
	 */
	public boolean comprar(double monto) {
		// TODO Implementar ..
		boolean compra=false;
		if (getMontoDisponibleParaCompras()>=monto){
			compras.add(monto);
			return compra=true;
		}
		return compra;
	}
	
	/**
	 * Realiza un pago sobre una compra. Si el monto es menor o igual al saldo que queda por pagar de la compra, el pago se registra 
	 * y la operacion es exitosa devolviendo true. 
	 * Si el monto es mayor al saldo, entonces la operación no se realiza devolviendo false.
	 * 
	 * @param monto: cantidad a pagar.
	 * @param indiceCompra: el numero de indice de la compra sobre la cual se requiere realizar un pago.
	 * @return
	 */
	public boolean pagar(double monto, int indiceCompra) {
		// TODO implementar ...
		boolean pago=false;
		if (monto<=this.compras.get(indiceCompra)){
			double montoApagar=this.compras.get(indiceCompra);
			montoApagar-=monto;
			if (montoApagar==0){
				this.compras.remove(indiceCompra);
				this.pagado.add(monto);

			}
			else {
				this.compras.set(indiceCompra,montoApagar);
				this.pagado.add(monto);
			}
			return pago=true;
		}else {
			System.out.println("el monto es mayor a la compra, no se puede realizar la compra");
		}
		return pago;
	}
	
	/**
	 * Retorna el saldo que queda por pagar de una compra, incluyendo el interes.
	 * 
	 * @param indiceCompra
	 * @return
	 */
	public double getSaldoDeudorCompra(int indiceCompra) {
		// TODO falta implementar ..
		double monto;
		monto=compras.get(indiceCompra);
		return monto;
	}
	
	/**
	 * Devuelve el saldo deudor total teniendo en cuenta todas las compras impagas.
	 * @return double
	 */
	public double getSaldoDeudor() {
		// TODO falta implementar...
		double monto=0;
		for (int i = 0; i <compras.size() ; i++) {
			monto+=compras.get(i);
		}

		return monto;
	}
	
	/**
	 * Devuelve el monto disponible para compras de la cuenta teniendo en cuenta todas las compras
	 * realizadas que quedan por pagar, sin tener en cuenta las que deben solo el interes.
	 * @return double: el saldo disponible para realizar compras.
	 */
	public double getMontoDisponibleParaCompras() {
		// TODO falta implementar ...
		double monto=0;
		for (int i = 0; i < compras.size(); i++) {
			monto+=compras.get(i);
		}

		double total;
		total = this.limite-monto;

		return total;
	}
	public void getMostarComprasNoPagadas(){
		for (int i = 0; i < compras.size(); i++) {
			System.out.println("indice: "+i+", valor: "+compras.get(i));
		}
	}
	
}
