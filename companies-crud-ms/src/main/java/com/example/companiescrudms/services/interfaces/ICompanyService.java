package com.example.companiescrudms.services.interfaces;

import com.example.companiescrudms.models.Company;
import com.example.companiescrudms.models.dto.companie.CreateCompanyDTO;

import java.util.List;

public interface ICompanyService {
    public abstract List<Company> findAll();
    public abstract Company findById(Long idCompany);
    public abstract Company save(CreateCompanyDTO createCompanyDTO);
    public abstract boolean delete(Long idCompany);
}
