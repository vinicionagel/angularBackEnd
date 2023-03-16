package com.example.demo2.controller;


import com.example.demo2.dto.Contato;
import com.example.demo2.dto.ContatoInput;
import com.example.demo2.dto.Operadora;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.math.BigDecimal;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.*;
import java.util.stream.Collectors;

@RestController
@RequestMapping
@CrossOrigin(origins = "http://localhost:63342")
public class ContatoTelefonicoController {

    public static List<Contato> DADOS = new ArrayList<>(Arrays.asList(Contato.ContatoBuilder.aContato()
                    .withCor("red")
                    .withNome("Pedro rodrigues")
                    .withTelefone("9999999")
                    .withSerial("A4546")
                    .withOperadora(Operadora.OperadoraBuilder.anOperadora().withNome("Oi").withCategoria("Celular").withPreco(new BigDecimal("3")).withCodigo(15).build())
                    .withDate(LocalDate.now())
                    .build(),
            Contato.ContatoBuilder.aContato()
                    .withCor("yellow")
                    .withNome("Ana maria")
                    .withTelefone("999888")
                    .withSerial("456RE")
                    .withDate(LocalDate.now())
                    .withOperadora(Operadora.OperadoraBuilder.anOperadora().withNome("Oi").withCategoria("Celular").withPreco(new BigDecimal("3")).withCodigo(15).build())
                    .build(),
            Contato.ContatoBuilder.aContato()
                    .withCor("yellow")
                    .withNome("Maria antonieta")
                    .withTelefone("999887")
                    .withSerial("FFF88")
                    .withOperadora(Operadora.OperadoraBuilder.anOperadora().withNome("Oi").withCategoria("Celular").withPreco(new BigDecimal("3")).withCodigo(15).build())
                    .withDate(LocalDate.now())
                    .build()));

    @PostMapping("/contato")
    public void addContato(@RequestBody ContatoInput contato) {
        DADOS.add(Contato.ContatoBuilder.aContato()
                .withNome(contato.getNome())
                .withDate(Instant.ofEpochMilli(contato.getData())
                        .atZone(ZoneId.systemDefault())
                        .toLocalDate())
                .withTelefone(contato.getTelefone())
                .withSerial(contato.getSerial())
                .withOperadora(contato.getOperadora())
                .build());
    }

    @DeleteMapping("/contato")
    public void deleteContato(@RequestBody Set<String> seriais) {
        DADOS = DADOS.stream().filter(contato -> !seriais.contains(contato.getSerial())).collect(Collectors.toList());
    }
    @GetMapping("/operadoras")
    public List<Operadora> getOperadoras() {
        return List.of(Operadora.OperadoraBuilder.anOperadora().withNome("Oi").withPreco(new BigDecimal("2")).withCodigo(14).withCategoria("Celular").build(),
                Operadora.OperadoraBuilder.anOperadora().withNome("Vivo").withPreco(new BigDecimal("3")).withCodigo(15).withCategoria("Celular").build(),
                Operadora.OperadoraBuilder.anOperadora().withNome("Tim").withPreco(new BigDecimal("1")).withCodigo(41).withCategoria("Celular").build(),
                Operadora.OperadoraBuilder.anOperadora().withNome("GVT").withPreco(new BigDecimal("1")).withCodigo(41).withCategoria("Fixo").build(),
                Operadora.OperadoraBuilder.anOperadora().withNome("Embratel").withPreco(new BigDecimal("1")).withCodigo(21).withCategoria("Fixo").build());
    }

    @GetMapping("/contatos/{id}")
    public Contato getContato(@PathVariable(value = "id") String serial) {
        return DADOS.stream().filter(contato -> contato.getSerial().equals(serial)).findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "entity not found"));
    }

    @GetMapping("/contatos")
    public List<Contato> getContatos() {
        return DADOS;
    }
}
