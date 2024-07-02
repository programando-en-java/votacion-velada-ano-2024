package com.veladaano.programandoenjava.votacionveladaano2024.services.impl;

import com.veladaano.programandoenjava.votacionveladaano2024.dto.VoteRequest;
import com.veladaano.programandoenjava.votacionveladaano2024.dto.VoteResponse;
import com.veladaano.programandoenjava.votacionveladaano2024.repositories.VoteDocument;
import com.veladaano.programandoenjava.votacionveladaano2024.repositories.VoteRepository;
import com.veladaano.programandoenjava.votacionveladaano2024.services.VoteService;
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
  public VoteResponse saveVote(VoteRequest voteRequest) throws NotFoundException {
    VoteDocument saved = null;
    try {
      final VoteDocument voteDocument = findById(voteRequest.matchId());
      saved = saveVote(voteDocument, voteRequest.teamId());
    } catch (NotFoundException ex) {
      final var document = new VoteDocument();
      if ("f65d4f2a-958b-4d94-9d71-61529c6fa1d6".equals(voteRequest.teamId())) {
        document.setCountTeam1(1L);
      } else {
        document.setCountTeam1(0L);
      }

      if ("bc544e5d-3139-47c0-92b7-b41e1825b510".equals(voteRequest.teamId())) {
        document.setCountTeam2(1L);
      } else {
        document.setCountTeam2(0L);
      }
      saved = voteRepository.save(document);
    }
    return mapVoteDocumentToVoteResponse(saved);
  }

  private VoteDocument saveVote(VoteDocument voteDocument, String teamId) {
    if (voteDocument.getCountTeam1() == null) {
      voteDocument.setCountTeam1(0L);
    }

    if (voteDocument.getCountTeam2() == null) {
      voteDocument.setCountTeam2(0L);
    }

    if ("f65d4f2a-958b-4d94-9d71-61529c6fa1d6".equals(teamId)) {
      voteDocument.setCountTeam1(voteDocument.getCountTeam1() + 1);
    }

    if ("bc544e5d-3139-47c0-92b7-b41e1825b510".equals(teamId)) {
      voteDocument.setCountTeam2(voteDocument.getCountTeam2() + 1);
    }
    return voteRepository.save(voteDocument);
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

    return new VoteResponse(
      voteDocument.getId(),
      porcentajeTeam1,
      porcentajeTeam2
    );
  }

  private double calcularPorcentaje(final long x, final long total) {
    return (double) (x * 100) / total;
  }
}
