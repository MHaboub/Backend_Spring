package com.gestionformation.services;

import com.gestionformation.models.*;
import com.gestionformation.repositories.*;
import com.gestionformation.dto.FormationDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class FormationService {

    @Autowired
    private FormationRepository formationRepository;

    public FormationDTO createFormation(Formation formation) {
        if (formation.getDurationDays() <= 0) {
            throw new IllegalArgumentException("Duration must be positive");
        }
        Formation savedFormation = formationRepository.save(formation);
        return convertToDTO(savedFormation);
    }

    public List<FormationDTO> getAllFormations() {
        List<Formation> formations = formationRepository.findAll();
        return formations.stream()
                .map(this::convertToDTO)
                .collect(Collectors.toList());
    }

    private FormationDTO convertToDTO(Formation formation) {
        FormationDTO dto = new FormationDTO();
        dto.setId(formation.getId());
        dto.setDomain(formation.getDomain());
        dto.setStartDate(formation.getStartDate());
        dto.setDurationDays(formation.getDurationDays());
        dto.setLieu(formation.getLieu());
        dto.setTime(formation.getTime());
        return dto;
    }
}
