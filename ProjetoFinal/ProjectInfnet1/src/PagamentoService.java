import integracao.adaptador.impl.AdaptadorPagamentoImp;
import integracao.mediador.IntegracaoPagamento;

public class PagamentoService {
    public static void main(String[] args) {

        System.out.println("====================================CARREGANDO PSEUDO BANCO DE DADOS=======================\n");
        AdaptadorPagamentoImp adaptadorPagamentoImp = new IntegracaoPagamento().retornarMediadorPagamento();

        System.out.println("=====================================SIMULAÇÃO=============================================\n");
        adaptadorPagamentoImp.getTempoAssinaturaExecutada();
        adaptadorPagamentoImp.getValorTotalDebitado();
        adaptadorPagamentoImp.getValorTotalMensalidade();
        adaptadorPagamentoImp.getStatusAssinatura();
        adaptadorPagamentoImp.getStatusAssinaturaPagamentoProduto();
    }
}
