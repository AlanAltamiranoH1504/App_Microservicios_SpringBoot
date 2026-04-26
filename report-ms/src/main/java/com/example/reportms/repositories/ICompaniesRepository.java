package com.example.reportms.repositories;

import com.example.reportms.beans.LoadBalancerConfiguration;
import com.example.reportms.models.Company;
import com.example.reportms.models.dto.company.CreateCompanyDTO;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@FeignClient(name = "companies-crud-ms", path = "companies-crud")
@LoadBalancerClient(name = "companies-crud-ms", configuration = LoadBalancerConfiguration.class)
public interface ICompaniesRepository {

    @GetMapping("/api/v1/company")
    public List<Company> getCompanies();

    @GetMapping("/api/v1/company/{idCompany}")
    public Optional<Company> getByIdCompany(@PathVariable Long idCompany);

    @PostMapping("/api/v1/company")
    public Company postByName(@RequestBody CreateCompanyDTO createCompanyDTO);

    @DeleteMapping("/api/v1/company/{idCompany}")
    public void deleteCompanyById(@PathVariable Long idCompany);
}
