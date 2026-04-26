package com.example.reportms.models;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Company {
    private Long id;
    private String name;
    private String founder;
    private String logo;
    private LocalDate foundation_date;
    private List<WebSite> webSites = new ArrayList<>();

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
