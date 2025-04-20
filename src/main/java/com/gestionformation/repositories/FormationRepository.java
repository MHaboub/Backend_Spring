package com.gestionformation.repositories;

import com.gestionformation.models.Formation;
import com.gestionformation.models.Domain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface FormationRepository extends JpaRepository<Formation, Long> {
    List<Formation> findByDomain(Domain domain);

    @Query("SELECT p.formation FROM Participant p WHERE p.id = :participantId")
    List<Formation> findByParticipantId(@Param("participantId") Long participantId);
}