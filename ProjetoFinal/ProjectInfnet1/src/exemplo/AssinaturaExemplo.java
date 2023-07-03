package exemplo;

import enumeration.AssinaturaEnum;
import module.Assinatura;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class AssinaturaExemplo {

    public ArrayList<Assinatura>  getAssinaturaExemplo(){
        Assinatura assinaturaJonaya = new Assinatura(LocalDateTime.of(2023,Month.JANUARY, 1, 11, 30), AssinaturaEnum.TRIMESTRAL, true);
        Assinatura assinaturaJulio = new Assinatura(LocalDateTime.of(2023,Month.JANUARY, 1, 11, 30), AssinaturaEnum.SEMESTRAL, true);
        Assinatura assinaturaVitoria = new Assinatura(LocalDateTime.of(2022,Month.JANUARY, 1, 11, 30), AssinaturaEnum.ANUAL, false);

        ArrayList<Assinatura> assinatura = new ArrayList<>();
        assinatura.add(assinaturaJonaya);
        assinatura.add(assinaturaJulio);
        assinatura.add(assinaturaVitoria);

        return assinatura;
    }

    public ArrayList<ArrayList<Assinatura>>  getAssinaturaComplementoExemplo(){

        ArrayList<Assinatura> assinatura = getAssinaturaExemplo();

        ArrayList<ArrayList<Assinatura>> assinaturaParcelaCliente = new ArrayList<>();

        assinatura.forEach(construcaoNumeroParcela ->{
            ArrayList<Assinatura> assinaturaTemp = new ArrayList<>();
            long parcela = construcaoNumeroParcela.getParcela();

            for (long i = 0; i < parcela; i++){
                assinaturaTemp.add(construcaoNumeroParcela);
            }

            assinaturaParcelaCliente.add(assinaturaTemp);
        });

        return assinaturaParcelaCliente;
    }

}
