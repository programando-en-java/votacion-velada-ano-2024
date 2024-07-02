package com.veladaano.programandoenjava.votacionveladaano2024.controllers;

import com.veladaano.programandoenjava.votacionveladaano2024.dto.FighterModel;
import com.veladaano.programandoenjava.votacionveladaano2024.dto.MatchRequest;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping
public class IndexController {

  final List<FighterModel> luchadores = List.of(
    new FighterModel(UUID.randomUUID(), "Carrera"),
    new FighterModel(UUID.randomUUID(), "Agustín51"),
    new FighterModel(UUID.randomUUID(), "La Cobra"),
    new FighterModel(UUID.randomUUID(), "Guanyar"),
    new FighterModel(UUID.randomUUID(), "Zeling"),
    new FighterModel(UUID.randomUUID(), "Nisaxter"),
    new FighterModel(UUID.randomUUID(), "Alana"),
    new FighterModel(UUID.randomUUID(), "Amablitz"),
    new FighterModel(UUID.randomUUID(), "Shelao"),
    new FighterModel(UUID.randomUUID(), "Viruzz"),
    new FighterModel(UUID.randomUUID(), "YoSoyPlex"),
    new FighterModel(UUID.randomUUID(), "Mariana"),
    new FighterModel(UUID.randomUUID(), "Skain"),
    new FighterModel(UUID.randomUUID(), "Karchez"),
    new FighterModel(UUID.randomUUID(), "Peldanyos"),
    new FighterModel(UUID.randomUUID(), "Roberto Cein"),
    new FighterModel(UUID.randomUUID(), "Aldo Geo"),
    new FighterModel(UUID.randomUUID(), "Karchez"),
    new FighterModel(UUID.randomUUID(), "Pelicanger"),
    new FighterModel(UUID.randomUUID(), "Unicornio"),
    new FighterModel(UUID.randomUUID(), "Will"),
    new FighterModel(UUID.randomUUID(), "Sezar Blue"),
    new FighterModel(UUID.randomUUID(), "Karchez"),
    new FighterModel(UUID.randomUUID(), "Karchez")
  );

  @GetMapping("/")
  public String index(final Model model) {
    return "index";
  }

  @GetMapping("/admin")
  public String admin(final Model model) {
    model.addAttribute("fighters", luchadores);
    return "admin";
  }

  @PostMapping(
    path = "/matches",
    consumes = { MediaType.APPLICATION_FORM_URLENCODED_VALUE }
  )
  public String postMaches() {
    System.out.println("Hola mundo ");
    return "admin";
  }
}
