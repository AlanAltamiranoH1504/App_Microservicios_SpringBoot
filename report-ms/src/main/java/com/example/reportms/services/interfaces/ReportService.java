package com.example.reportms.services.interfaces;

import com.example.reportms.repositories.ICompaniesRepository;
import com.netflix.discovery.EurekaClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ReportService implements IReportService {
    @Autowired
    private ICompaniesRepository iCompaniesRepository;

    @Override
    public String makeReport(Long idCompany) {
        return iCompaniesRepository.getByIdCompany(idCompany).orElseThrow().getName();
    }

    @Override
    public String saveReport(Long idCompany) {
        return "";
    }

    @Override
    public void deleteReport(Long idCompany) {

    }
}
