package com.example.companiescrudms.services;

import com.example.companiescrudms.exceptions.ListEmptyException;
import com.example.companiescrudms.exceptions.NotFoundEntityException;
import com.example.companiescrudms.models.WebSite;
import com.example.companiescrudms.models.dto.website.CreateWebsiteDTO;
import com.example.companiescrudms.repositories.IWebsiteRepository;
import com.example.companiescrudms.services.interfaces.IWebsiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class WebsiteService implements IWebsiteService {
    @Autowired
    private IWebsiteRepository iWebsiteRepository;

    @Override
    public List<WebSite> findAll() {
        List<WebSite> websites = iWebsiteRepository.findAll();
        if (websites.isEmpty()) {
            throw new ListEmptyException("La lista de sitios web se encuentra vacia");
        }
        return websites;
    }

    @Override
    public WebSite findById(Long idWebSite) {
        Optional<WebSite> webSite = iWebsiteRepository.findById(idWebSite);
        if (webSite.isEmpty()) {
            throw new NotFoundEntityException("No existe un website con el id: " + idWebSite);
        }
        return webSite.get();
    }

    @Override
    public List<WebSite> findByCompanyId(Long idCompany) {
        List<WebSite> webSitesByCompany = iWebsiteRepository.findByCompanyId(idCompany);
        if (webSitesByCompany.isEmpty()) {
            throw new ListEmptyException("La compañia con id " + idCompany + " no tiene registrado ningun sitio web");
        }
        return webSitesByCompany;
    }

    @Override
    public WebSite save(CreateWebsiteDTO createWebsiteDTO) {
        return null;
    }

    @Override
    public boolean delete(Long idWebSite) {
        return false;
    }
}
