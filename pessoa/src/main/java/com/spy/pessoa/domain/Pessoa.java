package com.spy.pessoa.domain;

import jakarta.persistence.*;

@Entity
@Table(name = "pessoas")
public class Pessoa {

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private Long id;
  private String nome;
  private int idade;

  public Pessoa() {}

  public Long getId() {
    return id;
  }
  public String getNome() {
    return nome;
  }

  public void setNome(String nome) {
    this.nome = nome;
  }

  public int getIdade() {
    return idade;
  }

  public void setIdade(int idade) {
    this.idade = idade;
  }

  @Override
  public String toString() {
    return "Pessoa{" +
      "id=" + id +
      ", nome='" + nome + '\'' +
      ", idade=" + idade +
      '}';
  }
}
