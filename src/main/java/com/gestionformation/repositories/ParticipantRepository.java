package com.gestionformation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.gestionformation.models.Participant;
import java.util.List;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {
    // Removed method causing error: no 'user' property in Participant entity
    // List<Participant> findAllByOrderByUser_LastNameAsc();

    Participant findByIdAndDeletedFalse(Long id);

    List<Participant> findByFormationId(Long formationId);

    // Participant findByUserId(Long id);
}
