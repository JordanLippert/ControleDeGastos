import java.util.Date;
import java.util.List;
import java.util.ArrayList;

public class Aplicacao {

    private List <FormaPagamento> formaPagamentos = new ArrayList<>();
    private List <TipoGasto> tipoDeGastos = new ArrayList<>();
    private List <Gasto> listaDeGastos = new ArrayList<>();

    public void adicionarFormaPagamento(FormaPagamento forma){
        if (forma != null){
            formaPagamentos.add(forma);
        }
        else {
            System.out.println("ERRO: Forma de pagamento Inválida! ");
            System.out.print("TESTE")
        }
    }

    public void adicionarTipoGasto(TipoGasto tipo){
        if (tipo != null){
            tipoDeGastos.add(tipo);
        }
        else {
            System.out.println("ERRO: Tipo de gasto Inválido! ");
        }
    }

    public void listarGastos(int mes, int ano){
        List <Gasto> gastosFiltrados = new ArrayList<>();
        for (Gasto gasto : listaDeGastos){
            Date dataDoGasto = gasto.getData();

            if (dataDoGasto.getMonth() + 1 == mes && dataDoGasto.getYear() + 1900 == ano){
                gastosFiltrados.add(gasto);
            }
        }
        gastosFiltrados.sort((g1, g2) -> g1.getData().compareTo(g2.getData()));
        for (Gasto gasto : gastosFiltrados){
            System.out.println(gasto);
        }
    }

    public void novoGasto(String descricao, Date data, double valor, TipoGasto tipo, FormaPagamento forma){
        if (descricao != null && data != null && valor >= 0 && tipo != null && forma != null){
            Gasto novoGasto = new Gasto(descricao, data, valor, tipo, forma);
            listaDeGastos.add(novoGasto);
        }
        else {
            System.out.println("ERRO: Dados dos gastos Inválidos!");
        }
    }
}
