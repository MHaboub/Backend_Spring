package com.gestionformation.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.gestionformation.dto.FormationDTO;
import com.gestionformation.models.Formation;
import com.gestionformation.services.FormationService;
import java.util.List;

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
}
