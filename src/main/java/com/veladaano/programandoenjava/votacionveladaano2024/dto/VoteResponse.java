package com.veladaano.programandoenjava.votacionveladaano2024.dto;

/**
 * @param fighter1 represents the percentage of votes for the fighter 1
 * @param fighter2 represents the percentage of votes for the fighter 2
 */
public record VoteResponse(String matchId, Double fighter1, Double fighter2) {

}
