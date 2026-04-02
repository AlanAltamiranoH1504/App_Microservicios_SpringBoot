package com.example.companiescrudms.models.dto.companie;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import org.hibernate.validator.constraints.Length;

import java.time.LocalDate;

public class UpdateCompanyDTO  {
    @NotNull(message = "El id de la compañia es requerido")
    @Positive(message = "El id de la compañia no es valido")
    public Long idCompany;

    @NotBlank(message = "El nombre es requerido")
    @Length(max = 32, message = "El nombre no puede ser mayor a 32 caracteres")
    private String name;

    @NotBlank(message = "El fundador es requerido")
    @Length(max = 128, message = "El nombre del fundador no puede ser mayor a 128 caracteres")
    private String founder;

    @NotBlank(message = "El logo es requerido")
    @Length(max = 255, message = "El logo no puede ser mayor a 255 caracteres")
    private String logo;

    @NotNull(message = "La fecha de fundacion es requerida")
    private LocalDate foundation_date;

    public Long getIdCompany() {
        return idCompany;
    }

    public void setIdCompany(Long idCompany) {
        this.idCompany = idCompany;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFounder() {
        return founder;
    }

    public void setFounder(String founder) {
        this.founder = founder;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public LocalDate getFoundation_date() {
        return foundation_date;
    }

    public void setFoundation_date(LocalDate foundation_date) {
        this.foundation_date = foundation_date;
    }
}
