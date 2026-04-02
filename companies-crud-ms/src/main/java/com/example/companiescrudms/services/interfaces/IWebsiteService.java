package com.example.companiescrudms.services.interfaces;

import com.example.companiescrudms.models.WebSite;
import com.example.companiescrudms.models.dto.website.CreateWebsiteDTO;

import java.util.List;

public interface IWebsiteService {
    public abstract List<WebSite> findAll();
    public abstract WebSite findById(Long idWebSite);
    public abstract List<WebSite> findByCompanyId(Long idCompany);
    public abstract WebSite save(CreateWebsiteDTO createWebsiteDTO);
    public abstract boolean delete(Long idWebSite);
}
