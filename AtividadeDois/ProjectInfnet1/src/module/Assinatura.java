package module;

import enumeration.AssinaturaEnum;
import enumeration.StatusAssinaturaEnum;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

public class Assinatura {

    private LocalDateTime begin;

    private Optional<LocalDateTime>  end;

    private AssinaturaEnum tipoAssinatura;

    private Boolean ativa;

    private Long parcela;

    public Assinatura(){
    }

    public Assinatura(LocalDateTime begin, AssinaturaEnum tipoAssinatura, Boolean ativa) {
        this.begin = begin;
        this.end =  Optional.empty();
        this.tipoAssinatura = tipoAssinatura;
        this.ativa = ativa;
        this.parcela = getTempoAssinaturaExecutada();
    }

    public LocalDateTime getBegin() {
        return begin;
    }

    public Optional<LocalDateTime>  getEnd() {
        return end;
    }

    public void setEnd(Optional<LocalDateTime>  end) {
        this.end = end;
    }

    public AssinaturaEnum getTipoAssinatura() {
        return tipoAssinatura;
    }

    public void setTipoAssinatura(AssinaturaEnum tipoAssinatura) {
        this.tipoAssinatura = tipoAssinatura;
    }

    public Boolean getAtiva() {
        return ativa;
    }

    public void setAtiva(Boolean ativa) {
        this.ativa = ativa;
    }

    public Long getParcela() {
        return parcela;
    }

    public void setParcela(Long parcela) {
        this.parcela = parcela;
    }

    public Long getTempoAssinaturaExecutada(){
        return -ChronoUnit.MONTHS.between(LocalDateTime.now(), begin) / tipoAssinatura.getValorCongruenteTempoAssinatura();
    }

    public BigDecimal getValorTotalMensalidade(){
        return tipoAssinatura.getValorDebitoAssinatura()
                    .multiply(BigDecimal.valueOf(getTempoAssinaturaExecutada())).add(
                        tipoAssinatura.getTaxaAssinatura()
                            .multiply(tipoAssinatura.getValorDebitoAssinatura())
                            .multiply(BigDecimal.valueOf(getTempoAssinaturaExecutada())));
    }

    public BigDecimal getValorTotalDebitado(List<Assinatura> pagamentoAssinatura){
        return new BigDecimal(pagamentoAssinatura.stream().filter(assinaturaPaga -> assinaturaPaga.getAtiva()).map(assinatura -> assinatura.getTipoAssinatura().getValorDebitoAssinatura()).count()).add(
                        BigDecimal.valueOf(pagamentoAssinatura.stream().filter(assinaturaPaga -> assinaturaPaga.getAtiva()).count())
                            .multiply(tipoAssinatura.getTaxaAssinatura()))
                            .multiply(tipoAssinatura.getValorDebitoAssinatura());
    }

    public StatusAssinaturaEnum getStatusAssinatura(List<Assinatura> pagamentoAssinatura){
        return getValorTotalMensalidade().compareTo(getValorTotalDebitado(pagamentoAssinatura)) == 0 ? StatusAssinaturaEnum.ATIVO : StatusAssinaturaEnum.PENDENTE;
    }

    public void validarExecucaoPagamentoProduto(List<Assinatura> pagamentoAssinatura){
        if (getStatusAssinatura(pagamentoAssinatura) == StatusAssinaturaEnum.PENDENTE){
            throw new IllegalArgumentException("Náo é Possível realizar Compra de Produtos - Assinatura Pendente");
        }
    }

}
