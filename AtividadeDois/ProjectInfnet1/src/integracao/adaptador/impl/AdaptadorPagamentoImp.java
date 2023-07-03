package integracao.adaptador.impl;

import exemplo.AssinaturaExemplo;
import exemplo.PagamentoExemplo;
import integracao.adaptador.AdaptadorPagamento;
import module.Assinatura;
import module.Pagamento;
import module.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;

public class AdaptadorPagamentoImp implements AdaptadorPagamento {

    private ArrayList<Pagamento> pagamentoExemplo = new PagamentoExemplo().getPagamentoExemplo();

    private ArrayList<ArrayList<Assinatura>> assinaturaComplementoExemplo = new AssinaturaExemplo().getAssinaturaComplementoExemplo();

    private String linha = "===========================================================================================\n";

    @Override
    public void getTempoAssinaturaExecutada() {
        pagamentoExemplo.forEach(testeMecanismos -> {
            System.out.println(testeMecanismos.getCliente().getNome() + " - Numero de Renovação de Assinatura: " + testeMecanismos.getTempoAssinaturaExecutada() + " - Parcela: " + testeMecanismos.getTipoAssinatura().toString());
        });
        System.out.println(linha);
    }

    @Override
    public void getValorTotalDebitado() {
        pagamentoExemplo.forEach(testeMecanismos -> {
            System.out.println(testeMecanismos.getCliente().getNome() + " - Valor Total para ser debitado até o momento: " + testeMecanismos.getValorTotalDebitado(assinaturaComplementoExemplo.get(pagamentoExemplo.indexOf(testeMecanismos))) + " - Parcela: " + testeMecanismos.getTipoAssinatura().toString());
        });
        System.out.println(linha);
    }

    @Override
    public void getValorTotalMensalidade() {
        pagamentoExemplo.forEach(testeMecanismos -> {
            System.out.println(testeMecanismos.getCliente().getNome() + " - Valor Total para de todas as parcelas que devem ser pagas: " + testeMecanismos.getValorTotalMensalidade() + " - Parcela: " + testeMecanismos.getTipoAssinatura().toString());
        });
        System.out.println(linha);
    }

    @Override
    public void getStatusAssinatura() {
        pagamentoExemplo.forEach(testeMecanismos -> {
            System.out.println(testeMecanismos.getCliente().getNome() + " - Status da Assinatura: " + testeMecanismos.getStatusAssinatura(assinaturaComplementoExemplo.get(pagamentoExemplo.indexOf(testeMecanismos))) + " - Parcela: " + testeMecanismos.getTipoAssinatura().toString());
        });
        System.out.println(linha);
    }

    @Override
    public void getStatusAssinaturaPagamentoProduto() {
        pagamentoExemplo.forEach(testeMecanismos -> {
            System.out.println(testeMecanismos.getCliente().getNome() + " - Status da Assinatura: " + testeMecanismos.getStatusAssinatura(assinaturaComplementoExemplo.get(pagamentoExemplo.indexOf(testeMecanismos))) + " - Parcela: " + testeMecanismos.getTipoAssinatura().toString());
            Produto produto2  = new Produto("Cigarreira", new BigDecimal("200.00"));
            System.out.println("adicionando produto para: " + testeMecanismos.getCliente().getNome() + "\n");
            testeMecanismos.validarExecucaoPagamentoProduto(assinaturaComplementoExemplo.get(pagamentoExemplo.indexOf(testeMecanismos)));
            testeMecanismos.getProdutos().add(produto2);
        });
        System.out.println(linha);
    }
}
