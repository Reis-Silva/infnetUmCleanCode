package exemplo;

import enumeration.AssinaturaEnum;
import module.Assinatura;
import module.Cliente;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.ArrayList;

public class ClienteExemplo {
    public ArrayList<Cliente>  getClienteExemplo(){
        ArrayList<Cliente> cliente = new ArrayList<Cliente>();
        cliente.add(new Cliente("Jonaya", "1"));
        cliente.add(new Cliente("Júlio", "2"));
        cliente.add(new Cliente("Vitoria", "3"));

        return cliente;
    }
}
