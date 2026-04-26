package com.example.reportms.models.dto.company;

import com.example.reportms.models.dto.company.website.CreateWebsiteDTO;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CreateCompanyDTO {
//    @NotBlank(message = "El nombre es requerido")
//    @Length(max = 32, message = "El nombre no puede ser mayor a 32 caracteres")
    private String name;

//    @NotBlank(message = "El fundador es requerido")
//    @Length(max = 128, message = "El nombre del fundador no puede ser mayor a 128 caracteres")
    private String founder;

//    @NotBlank(message = "El logo es requerido")
//    @Length(max = 255, message = "El logo no puede ser mayor a 255 caracteres")
    private String logo;

//    @NotNull(message = "La fecha de fundacion es requerida")
    private LocalDate foundation_date;


    public CreateCompanyDTO(String name, String founder, String logo, LocalDate foundation_date, List<CreateWebsiteDTO> websites) {
        this.name = name;
        this.founder = founder;
        this.logo = logo;
        this.foundation_date = foundation_date;
        this.websites = websites;
    }

    //    @NotEmpty(message = "Los websites son requeridos")
//    @Valid
    private List<CreateWebsiteDTO> websites = new ArrayList<>();

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

    public List<CreateWebsiteDTO> getWebsites() {
        return websites;
    }

    public void setWebsites(List<CreateWebsiteDTO> websites) {
        this.websites = websites;
    }
}
