package com.example.reportms.controllers;

import com.example.reportms.services.interfaces.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController {
    @Autowired
    private IReportService iReportService;

    @GetMapping("/{idCompany}")
    public ResponseEntity<Map<String, String>> getReport(@PathVariable Long idCompany) {
        var response = Map.of("report", iReportService.makeReport(idCompany));
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }
}
