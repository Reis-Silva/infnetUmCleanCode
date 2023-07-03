package integracao.adaptador;

public interface AdaptadorPagamento {

    public void getTempoAssinaturaExecutada();

    public void getValorTotalDebitado();

    public void getValorTotalMensalidade();

    public void getStatusAssinatura();

    public void getStatusAssinaturaPagamentoProduto();
}
