package com.spy.pessoa.controller;

import com.spy.pessoa.domain.Pessoa;
import com.spy.pessoa.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/pessoas")
public class PessoaController {

  @Autowired
  private PessoaService pessoaService;
  @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
  List<Pessoa> buscaPessoas() {

    // Criando a lista para armazenar pares de nome e idade
    return pessoaService.buscarTodas();
  }

  @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
  public ResponseEntity<Pessoa> buscarPorId(@PathVariable Long id) {
    Pessoa pessoa = pessoaService.buscarPorId(id);
    if(pessoa == null) {
      return ResponseEntity.status(HttpStatus.NO_CONTENT).body(null);
    } else {
      return ResponseEntity.status(HttpStatus.OK).body(pessoa);
    }
  }

  @PostMapping
  public ResponseEntity<Pessoa> criar(@RequestBody Pessoa pessoa) {
    Pessoa pessoaSalvaNoBanco = pessoaService.criar(pessoa);
    return ResponseEntity.status(HttpStatus.CREATED).body(pessoaSalvaNoBanco);
  }

  @DeleteMapping(value = "/{id}")
  public ResponseEntity<?> deletar(@PathVariable Long id) {
    pessoaService.deletar(id);
    return ResponseEntity.status(HttpStatus.OK).body(null);
  }

  @PutMapping(path = "/{id}")
  public ResponseEntity<Pessoa> atualizar(@PathVariable Long id, @RequestBody Pessoa pessoa) {
    Pessoa pessoaAtualizada = pessoaService.atualizar(id, pessoa);
    return ResponseEntity.status(200).body(pessoaAtualizada);
  }
}
