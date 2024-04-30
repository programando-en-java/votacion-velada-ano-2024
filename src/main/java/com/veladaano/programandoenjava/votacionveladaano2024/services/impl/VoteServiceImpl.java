package com.veladaano.programandoenjava.votacionveladaano2024.services.impl;

import com.veladaano.programandoenjava.votacionveladaano2024.dto.VoteRequest;
import com.veladaano.programandoenjava.votacionveladaano2024.dto.VoteResponse;
import com.veladaano.programandoenjava.votacionveladaano2024.repositories.VoteDocument;
import com.veladaano.programandoenjava.votacionveladaano2024.repositories.VoteRepository;
import com.veladaano.programandoenjava.votacionveladaano2024.services.VoteService;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.Duration;
import java.util.List;
import java.util.Optional;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.stereotype.Service;

@Service
public class VoteServiceImpl implements VoteService {

  private final VoteRepository voteRepository;

  public VoteServiceImpl(final VoteRepository voteRepository) {
    this.voteRepository = voteRepository;
  }

  @Override
  public VoteResponse getVotes(String teamId) throws NotFoundException {
    final VoteDocument voteDocument = findById(teamId);
    return mapVoteDocumentToVoteResponse(voteDocument);
  }

  @Override
  public VoteResponse saveVote(VoteRequest voteRequest)
    throws NotFoundException {
    final VoteDocument voteDocument = findById(voteRequest.teamId());
    final var countTeam1 = voteDocument.getCountTeam1() + 1;
    voteDocument.setCountTeam1(countTeam1);
    final var saved = voteRepository.save(voteDocument);
    return mapVoteDocumentToVoteResponse(saved);
  }

  private VoteDocument findById(String teamId) throws NotFoundException {
    final Optional<VoteDocument> result = voteRepository.findById(teamId);
    if (result.isEmpty()) {
      throw new NotFoundException();
    }
    return result.get();
  }

  private VoteResponse mapVoteDocumentToVoteResponse(
    final VoteDocument voteDocument
  ) {
    final long totalVotes =
      voteDocument.getCountTeam1() + voteDocument.getCountTeam2();

    final double porcentajeTeam1 = calcularPorcentaje(
      voteDocument.getCountTeam1(),
      totalVotes
    );

    final double porcentajeTeam2 = calcularPorcentaje(
      voteDocument.getCountTeam2(),
      totalVotes
    );

    final double porcentajeDecimalTeam1 = porcentajeTeam1 / 100;
    final double porcentajeDecimalTeam2 = porcentajeTeam2 / 100;

    return new VoteResponse(porcentajeDecimalTeam1, porcentajeDecimalTeam2);
  }

  private long calcularPorcentaje(final long x, final long total) {
    return x * 100 / total;
  }
}
