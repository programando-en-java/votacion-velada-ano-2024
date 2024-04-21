package com.veladaano.programandoenjava.votacionveladaano2024.services.impl;

import com.veladaano.programandoenjava.votacionveladaano2024.dto.VoteResponse;
import com.veladaano.programandoenjava.votacionveladaano2024.services.VoteService;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.math.BigDecimal;
import java.math.RoundingMode;
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

    public Mono<VoteResponse> responsePercentage(Integer team1, Integer team2) {
        BigDecimal total = new BigDecimal(team1 + team2);
        return Mono.just(new VoteResponse(
                calculatePercentage(total, new BigDecimal(team1)).doubleValue(),
                calculatePercentage(total, new BigDecimal(team2)).doubleValue()));
    }

    private BigDecimal calculatePercentage(BigDecimal total, BigDecimal teamVotes) {
        return teamVotes.divide(total, 4, RoundingMode.HALF_UP)
                .multiply(BigDecimal.valueOf(100)).setScale(4, RoundingMode.HALF_UP);
    }
}
