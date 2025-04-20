package com.gestionformation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gestionformation.models.Participant;
import com.gestionformation.services.ParticipantService;
import java.util.List;

@RestController
@RequestMapping("/api/participants")
public class ParticipantController {

    @Autowired
    private ParticipantService participantService;

    // @GetMapping
    // public List<Participant> getAllParticipants() {
    // return participantService.getAllParticipants();
    // }

    @GetMapping("/{id}")
    public ResponseEntity<Participant> getParticipant(@PathVariable Long id) {
        Participant participant = participantService.getParticipant(id);
        if (participant != null) {
            return ResponseEntity.ok(participant);
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Participant createParticipant(@RequestBody Participant participant) {
        return participantService.addParticipant(participant);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Participant> updateParticipant(
            @PathVariable Long id,
            @RequestBody Participant participantDetails) {
        Participant updatedParticipant = participantService.updateParticipant(id, participantDetails);
        if (updatedParticipant != null) {
            return ResponseEntity.ok(updatedParticipant);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteParticipant(@PathVariable Long id) {
        participantService.deleteParticipant(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/formation/{formationId}")
    public ResponseEntity<List<Participant>> getParticipantsByFormation(@PathVariable Long formationId) {
        List<Participant> participants = participantService.findByFormationId(formationId);
        if (!participants.isEmpty()) {
            return ResponseEntity.ok(participants);
        }
        return ResponseEntity.notFound().build();
    }

}
