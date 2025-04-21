package com.gestionformation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gestionformation.dto.FormationDTO;
import com.gestionformation.models.Formation;
import com.gestionformation.services.FormationService;
import java.util.List;
import java.util.Map;
import java.util.HashMap;

@RestController
@RequestMapping("/api/formations")
public class FormationController {
    @Autowired
    private FormationService formationService;

    @GetMapping
    public ResponseEntity<List<FormationDTO>> getAll() {
        return ResponseEntity.ok(formationService.getAllFormations());
    }

    @PostMapping
    public ResponseEntity<FormationDTO> create(@RequestBody Formation formation) {
        return ResponseEntity.ok(formationService.createFormation(formation));
    }

    @GetMapping("/stats")
    public ResponseEntity<Map<String, Integer>> getFormationStats() {
        Map<String, Integer> stats = new HashMap<>();
        stats.put("completed", formationService.getFormationsCompleted());
        stats.put("current", formationService.getCurrentFormations());
        stats.put("upcoming", formationService.getUpcomingFormations());
        return ResponseEntity.ok(stats);
    }

    @GetMapping("/stats/completed")
    public ResponseEntity<Integer> getCompletedFormationsCount() {
        return ResponseEntity.ok(formationService.getFormationsCompleted());
    }

    @GetMapping("/stats/current")
    public ResponseEntity<Integer> getCurrentFormationsCount() {
        return ResponseEntity.ok(formationService.getCurrentFormations());
    }

    @GetMapping("/stats/upcoming")
    public ResponseEntity<Integer> getUpcomingFormationsCount() {
        return ResponseEntity.ok(formationService.getUpcomingFormations());
    }
}
