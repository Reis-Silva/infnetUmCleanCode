package module;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

public class Assinatura {

    private BigDecimal mensalidade;

    private LocalDateTime begin;

    private Optional<LocalDateTime>  end;

    public Assinatura(BigDecimal mensalidade, LocalDateTime begin) {
        this.mensalidade = mensalidade;
        this.begin = begin;
        this.end = Optional.empty();
    }

    public Assinatura(BigDecimal mensalidade, LocalDateTime begin, LocalDateTime end) {
        this.mensalidade = mensalidade;
        this.begin = begin;
        this.end = Optional.of(end);
    }

    public BigDecimal getMensalidade() {
        return mensalidade;
    }

    public void setMensalidade(BigDecimal mensalidade) {
        this.mensalidade = mensalidade;
    }

    public LocalDateTime getBegin() {
        return begin;
    }

    public void setBegin(LocalDateTime begin) {
        this.begin = begin;
    }

    public Optional<LocalDateTime>  getEnd() {
        return end;
    }

    public void setEnd(Optional<LocalDateTime>  end) {
        this.end = end;
    }
}
