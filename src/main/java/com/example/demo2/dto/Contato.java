package com.example.demo2.dto;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

public class Contato implements Serializable {

    private String nome;
    private String telefone;
    private String cor;

    private LocalDate data;

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

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
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
        Contato contatos = (Contato) o;
        return Objects.equals(nome, contatos.nome) && Objects.equals(telefone, contatos.telefone) && Objects.equals(cor, contatos.cor) && Objects.equals(data, contatos.data);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nome, telefone, cor, data);
    }

    public static final class ContatoBuilder {
        private String nome;
        private String telefone;
        private String cor;
        private LocalDate date;
        private Operadora operadora;

        private String serial;

        private ContatoBuilder() {
        }

        public static ContatoBuilder aContato() {
            return new ContatoBuilder();
        }

        public ContatoBuilder withNome(String nome) {
            this.nome = nome;
            return this;
        }

        public ContatoBuilder withTelefone(String telefone) {
            this.telefone = telefone;
            return this;
        }

        public ContatoBuilder withCor(String cor) {
            this.cor = cor;
            return this;
        }

        public ContatoBuilder withDate(LocalDate date) {
            this.date = date;
            return this;
        }

        public ContatoBuilder withOperadora(Operadora operadora) {
            this.operadora = operadora;
            return this;
        }

        public ContatoBuilder withSerial(String serial) {
            this.serial = serial;
            return this;
        }

        public Contato build() {
            Contato contato = new Contato();
            contato.setNome(nome);
            contato.setTelefone(telefone);
            contato.setCor(cor);
            contato.setData(date);
            contato.setOperadora(operadora);
            contato.setSerial(serial);
            return contato;
        }
    }
}
