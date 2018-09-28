package com.andrade.repository;

import org.springframework.data.repository.CrudRepository;

import com.andrade.model.Pessoa;

public interface PessoaRepository  extends CrudRepository<Pessoa,Integer>{
}
