package com.example.companiescrudms.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;

@Entity()
@Table(name = "company")
@JsonPropertyOrder({"id", "name", "founder", "logo", "foundation_date"})
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String founder;
    private String logo;
    private LocalDate foundation_date;
    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    @JsonManagedReference
    private List<WebSite> webSites;

    public Company() {
    }

    public Company(String name, String founder, String logo, LocalDate foundation_date) {
        this.name = name;
        this.founder = founder;
        this.logo = logo;
        this.foundation_date = foundation_date;
    }

    public Company(Long id, String name, String founder, String logo, LocalDate foundation_date) {
        this.id = id;
        this.name = name;
        this.founder = founder;
        this.logo = logo;
        this.foundation_date = foundation_date;
    }

    public Company(Long id, String name, String founder, String logo, LocalDate foundation_date, List<WebSite> webSites) {
        this.id = id;
        this.name = name;
        this.founder = founder;
        this.logo = logo;
        this.foundation_date = foundation_date;
        this.webSites = webSites;
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

    public List<WebSite> getWebSites() {
        return webSites;
    }

    public void setWebSites(List<WebSite> webSites) {
        this.webSites = webSites;
    }
}
