package punto6;

public class Surtidores {
    private int codigo;
    private String tipoCombustible;
    private double valorDe1Litro;

    public Surtidores(int codigo, String tipoCombustible,double valorDe1Litro) {
        this.codigo = codigo;
        this.tipoCombustible = tipoCombustible;
        this.valorDe1Litro=valorDe1Litro;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTipoCombustible() {
        return tipoCombustible;
    }

    public void setTipoCombustible(String tipoCombustible) {
        this.tipoCombustible = tipoCombustible;
    }

    public double getValorDe1Litro() {
        return valorDe1Litro;
    }
}
