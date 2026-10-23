package com.itson.PokemonAPI.controller;

import com.itson.PokemonAPI.model.Pokemon;
import com.itson.PokemonAPI.service.PokemonService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/pokemones")
public class PokemonController {

  @Autowired
  private PokemonService pokemonService;

  @GetMapping
  public List<Pokemon> listar() {
    return pokemonService.listar();
  }

  @GetMapping("/{id}")
  public Pokemon listarPorId(@PathVariable Long id) {
    return pokemonService.listarPorId(id).orElse(null);
  }

  @PostMapping
  public Pokemon crear(@RequestBody Pokemon pokemon) {
    return pokemonService.guardar(pokemon);
  }

  @PutMapping("/{id}")
  public Pokemon actualizar(@PathVariable Long id, @RequestBody Pokemon pokemon) {
    return pokemonService.actualizar(id, pokemon).orElse(null);
  }

  @PatchMapping("/{id}")
  public Pokemon actualizarParcial(@PathVariable Long id, @RequestBody Pokemon pokemon) {
    return pokemonService.actualizarParcial(id, pokemon).orElse(null);
  }

  @DeleteMapping("/{id}")
  public void eliminar(@PathVariable Long id) {
    pokemonService.eliminar(id);
  }
}
