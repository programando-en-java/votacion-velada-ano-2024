package com.veladaano.programandoenjava.votacionveladaano2024.services;

import com.veladaano.programandoenjava.votacionveladaano2024.dto.VoteResponse;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;

@Service
public class VoteService {

    final List<VoteResponse> voteList = List.of(new VoteResponse(10.0, 90.0), new VoteResponse(20.0, 80.0),
            new VoteResponse(30.0, 70.0), new VoteResponse(40.0, 60.0), new VoteResponse(50.0, 50.0));
    final Flux<VoteResponse> votes = Flux.fromIterable(voteList).delayElements(Duration.ofSeconds(2));

    public Flux<VoteResponse> fetchVotes() {
        return votes;
    }
}
