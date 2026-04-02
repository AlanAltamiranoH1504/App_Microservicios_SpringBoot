package com.example.companiescrudms.controllers;

import com.example.companiescrudms.models.dto.companie.CreateCompanyDTO;
import com.example.companiescrudms.models.dto.companie.UpdateCompanyDTO;
import com.example.companiescrudms.services.interfaces.ICompanyService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
    @Autowired
    private ICompanyService iCompanyService;

    @GetMapping("")
    public ResponseEntity<?> listCompanies() {
        return ResponseEntity.status(HttpStatus.OK).body(iCompanyService.findAll());
    }

    @PostMapping("")
    public ResponseEntity<?> saveCompany(@Valid @RequestBody CreateCompanyDTO createCompanyDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(iCompanyService.save(createCompanyDTO));
    }

    @GetMapping("/{idCompany}")
    public ResponseEntity<?> getCompany(@PathVariable Long idCompany) {
        return ResponseEntity.status(HttpStatus.OK).body(iCompanyService.findById(idCompany));
    }

    @DeleteMapping("/{idCompany}")
    public ResponseEntity<?> deleteCompany(@PathVariable Long idCompany) {
        return ResponseEntity.status(HttpStatus.OK).body(iCompanyService.delete(idCompany));
    }

    @PutMapping("")
    public ResponseEntity<?> updateCompany(@Valid @RequestBody UpdateCompanyDTO updateCompanyDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(iCompanyService.update(updateCompanyDTO));
    }
}
