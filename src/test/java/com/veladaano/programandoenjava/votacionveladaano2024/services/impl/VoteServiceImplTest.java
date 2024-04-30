package com.veladaano.programandoenjava.votacionveladaano2024.services.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.veladaano.programandoenjava.votacionveladaano2024.dto.VoteResponse;
import com.veladaano.programandoenjava.votacionveladaano2024.repositories.VoteDocument;
import com.veladaano.programandoenjava.votacionveladaano2024.repositories.VoteRepository;
import java.util.Optional;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;

@ExtendWith(MockitoExtension.class)
public class VoteServiceImplTest {

  @Mock
  private VoteRepository voteRepository;

  @InjectMocks
  private VoteServiceImpl service;

  @DisplayName(
    """
          DADO un id de equipo
          CUANDO llamamos a `getVotes`
          ENTONCES esperamos que nos devuelva 0.0 y 1.0 de porcentaje de votos
          ya que para el equipo los votos son 0 y 1 
          """
  )
  @Test
  public void getVotes1() throws NotFoundException {
    final String equipoId = "equipoId";
    final VoteResponse esperado = new VoteResponse(0.0D, 1.0D);
    final VoteDocument documentoEquipo = new VoteDocument();
    documentoEquipo.setCountTeam1(0L);
    documentoEquipo.setCountTeam2(1L);

    when(voteRepository.findById(equipoId))
      .thenReturn(Optional.of(documentoEquipo));

    final VoteResponse resultado = service.getVotes(equipoId);

    verify(voteRepository).findById(equipoId);

    assertEquals(esperado, resultado);
  }

  @DisplayName(
    """
          DADO un id de equipo
          CUANDO llamamos a `getVotes`
          ENTONCES esperamos que nos devuelva 0.5 y 0.5 de porcentaje de votos
          ya que para el equipo los votos son 1 y 1 
          """
  )
  @Test
  public void getVotes2() throws NotFoundException {
    final String equipoId = "equipoId";
    final VoteResponse esperado = new VoteResponse(0.5D, 0.5D);
    final VoteDocument documentoEquipo = new VoteDocument();
    documentoEquipo.setCountTeam1(1L);
    documentoEquipo.setCountTeam2(1L);

    when(voteRepository.findById(equipoId))
      .thenReturn(Optional.of(documentoEquipo));

    final VoteResponse resultado = service.getVotes(equipoId);

    verify(voteRepository).findById(equipoId);

    assertEquals(esperado, resultado);
  }
}
