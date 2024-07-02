package com.veladaano.programandoenjava.votacionveladaano2024.repositories;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("votes")
public class VoteDocument {

  @Id
  private String id;

  private Long countTeam1;

  private Long countTeam2;

  public String getId() {
    return id;
  }

  public Long getCountTeam1() {
    return countTeam1;
  }

  public void setCountTeam1(Long countTeam1) {
    this.countTeam1 = countTeam1;
  }

  public Long getCountTeam2() {
    return countTeam2;
  }

  public void setCountTeam2(Long countTeam2) {
    this.countTeam2 = countTeam2;
  }

  @Override
  public int hashCode() {
    final int prime = 31;
    int result = 1;
    result = prime * result + ((id == null) ? 0 : id.hashCode());
    result =
      prime * result + ((countTeam1 == null) ? 0 : countTeam1.hashCode());
    result =
      prime * result + ((countTeam2 == null) ? 0 : countTeam2.hashCode());
    return result;
  }

  @Override
  public boolean equals(Object obj) {
    if (this == obj) return true;
    if (obj == null) return false;
    if (getClass() != obj.getClass()) return false;
    VoteDocument other = (VoteDocument) obj;
    if (id == null) {
      if (other.id != null) return false;
    } else if (!id.equals(other.id)) return false;
    if (countTeam1 == null) {
      if (other.countTeam1 != null) return false;
    } else if (!countTeam1.equals(other.countTeam1)) return false;
    if (countTeam2 == null) {
      if (other.countTeam2 != null) return false;
    } else if (!countTeam2.equals(other.countTeam2)) return false;
    return true;
  }
}
