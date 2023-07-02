package exemplo;

import enumeration.AssinaturaEnum;
import module.Assinatura;
import module.Cliente;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class AsssinaturaExemplo {

    public ArrayList<Assinatura>  getAssinaturaExemplo(){
        Assinatura assinaturaJonaya = new Assinatura(LocalDateTime.of(2023,Month.JANUARY, 1, 11, 30), AssinaturaEnum.SEMESTRAL, true);
        Assinatura assinaturaJulio = new Assinatura(LocalDateTime.of(2023,Month.JANUARY, 1, 11, 30), AssinaturaEnum.TRIMESTRAL, true);
        Assinatura assinaturaVitoria = new Assinatura(LocalDateTime.of(2022,Month.JANUARY, 1, 11, 30), AssinaturaEnum.ANUAL, false);

        ArrayList<Assinatura> assinatura = new ArrayList<>();
        assinatura.add(assinaturaJonaya);
        assinatura.add(assinaturaJulio);
        assinatura.add(assinaturaVitoria);

        return assinatura;
    }

}
