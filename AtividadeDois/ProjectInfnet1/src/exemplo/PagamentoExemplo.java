package exemplo;

import module.Assinatura;
import module.Cliente;
import module.Pagamento;
import module.Produto;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

public class PagamentoExemplo {

    public ArrayList<Pagamento> getPagamentoExemplo(){

        ClienteExemplo clienteExemplo = new ClienteExemplo();
        ArrayList<Cliente> cliente = clienteExemplo.getClienteExemplo();

        ProdutoExemplo produtoExemplo = new ProdutoExemplo();
        ArrayList<Produto> produto = produtoExemplo.getProdutoExemplo();

        AsssinaturaExemplo asssinaturaExemplo = new AsssinaturaExemplo();
        ArrayList<Assinatura> assinatura = asssinaturaExemplo.getAssinaturaExemplo();

        ArrayList<Pagamento> pagamento= new ArrayList<>();
        pagamento.add(new Pagamento(produto, LocalDateTime.of(2023, Month.JUNE, 2, 11, 30), cliente.get(0), assinatura.get(0)));
        pagamento.add(new Pagamento(produto, LocalDateTime.of(2023, Month.JUNE, 2, 11, 30), cliente.get(1), assinatura.get(1)));
        pagamento.add(new Pagamento(produto, LocalDateTime.of(2023, Month.JUNE, 2, 11, 30), cliente.get(2), assinatura.get(2)));

        return pagamento;
    }
}
