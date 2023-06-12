package module;

import java.math.BigDecimal;
import java.time.LocalDateTime;

public class Assinatura {

    private BigDecimal mensalidade;

    private LocalDateTime begin;

    private LocalDateTime end;

    public Assinatura(BigDecimal mensalidade, LocalDateTime begin, LocalDateTime end) {
        this.mensalidade = mensalidade;
        this.begin = begin;
        this.end = end;
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

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }
}
