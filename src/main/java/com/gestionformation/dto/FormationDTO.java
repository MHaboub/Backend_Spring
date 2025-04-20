package com.gestionformation.dto;

import com.gestionformation.models.Domain;
import java.time.LocalDate;

public class FormationDTO {
    private Long id;
    private Domain domain;
    private LocalDate startDate;
    private Integer durationDays;
    private String lieu;
    private String time;

    public FormationDTO() {
    }

    public FormationDTO(Long id, Domain domain, LocalDate startDate, Integer durationDays, String lieu, String time) {
        this.id = id;
        this.domain = domain;
        this.startDate = startDate;
        this.durationDays = durationDays;
        this.lieu = lieu;
        this.time = time;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Domain getDomain() {
        return domain;
    }

    public void setDomain(Domain domain) {
        this.domain = domain;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Integer getDurationDays() {
        return durationDays;
    }

    public void setDurationDays(Integer durationDays) {
        this.durationDays = durationDays;
    }

    public String getLieu() {
        return lieu;
    }

    public void setLieu(String lieu) {
        this.lieu = lieu;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
