package module;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class Pagamento {

    private List<Produto> produtos;

    private LocalDateTime dataCompra;

    private Cliente cliente;

    public Pagamento(List<Produto> produtos, LocalDateTime dataCompra, Cliente cliente) {
        this.produtos = produtos;
        this.dataCompra = dataCompra;
        this.cliente = cliente;
    }

    public Pagamento(Pagamento pagamento) {
        this.produtos = pagamento.getProdutos();
        this.dataCompra = pagamento.getDataCompra();
        this.cliente = pagamento.getCliente();
    }

    public List<Produto> getProdutos() {
        return produtos;
    }
    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public LocalDateTime getDataCompra() {
        return dataCompra;
    }

    public void setDataCompra(LocalDateTime dataCompra) {
        this.dataCompra = dataCompra;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Pagamento)) return false;
        Pagamento pagamento = (Pagamento) o;
        return Objects.equals(getProdutos(), pagamento.getProdutos()) && Objects.equals(getDataCompra(), pagamento.getDataCompra()) && Objects.equals(getCliente(), pagamento.getCliente());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getProdutos(), getDataCompra(), getCliente());
    }
}
