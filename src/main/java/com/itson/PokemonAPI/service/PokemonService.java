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

  public Optional<Pokemon> actualizar(Long id, Pokemon pokemonActualizado) {
    return pokemonRepository.findById(id).map(pokemonExistente -> {
      pokemonExistente.setNombre(pokemonActualizado.getNombre());
      pokemonExistente.setTipo(pokemonActualizado.getTipo());
      pokemonExistente.setNivel(pokemonActualizado.getNivel());
      pokemonExistente.setDefensa(pokemonActualizado.getDefensa());
      pokemonExistente.setDescripcion(pokemonActualizado.getDescripcion());
      return pokemonRepository.save(pokemonExistente);
    });
  }

  public Optional<Pokemon> actualizarParcial(Long id, Pokemon pokemonParcial) {
    return pokemonRepository.findById(id).map(pokemonExistente -> {
      if (pokemonParcial.getNombre() != null) {
        pokemonExistente.setNombre(pokemonParcial.getNombre());
      }
      if (pokemonParcial.getTipo() != null) {
        pokemonExistente.setTipo(pokemonParcial.getTipo());
      }
      if (pokemonParcial.getNivel() != null) {
        pokemonExistente.setNivel(pokemonParcial.getNivel());
      }
      if (pokemonParcial.getDefensa() != null) {
        pokemonExistente.setDefensa(pokemonParcial.getDefensa());
      }
      if (pokemonParcial.getDescripcion() != null) {
        pokemonExistente.setDescripcion(pokemonParcial.getDescripcion());
      }
      return pokemonRepository.save(pokemonExistente);
    });
  }

  public boolean eliminar(Long id) {
    if (pokemonRepository.existsById(id)) {
      pokemonRepository.deleteById(id);
      return true;
    }
    return false;
  }
}
