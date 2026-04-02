package com.example.companiescrudms.repositories;

import com.example.companiescrudms.models.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface ICompanyRepository extends JpaRepository<Company, Long> {
    @Query("SELECT c FROM Company c WHERE c.name = :name")
    public abstract Optional<Company> companyByName(@Param("name") String name);
}
