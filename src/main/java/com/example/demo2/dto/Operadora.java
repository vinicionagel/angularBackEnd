package com.example.demo2.dto;

import java.io.Serializable;
import java.math.BigDecimal;

public class Operadora implements Serializable {

    private String nome;
    private Integer codigo;
    private String categoria;

    private BigDecimal preco;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public BigDecimal getPreco() {
        return preco;
    }

    public void setPreco(BigDecimal preco) {
        this.preco = preco;
    }


    public static final class OperadoraBuilder {
        private String nome;
        private Integer codigo;
        private String categoria;
        private BigDecimal preco;

        private OperadoraBuilder() {
        }

        public static OperadoraBuilder anOperadora() {
            return new OperadoraBuilder();
        }

        public OperadoraBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public OperadoraBuilder withCodigo(Integer codigo) {
            this.codigo = codigo;
            return this;
        }

        public OperadoraBuilder withCategoria(String categoria) {
            this.categoria = categoria;
            return this;
        }

        public OperadoraBuilder withPreco(BigDecimal preco) {
            this.preco = preco;
            return this;
        }

        public Operadora build() {
            Operadora operadora = new Operadora();
            operadora.setNome(nome);
            operadora.setCodigo(codigo);
            operadora.setCategoria(categoria);
            operadora.setPreco(preco);
            return operadora;
        }
    }
}
