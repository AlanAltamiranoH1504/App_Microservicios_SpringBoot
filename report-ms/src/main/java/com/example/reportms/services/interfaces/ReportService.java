package com.example.reportms.services.interfaces;

import com.example.reportms.helpers.ReportHelper;
import com.example.reportms.models.Company;
import com.example.reportms.models.WebSite;
import com.example.reportms.models.dto.company.CreateCompanyDTO;
import com.example.reportms.models.dto.company.website.CreateWebsiteDTO;
import com.example.reportms.repositories.CompaniesFallbackRepository;
import com.example.reportms.repositories.ICompaniesRepository;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.circuitbreaker.resilience4j.Resilience4JCircuitBreakerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

@Service
public class ReportService implements IReportService {
    @Autowired
    private ICompaniesRepository iCompaniesRepository;
    @Autowired
    private ReportHelper reportHelper;
    @Autowired
    private CompaniesFallbackRepository companiesFallbackRepository;
    @Autowired
    private Resilience4JCircuitBreakerFactory circuitBreakerFactory;

    @Override
    public String makeReport(Long idCompany) {
        var circuitBreaker = circuitBreakerFactory.create("companies-circuit-breaker");
        return circuitBreaker.run(
                () -> this.makeReportMain(idCompany),
                throwable -> this.makeReportFallback(idCompany)
        );
//        Company company = iCompaniesRepository.getByIdCompany(idCompany).orElseThrow();
//        return reportHelper.readTemplate(company);
    }

    @Override
    public String saveReport(String nameReport) {
        List<String> template = reportHelper.getPlaceholdersFromTemplate(nameReport);
        String[] webSites = template.get(3).split(",");
        List<CreateWebsiteDTO> websiteDTOS = Arrays.stream(webSites)
                .map(String::trim)
                .map(String::toUpperCase)
                .map(webSite -> {
                    return new CreateWebsiteDTO(webSite, "Description", "SERVICES");
                }).toList();

        iCompaniesRepository.postByName(new CreateCompanyDTO(
                template.get(0),
                template.get(2),
                "Logo prueba",
                LocalDate.parse(template.get(1)),
                websiteDTOS
        ));
        return "Checar en base de datos";
    }

    @Override
    public void deleteReport(String nameReport) {
        List<Company> companies = iCompaniesRepository.getCompanies();
        companies.stream()
                .filter(company -> company.getName().equals(nameReport))
                .findFirst()
                .ifPresent(company -> iCompaniesRepository.deleteCompanyById(company.getId()));
    }

    // ! METODOS DE CIRCUIT BREAKER
    private String makeReportMain(Long idCompany) {
        Company company = iCompaniesRepository.getByIdCompany(idCompany).orElseThrow();
        return reportHelper.readTemplate(company);
    }

    private String makeReportFallback(Long idCompany) {
        Company company = companiesFallbackRepository.getCompanyFallback(idCompany);
        return reportHelper.readTemplate(company);
    }
}
