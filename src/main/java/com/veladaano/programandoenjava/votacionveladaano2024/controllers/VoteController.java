package com.veladaano.programandoenjava.votacionveladaano2024.controllers;

import java.time.Duration;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.thymeleaf.spring6.context.webflux.ReactiveDataDriverContextVariable;

import com.veladaano.programandoenjava.votacionveladaano2024.services.VoteService;

import reactor.core.publisher.Flux;

@Controller
@RequestMapping
public class VoteController {
	
	final VoteService voteService;
	
	public VoteController(VoteService voteService) {
		this.voteService = voteService;
	}

	@GetMapping("/")
	public String index(final Model model) {
		final var flux = voteService.fetchVotes();
		
		final var reactiveDataDrivenMode = new ReactiveDataDriverContextVariable(flux, 1);
		
		model.addAttribute("votes", reactiveDataDrivenMode);

		return "index";
	}
}
