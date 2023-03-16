package com.example.demo2.dto;

import java.io.Serializable;
import java.util.Objects;

public class ContatoInput implements Serializable {

    private String nome;
    private String telefone;
    private String cor;

    private Long data;

    private Operadora operadora;

    private String serial;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Long getData() {
        return data;
    }

    public void setData(Long data) {
        this.data = data;
    }

    public Operadora getOperadora() {
        return operadora;
    }

    public void setOperadora(Operadora operadora) {
        this.operadora = operadora;
    }

    public String getSerial() {
        return serial;
    }

    public void setSerial(String serial) {
        this.serial = serial;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContatoInput contatos = (ContatoInput) o;
        return Objects.equals(nome, contatos.nome) && Objects.equals(telefone, contatos.telefone) && Objects.equals(cor, contatos.cor) && Objects.equals(data, contatos.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, telefone, cor, data);
    }

    public static final class ContatoInputBuilder {
        private String nome;
        private String telefone;
        private String cor;
        private Long date;
        private Operadora operadora;

        private ContatoInputBuilder() {
        }

        public static ContatoInputBuilder aContato() {
            return new ContatoInputBuilder();
        }

        public ContatoInputBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public ContatoInputBuilder withTelefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public ContatoInputBuilder withCor(String cor) {
            this.cor = cor;
            return this;
        }

        public ContatoInputBuilder withDate(Long date) {
            this.date = date;
            return this;
        }

        public ContatoInputBuilder withOperadora(Operadora operadora) {
            this.operadora = operadora;
            return this;
        }

        public ContatoInput build() {
            ContatoInput contato = new ContatoInput();
            contato.setNome(nome);
            contato.setTelefone(telefone);
            contato.setCor(cor);
            contato.setData(date);
            contato.setOperadora(operadora);
            return contato;
        }
    }
}
