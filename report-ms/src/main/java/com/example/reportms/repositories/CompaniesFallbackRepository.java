package com.example.reportms.repositories;

import com.example.reportms.models.Company;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Repository;
import org.springframework.web.reactive.function.client.WebClient;

@Repository
public class CompaniesFallbackRepository {
    private final WebClient webClient;
    private final String urlEndpointFallback;

    public CompaniesFallbackRepository(WebClient webClient, @Value("${fallback.uri}") String urlEndpointFallback) {
        this.webClient = webClient;
        this.urlEndpointFallback = urlEndpointFallback;
    }

    public Company getCompanyFallback(Long idCompany) {
        return this.webClient
                .get()
                .uri(urlEndpointFallback, idCompany)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Company.class)
                .block();
    }
}
