package com.spy.pessoa.service;

import com.spy.pessoa.domain.Pessoa;
import com.spy.pessoa.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

  @Autowired
  private PessoaRepository pessoaRepository;

  public List<Pessoa> buscarTodas() {
    return pessoaRepository.findAll();
  }

  public Pessoa criar(Pessoa pessoa) {
    return pessoaRepository.save(pessoa);
  }
  public Pessoa buscarPorId(Long id) {
    return pessoaRepository.findById(id).orElse(null);
  }
  public void deletar(Long id) {
    pessoaRepository.deleteById(id);
  }

  public Pessoa atualizar(Long id, Pessoa novaPessoa) {
    Pessoa pessoa = pessoaRepository.findById(id).orElse(null);
    pessoa = novaPessoa;
    return pessoaRepository.save(pessoa);
  }
}
