package integracao.mediador;

import integracao.adaptador.impl.AdaptadorPagamentoImp;

public class IntegracaoPagamento {

    public AdaptadorPagamentoImp retornarMediadorPagamento(){
        return new AdaptadorPagamentoImp();
    }
}
