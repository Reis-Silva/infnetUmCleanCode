import module.Assinatura;
import module.Cliente;
import module.Pagamento;
import module.Produto;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import java.util.function.Consumer;
import java.util.stream.IntStream;

import static java.util.Comparator.comparing;

public class Start {
    public static void main(String[] args) {
        System.out.println("=====================================Parte 1=============================================");
        System.out.println("Construindo Informações Pagamento");
        Cliente jonaya = new Cliente("Jonaya");
        Cliente julio = new Cliente("Júlio");

        Produto produto1 = new Produto("Kit Fluídos Isqueiro", new BigDecimal("100.00"));
        Produto produto2  = new Produto("Cigarreira", new BigDecimal("200.00"));
        Produto produto3 = new Produto("Isqueiro Zippo", new BigDecimal("300.00"));

        List<Produto> venda1 = new ArrayList<>();
        venda1.add(produto1);
        venda1.add(produto2);

        List<Produto> venda2 = new ArrayList<>();
        venda2.add(produto2);

        List<Produto> venda3 = new ArrayList<>();
        venda3.add(produto3);

        ArrayList<Pagamento> pagamentoJonaya = new ArrayList<>();
        pagamentoJonaya.add(new Pagamento(venda1, LocalDateTime.of(2023, Month.JUNE, 2, 11, 30), jonaya));
        pagamentoJonaya.add(new Pagamento(venda2, LocalDateTime.of(2023, Month.JUNE, 1, 12, 30), jonaya));
        pagamentoJonaya.add(new Pagamento(venda3, LocalDateTime.of(2023, Month.MAY, 31, 13, 30), jonaya));
        pagamentoJonaya.add(new Pagamento(venda3, LocalDateTime.of(2023, Month.MAY, 30, 13, 30), jonaya));

        ArrayList<Pagamento> pagamentoJulio = new ArrayList<>();
        pagamentoJulio.add(new Pagamento(venda2, LocalDateTime.of(2023, Month.JUNE, 2, 11, 30), julio));
        pagamentoJulio.add(new Pagamento(venda3, LocalDateTime.of(2023, Month.JUNE, 1, 12, 30), julio));
        pagamentoJulio.add(new Pagamento(venda1, LocalDateTime.of(2023, Month.MAY, 30, 13, 30), julio));

        System.out.println("=====================================Parte 2, 5 e 6 =====================================");
        List<ArrayList<Pagamento>> listaCliente = new ArrayList<>();
        listaCliente.add(pagamentoJonaya);
        listaCliente.add(pagamentoJulio);

        String imprimirSeparacaoCliente = "=========================================================================================";
        String imprimirSeparacaoProduto = ("-----------------------------------------------------------------------------------------");

        Consumer<Produto> imprimirProdutoCliente = produtoCliente -> System.out.println("Nome: " + produtoCliente.getNome() + " - Valor: R$ " + produtoCliente.getPreco());
        Consumer<Pagamento> imprimirNomeCliente = nomeCliente -> System.out.println("Cliente: " + nomeCliente.getCliente().getNome());

        Consumer<Pagamento> imprimirPagamentoCliente =
                pagamentoClienteData -> {
                    System.out.println("Data de Pagamento: " + pagamentoClienteData.getDataCompra() + "\nProdutos: ");
                    pagamentoClienteData.getProdutos().forEach(imprimirProdutoCliente);
                    System.out.println(imprimirSeparacaoProduto);
                };

        listaCliente.forEach(cliente ->{
            System.out.println(imprimirSeparacaoCliente);
            System.out.println("Cliente: " + cliente.get(0).getCliente().getNome());
            cliente.sort(comparing(Pagamento::getDataCompra));
            cliente.forEach(imprimirPagamentoCliente);
        });

        System.out.println("=====================================Parte 3=============================================");
        Optional<Double> pagamentoUnitario = Optional.of(venda1.stream().mapToDouble(p -> p.getPreco().doubleValue()).sum());
        System.out.println(pagamentoUnitario.get());

        System.out.println("=====================================Parte 7=============================================");

        listaCliente.forEach(cliente ->{
            System.out.println(imprimirSeparacaoCliente);
            System.out.println("Cliente: " + cliente.get(0).getCliente().getNome());
            AtomicReference<Double> totalPagamento = new AtomicReference<>(0.00);
            cliente.forEach(pagamento -> {
                totalPagamento.set(totalPagamento.get() + pagamento.getProdutos().stream().mapToDouble(preco -> preco.getPreco().doubleValue()).sum());
            });
            System.out.println("Valor Total Pago: " + totalPagamento);
        });

        System.out.println("=====================================Parte 8=============================================");
        listaCliente.forEach(cliente ->{
            System.out.println(imprimirSeparacaoCliente);
            System.out.println("Cliente: " + cliente.get(0).getCliente().getNome());
            AtomicReference<Double> totalPagamento = new AtomicReference<>(0.00);
            cliente.forEach(pagamento -> {
                Optional<Produto> gastoMes = pagamento.getProdutos().stream().filter(mes -> pagamento.getDataCompra().getMonth() == Month.MAY).findAny();
                gastoMes.ifPresent((produto) -> {
                    totalPagamento.set(totalPagamento.get() + produto.getPreco().doubleValue());
                });
            });
            System.out.println("Valor Total Pago no Mês de Maio: " + totalPagamento);
        });

        System.out.println("=====================================Parte 9=============================================");
        System.out.println("Construindo Informações Assinatura");
        ArrayList<Assinatura> assinatura = new ArrayList<>();
        assinatura.add(new Assinatura(new BigDecimal("99.98"), LocalDateTime.of(2023, Month.MARCH, 1, 11, 30)));
        assinatura.add(new Assinatura(new BigDecimal("99.98"), LocalDateTime.of(2023, Month.APRIL, 1, 11, 30), LocalDateTime.of(2023, Month.MAY, 1, 11, 30)));
        assinatura.add(new Assinatura(new BigDecimal("99.98"), LocalDateTime.of(2023, Month.APRIL, 1, 11, 30), LocalDateTime.of(2023, Month.JUNE, 1, 11, 30)));

        System.out.println("=====================================Parte 10=============================================");
        assinatura.forEach(assinaturaAtiva -> {
            if (assinaturaAtiva.getBegin() != null && !assinaturaAtiva.getEnd().isPresent()){
                long mesesAtivo = ChronoUnit.MONTHS.between(LocalDate.now(), assinaturaAtiva.getBegin());
                System.out.println("Assinatura " + (assinatura.indexOf(assinaturaAtiva) + 1) + " Ativa: " + (-mesesAtivo) + " meses");
            }
        });

        System.out.println("=====================================Parte 11=============================================");
        assinatura.forEach(assinaturaAtiva -> {
            long mesesAtivo = ChronoUnit.MONTHS.between(assinaturaAtiva.getEnd().orElse(LocalDateTime.now()), assinaturaAtiva.getBegin());
            System.out.println("Meses da Assinatura " + (assinatura.indexOf(assinaturaAtiva) + 1) + " iniciou até a data de temíno ou Atual: " + (-mesesAtivo));
        });

        System.out.println("=====================================Parte 12=============================================");
        assinatura.forEach(assinaturaAtiva -> {
            long mesesAtivo = ChronoUnit.MONTHS.between(assinaturaAtiva.getEnd().orElse(LocalDateTime.now()), assinaturaAtiva.getBegin());
            System.out.println("Meses da Assinatura " + (assinatura.indexOf(assinaturaAtiva) + 1) + " Pago: R$ " + (new BigDecimal(-mesesAtivo).multiply(assinaturaAtiva.getMensalidade())));
        });


    }
}
