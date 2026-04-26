package com.example.reportms.models;

import com.fasterxml.jackson.annotation.JsonBackReference;

public class WebSite {
    private Long id;
    private String name;
    private String category;
    private String description;

    @JsonBackReference
    private Company company;

    public WebSite() {
    }

    public WebSite(String name, String category, String description, Company company) {
        this.name = name;
        this.category = category;
        this.description = description;
        this.company = company;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    @Override
    public String toString() {
        return "WebSite{" +
                ", name='" + name + '\'' +
                ", category='" + category + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}
