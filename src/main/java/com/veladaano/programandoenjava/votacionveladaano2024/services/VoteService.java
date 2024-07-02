package com.veladaano.programandoenjava.votacionveladaano2024.services;

import com.veladaano.programandoenjava.votacionveladaano2024.dto.VoteRequest;
import com.veladaano.programandoenjava.votacionveladaano2024.dto.VoteResponse;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

public interface VoteService {
  VoteResponse getVotes(String teamId) throws NotFoundException;
  VoteResponse saveVote(VoteRequest voteRequest) throws NotFoundException;
}
