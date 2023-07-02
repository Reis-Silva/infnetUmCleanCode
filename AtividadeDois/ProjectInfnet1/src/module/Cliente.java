package module;

import java.util.Objects;

public class Cliente {

    private String Nome;

    private String identidadeFiscal;

    public Cliente(){
    }

    public Cliente(String nome, String identidadeFiscal) {
        this.Nome = nome;
        this.identidadeFiscal = identidadeFiscal;
    }

    public String getNome() {
        return Nome;
    }

    public void setNome(String nome) {
        Nome = nome;
    }

    public String getIdentidadeFiscal() {
        return identidadeFiscal;
    }

    public void setIdentidadeFiscal(String identidadeFiscal) {
        this.identidadeFiscal = identidadeFiscal;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cliente)) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(getNome(), cliente.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getNome());
    }

    @Override
    public String toString() {
        return Nome;
    }
}
