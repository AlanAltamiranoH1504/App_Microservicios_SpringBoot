package com.example.companiescrudfallback.models.controllers;

import com.example.companiescrudfallback.models.Company;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/api/v1/company")
public class CompanyController {
    private static final Company COMPANY_DEFAULT = new Company(
            "Compañia Default",
            "Fudandor Default",
            "Logo Default",
            LocalDate.now()
    );

    @GetMapping("/{idCompany}")
    public ResponseEntity<?> getCompany(@PathVariable Long idCompany) {
        return ResponseEntity.status(HttpStatus.OK).body(COMPANY_DEFAULT);
    }
}
