package com.veladaano.programandoenjava.votacionveladaano2024.controllers;

import com.veladaano.programandoenjava.votacionveladaano2024.dto.VoteRequest;
import com.veladaano.programandoenjava.votacionveladaano2024.dto.VoteResponse;
import com.veladaano.programandoenjava.votacionveladaano2024.services.VoteService;
import java.util.UUID;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

@Controller
public class WSVoteController {

  private final VoteService voteService;

  public WSVoteController(VoteService voteService) {
    this.voteService = voteService;
  }


  @MessageMapping("/votes")
  @SendTo("/topic/votes")
  public VoteResponse greeting(VoteRequest voteRequest) throws Exception {
    return voteService.saveVote(voteRequest);
  }
}
