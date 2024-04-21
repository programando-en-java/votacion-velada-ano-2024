package com.veladaano.programandoenjava.votacionveladaano2024.services.impl;

import com.veladaano.programandoenjava.votacionveladaano2024.dto.VoteResponse;
import com.veladaano.programandoenjava.votacionveladaano2024.services.VoteService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.List;

@Service
public class VoteServiceImpl implements VoteService {



    final List<VoteResponse> voteList = List.of(new VoteResponse(10.0, 90.0), new VoteResponse(20.0, 80.0),
            new VoteResponse(30.0, 70.0), new VoteResponse(40.0, 60.0), new VoteResponse(50.0, 50.0));
    final Flux<VoteResponse> votes = Flux.fromIterable(voteList).delayElements(Duration.ofSeconds(2));

    public Flux<VoteResponse> fetchVotes() {
        return votes;
    }

    public Mono<VoteResponse> responsePercentage(Integer team1, Integer team2){
        Integer total = team1+team2;
        return Mono.just(new VoteResponse(
                calculatePercentage(total.doubleValue(), team1.doubleValue()),
                calculatePercentage(total.doubleValue(), team2.doubleValue())));
    }

    private Double calculatePercentage(Double total, Double teamVotes){
        return (teamVotes/total)*100;
    }
}
