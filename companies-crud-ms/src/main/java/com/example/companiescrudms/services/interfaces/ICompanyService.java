package com.example.companiescrudms.services.interfaces;

import com.example.companiescrudms.models.Company;
import com.example.companiescrudms.models.dto.companie.CreateCompanyDTO;
import com.example.companiescrudms.models.dto.companie.UpdateCompanyDTO;

import java.util.List;

public interface ICompanyService {
    public abstract List<Company> findAll();
    public abstract Company findById(Long idCompany);
    public abstract Company save(CreateCompanyDTO createCompanyDTO);
    public abstract Company update(UpdateCompanyDTO updateCompanyDTO);
    public abstract boolean delete(Long idCompany);
}
