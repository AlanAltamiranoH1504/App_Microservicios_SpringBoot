package com.example.companiescrudms.services;

import com.example.companiescrudms.exceptions.CreateEntityException;
import com.example.companiescrudms.exceptions.ListEmptyException;
import com.example.companiescrudms.exceptions.NotFoundEntityException;
import com.example.companiescrudms.models.Company;
import com.example.companiescrudms.models.dto.companie.CreateCompanyDTO;
import com.example.companiescrudms.repositories.ICompanyRepository;
import com.example.companiescrudms.services.interfaces.ICompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService implements ICompanyService {
    @Autowired
    private ICompanyRepository iCompanyRepository;

    @Override
    public List<Company> findAll() {
        List<Company> companyList = iCompanyRepository.findAll();

        if (companyList.isEmpty()) {
            throw new ListEmptyException("La lista de compañias se encuentra vacia");
        }
        return companyList;
    }

    @Override
    public Company findById(Long idCompany) {
        Optional<Company> company = iCompanyRepository.findById(idCompany);
        if (company.isPresent()) {
            return company.get();
        }
        throw new NotFoundEntityException("No existe una compañia con el id " + idCompany);
    }

    @Override
    @Transactional
    public Company save(CreateCompanyDTO createCompanyDTO) {
        Optional<Company> nameInUse = iCompanyRepository.companyByName(createCompanyDTO.getName());
        if (nameInUse.isPresent()) {
            throw new CreateEntityException("El nombre de la compañia ya se encuentra registrado");
        }
        Company companyToSave = new Company(
                createCompanyDTO.getName(),
                createCompanyDTO.getFounder(),
                createCompanyDTO.getLogo(),
                createCompanyDTO.getFoundation_date()
        );
        iCompanyRepository.save(companyToSave);
        return companyToSave;
    }

    @Override
    public boolean delete(Long idCompany) {
        return false;
    }
}
