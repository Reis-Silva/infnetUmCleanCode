package module;

import java.math.BigDecimal;
import java.nio.file.Path;
import java.util.Objects;

public class Produto {

    private String nome;

    private BigDecimal Preco;

    private Path file;

    public Produto(String nome, BigDecimal preco) {
        this.nome = nome;
        this.Preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getPreco() {
        return Preco;
    }

    public void setPreco(BigDecimal preco) {
        Preco = preco;
    }

    public Path getFile() {
        return file;
    }

    public void setFile(Path file) {
        this.file = file;
    }

    @Override
    public String toString() {
        return Preco.toString();
    }
}
