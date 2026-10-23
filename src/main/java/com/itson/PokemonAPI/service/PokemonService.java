package com.itson.PokemonAPI.service;

import com.itson.PokemonAPI.model.Pokemon;
import com.itson.PokemonAPI.repository.PokemonRepository;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PokemonService {

  @Autowired
  private PokemonRepository pokemonRepository;

  public List<Pokemon> listar() {
    return pokemonRepository.findAll();
  }

  public Optional<Pokemon> listarPorId(Long id) {
    return pokemonRepository.findById(id);
  }

  public Pokemon guardar(Pokemon pokemon) {
    return pokemonRepository.save(pokemon);
  }
}
