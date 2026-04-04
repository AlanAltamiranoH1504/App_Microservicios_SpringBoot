package com.example.reportms.repositories;

import com.example.reportms.beans.LoadBalancerConfiguration;
import com.example.reportms.models.Company;
import org.springframework.cloud.loadbalancer.annotation.LoadBalancerClient;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;

@FeignClient(name = "companies-crud-ms")
@LoadBalancerClient(name = "companies-crud-ms", configuration = LoadBalancerConfiguration.class)
public interface ICompaniesRepository {
    @GetMapping("/api/v1/company/{idCompany}")
    public Optional<Company> getByIdCompany(@PathVariable Long idCompany);
}
