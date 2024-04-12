package com.veladaano.programandoenjava.votacionveladaano2024.controllers;

import com.veladaano.programandoenjava.votacionveladaano2024.services.VoteService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;

@Controller
@RequestMapping
public class IndexController {

  @GetMapping("/")
  public String index(final Model model) {
    return "index";
  }
}
