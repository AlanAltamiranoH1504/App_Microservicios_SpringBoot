package com.example.reportms.services.interfaces;

public interface IReportService {
    public abstract String makeReport(Long idCompany);
    public abstract String saveReport(Long idCompany);
    public abstract void deleteReport(Long idCompany);
}
