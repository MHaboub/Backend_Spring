package com.gestionformation.controllers;

import com.gestionformation.services.FormationService;
import com.gestionformation.services.ParticipantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.HashMap;
import java.util.Map;

@RestController
public class HomeController {

    @Autowired
    private FormationService formationService;

    @Autowired
    private ParticipantService participantService;

    @GetMapping("/")
    public String home() {
        return "Welcome to the Formation Management System API";
    }

    @GetMapping("/api/stats")
    public Map<String, Integer> getStats() {
        Map<String, Integer> stats = new HashMap<>();
        stats.put("formations", formationService.getAllFormations().size());
        // stats.put("participants", participantService.getAllParticipants().size());
        // Assuming formateurs is a count of unique trainers, implement logic as needed
        stats.put("formateurs", 0); // Placeholder for formateurs count
        return stats;
    }
}
