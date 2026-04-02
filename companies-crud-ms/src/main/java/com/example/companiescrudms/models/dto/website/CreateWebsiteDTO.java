package com.example.companiescrudms.models.dto.website;

import jakarta.validation.constraints.NotBlank;
import org.hibernate.validator.constraints.Length;

public class CreateWebsiteDTO {
    @NotBlank(message = "El nombre del website es requerido")
    @Length(max = 32, message = "El nombre del website no puede ser mayor a 32 caracteres")
    private String name;

    @NotBlank(message = "La categoria es requerida")
    @Length(max = 32, message = "El nombre de la categoria no puede ser mayor a 32 caracteres")
    private String category;

    @NotBlank(message = "La descripcióin del website es requerida")
    @Length(max = 5000, message = "La descripción no puede ser mayor a 5000 caracteres")
    private String description;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
