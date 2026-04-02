package com.example.companiescrudms.repositories;

import com.example.companiescrudms.models.WebSite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IWebsiteRepository extends JpaRepository<WebSite, Long> {
    @Query("SELECT w FROM WebSite w WHERE w.company.id = :idCompany")
    public List<WebSite> findByCompanyId(@Param("idCompany") Long idCompany);
}
