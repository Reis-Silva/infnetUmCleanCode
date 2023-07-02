import exemplo.AssinaturaExemplo;
import exemplo.PagamentoExemplo;
import module.Assinatura;
import module.Pagamento;
import module.Produto;

import java.math.BigDecimal;
import java.util.ArrayList;

import static java.util.Comparator.comparing;

public class PagamentoService {
    public static void main(String[] args) {

        System.out.println("====================================CARREGANDO PSEUDO BANCO DE DADOS=======================\n");
        PagamentoExemplo pagamentoExemplo = new PagamentoExemplo();
        ArrayList<Pagamento> pagamento = pagamentoExemplo.getPagamentoExemplo();

        AssinaturaExemplo assinaturaExemplo = new AssinaturaExemplo();
        ArrayList<ArrayList<Assinatura>> assinaturaComplementoExemplo = assinaturaExemplo.getAssinaturaComplementoExemplo();

        System.out.println("=====================================SIMULAÇÃO=============================================\n");
        pagamento.forEach(testeMecanismos -> {
            System.out.println(testeMecanismos.getCliente().getNome() + " - Numero de Renovação de Assinatura: " + testeMecanismos.getTempoAssinaturaExecutada() + " - Parcela: " + testeMecanismos.getTipoAssinatura().toString());
        });
        System.out.println("===========================================================================================\n");

        pagamento.forEach(testeMecanismos -> {
            System.out.println(testeMecanismos.getCliente().getNome() + " - Valor Total para ser debitado até o momento: " + testeMecanismos.getValorTotalDebitado(assinaturaComplementoExemplo.get(pagamento.indexOf(testeMecanismos))) + " - Parcela: " + testeMecanismos.getTipoAssinatura().toString());
        });
        System.out.println("===========================================================================================\n");

        pagamento.forEach(testeMecanismos -> {
            System.out.println(testeMecanismos.getCliente().getNome() + " - Valor Total para de todas as parcelas que devem ser pagas: " + testeMecanismos.getValorTotalMensalidade() + " - Parcela: " + testeMecanismos.getTipoAssinatura().toString());
        });
        System.out.println("===========================================================================================\n");

        pagamento.forEach(testeMecanismos -> {
            System.out.println(testeMecanismos.getCliente().getNome() + " - Status da Assinatura: " + testeMecanismos.getStatusAssinatura(assinaturaComplementoExemplo.get(pagamento.indexOf(testeMecanismos))) + " - Parcela: " + testeMecanismos.getTipoAssinatura().toString());
        });
        System.out.println("===========================================================================================\n");

        pagamento.forEach(testeMecanismos -> {
            System.out.println(testeMecanismos.getCliente().getNome() + " - Status da Assinatura: " + testeMecanismos.getStatusAssinatura(assinaturaComplementoExemplo.get(pagamento.indexOf(testeMecanismos))) + " - Parcela: " + testeMecanismos.getTipoAssinatura().toString());
            Produto produto2  = new Produto("Cigarreira", new BigDecimal("200.00"));
            System.out.println("adicionando produto para: " + testeMecanismos.getCliente().getNome() + "\n");
            testeMecanismos.validarExecucaoPagamentoProduto(assinaturaComplementoExemplo.get(pagamento.indexOf(testeMecanismos)));
            testeMecanismos.getProdutos().add(produto2);
        });
        System.out.println("===========================================================================================\n");
    }
}
