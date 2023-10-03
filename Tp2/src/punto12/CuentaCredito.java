package punto12;

import java.util.ArrayList;
import java.util.List;

public class CuentaCredito extends Cuenta {
    private double limite;
    private List<Double> compras;
    private List<Double> pagado;


    public CuentaCredito(double limite) {
        this.limite = limite;
        this.compras = new ArrayList<Double>();
        this.pagado = new ArrayList<Double>();
    }

    @Override
    public boolean comprar(double monto) {
        boolean compra=false;
        if (getMontoDisponibleParaCompras()>=monto){
            compras.add(monto);
            return compra=true;
        }
        return compra;

    }

    public boolean pagar(double monto, int indiceCompra) {

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
