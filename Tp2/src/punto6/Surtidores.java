package punto6;

public class Surtidores {
    private int codigo;
    private String tipoCombustible;

    public Surtidores(int codigo, String tipoCombustible) {
        this.codigo = codigo;
        this.tipoCombustible = tipoCombustible;
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
}
