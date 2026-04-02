package com.example.companiescrudms.controllers;

import com.example.companiescrudms.models.WebSite;
import com.example.companiescrudms.services.interfaces.IWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.AfterDomainEventPublication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/web-site")
public class WebsiteController {
    @Autowired
    private IWebsiteService iWebsiteService;

    @GetMapping("")
    public List<WebSite> findAll() {
        return iWebsiteService.findAll();
    }

    @GetMapping("{idWebSite}")
    public WebSite findById(@PathVariable Long idWebSite) {
        return iWebsiteService.findById(idWebSite);
    }

    @GetMapping("/by-company/{idCompany}")
    public List<WebSite> findByCompany(@PathVariable Long idCompany) {
        return iWebsiteService.findByCompanyId(idCompany);
    }
}
