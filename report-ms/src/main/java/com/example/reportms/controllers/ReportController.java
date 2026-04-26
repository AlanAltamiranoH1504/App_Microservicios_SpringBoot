package com.example.reportms.controllers;

import com.example.reportms.services.interfaces.IReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/v1/report")
public class ReportController {
    @Autowired
    private IReportService iReportService;

    @GetMapping("/{idCompany}")
    public ResponseEntity<?> getReport(@PathVariable Long idCompany) {
        Map<String, Object> json = new HashMap<>();
        json.put("report", iReportService.makeReport(idCompany));
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }

    @PostMapping("")
    public ResponseEntity<String> saveReport(@RequestBody String report) {
        String reportResult = this.iReportService.saveReport(report);
        return ResponseEntity.status(HttpStatus.OK).body(reportResult);
    }

    @DeleteMapping("/{nameReport}")
    public ResponseEntity<?> deleteReport(@PathVariable String nameReport) {
        Map<String, Object> json = new HashMap<>();
        iReportService.deleteReport(nameReport);
        json.put("messsage", "Report deleted successfully. Check data base");
        return ResponseEntity.status(HttpStatus.OK).body(json);
    }
}
