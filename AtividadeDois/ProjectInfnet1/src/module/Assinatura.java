package module;

import enumeration.AssinaturaEnum;
import enumeration.StatusAssinaturaEnum;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.List;
import java.util.Optional;

public class Assinatura {

    private Long parcela;
    private LocalDateTime begin;

    private Optional<LocalDateTime>  end;

    private AssinaturaEnum tipoAssinatura;

    private Boolean ativa;

    public Assinatura(){
    }

    public Assinatura(LocalDateTime begin, AssinaturaEnum tipoAssinatura, Boolean ativa) {
        this.parcela = getTempoAssinaturaExecutada();
        this.begin = begin;
        this.end =  Optional.empty();
        this.tipoAssinatura = tipoAssinatura;
        this.ativa = ativa;
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

    public Long getTempoAssinaturaExecutada(){
        return ChronoUnit.MONTHS.between(LocalDateTime.now(), begin) % tipoAssinatura.getValorCongruenteTempoAssinatura();
    }

    private BigDecimal getValorTotalMensalidade(){
        return tipoAssinatura.getValorDebitoAssinatura().add(
                tipoAssinatura.getTaxaAssinatura()
                        .multiply(tipoAssinatura.getValorDebitoAssinatura())
                        .multiply(BigDecimal.valueOf(getTempoAssinaturaExecutada())));
    }

    private BigDecimal getValorTotalDebitado(List<Assinatura> pagamentoAssinatura){
        return tipoAssinatura.getValorDebitoAssinatura().multiply(BigDecimal.valueOf(pagamentoAssinatura.stream().filter(assinaturaPaga -> assinaturaPaga.getAtiva()).count()));
    }

    private StatusAssinaturaEnum getStatusAssinatura(List<Assinatura> pagamentoAssinatura){
        return getValorTotalMensalidade().compareTo(getValorTotalDebitado(pagamentoAssinatura)) == 0 ? StatusAssinaturaEnum.ATIVO : StatusAssinaturaEnum.PENDENTE;
    }

}
