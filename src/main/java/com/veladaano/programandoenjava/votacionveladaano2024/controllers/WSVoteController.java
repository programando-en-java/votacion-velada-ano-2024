package com.veladaano.programandoenjava.votacionveladaano2024.controllers;

import com.veladaano.programandoenjava.votacionveladaano2024.dto.VoteRequest;
import com.veladaano.programandoenjava.votacionveladaano2024.dto.VoteResponse;
import com.veladaano.programandoenjava.votacionveladaano2024.services.VoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.UUID;

@Controller
public class WSVoteController {

  private static int team1 = 0;
  private static int team2 = 0;
  private static final UUID team1UUID = UUID.fromString(
    "f65d4f2a-958b-4d94-9d71-61529c6fa1d6"
  );

  private static final UUID team2UUID = UUID.fromString(
    "bc544e5d-3139-47c0-92b7-b41e1825b510"
  );


  private final VoteService voteService;

  @Autowired
  public WSVoteController(final VoteService voteService){
    this.voteService = voteService;
  }

  @MessageMapping("/votes")
  @SendTo("/topic/votes")
  public VoteResponse greeting(VoteRequest message) throws Exception {
    if (message.teamId().equals(team1UUID)) {
      team1++;
    } else {
      team2++;
    }
    return voteService.responsePercentage(team1,team2).block();
  }
}
