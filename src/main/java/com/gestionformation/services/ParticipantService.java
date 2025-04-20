package com.gestionformation.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.gestionformation.models.Participant;
import com.gestionformation.repositories.ParticipantRepository;
import java.util.List;

@Service
public class ParticipantService {

    @Autowired
    private ParticipantRepository participantRepository;

    // public List<Participant> getAllParticipants() {
    // return participantRepository.findAllByOrderByUser_LastNameAsc();
    // }

    public Participant getParticipant(Long id) {
        return participantRepository.findByIdAndDeletedFalse(id);
    }

    public Participant addParticipant(Participant participant) {
        return participantRepository.save(participant);
    }

    public Participant updateParticipant(Long id, Participant participantDetails) {
        Participant participant = getParticipant(id);
        if (participant == null) {
            throw new IllegalArgumentException("Participant not found");
        }

        participant.setStructure(participantDetails.getStructure());
        participant.setProfile(participantDetails.getProfile());
        participant.setFormation(participantDetails.getFormation());

        return participantRepository.save(participant);
    }

    public void deleteParticipant(Long id) {
        Participant participant = getParticipant(id);
        if (participant != null) {
            participant.setDeleted(true);
            participantRepository.save(participant);
        }
    }

    public List<Participant> findByFormationId(Long formationId) {
        return participantRepository.findByFormationId(formationId);
    }

}
