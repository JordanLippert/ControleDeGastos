import java.util.Date;

public class Gasto {

    private Date data;
    private String descricao;
    private double valor;
    private TipoGasto tipo;
    private FormaPagamento forma;

    public Gasto(String descricao, Date data, double valor, TipoGasto tipo, FormaPagamento forma){
        this.data = data;
        this.descricao = descricao;
        this.valor = valor;
        this.tipo = tipo;
        this.forma = forma;
    }

    public String obterDescricao(){
        return descricao;
    }

    public Date getData(){
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public TipoGasto getTipo() {
        return tipo;
    }

    public void setTipo(TipoGasto tipo) {
        this.tipo = tipo;
    }

    public FormaPagamento getForma() {
        return forma;
    }

    public void setForma(FormaPagamento forma) {
        this.forma = forma;
    }
}
