package com.veladaano.programandoenjava.votacionveladaano2024.services;

import com.veladaano.programandoenjava.votacionveladaano2024.dto.VoteResponse;
import reactor.core.publisher.Mono;

public interface VoteService {
    Mono<VoteResponse> responsePercentage(Integer team1, Integer team2);
}
