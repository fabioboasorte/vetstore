package com.br.vetstore;

import org.springframework.data.repository.CrudRepository;

import com.br.vetstore.Animals;

public interface AnimalsRepository extends CrudRepository<Animals, Integer> {}