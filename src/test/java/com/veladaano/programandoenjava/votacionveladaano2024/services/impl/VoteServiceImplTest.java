package com.veladaano.programandoenjava.votacionveladaano2024.services.impl;

import com.veladaano.programandoenjava.votacionveladaano2024.dto.VoteResponse;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;
import reactor.test.StepVerifier;


@ExtendWith(MockitoExtension.class)
class VoteServiceImplTest {
    @InjectMocks
    VoteServiceImpl voteServiceImpl;


    @Test
    void testResponsePercentage50Percent() {
        var team1Votes = 10;
        var team2Votes = 10;
        StepVerifier.create(
                        voteServiceImpl.responsePercentage(team1Votes, team2Votes)
                )
                .expectNext(new VoteResponse(50.00, 50.00))
                .expectComplete();

    }


    @Test
    void testResponsePercentage40PercentTeam160PercentTeam2() {
        var team1Votes = 40;
        var team2Votes = 60;
        StepVerifier.create(
                        voteServiceImpl.responsePercentage(team1Votes, team2Votes)
                )
                .expectNext(new VoteResponse(40.00, 60.00))
                .expectComplete();

    }
}
