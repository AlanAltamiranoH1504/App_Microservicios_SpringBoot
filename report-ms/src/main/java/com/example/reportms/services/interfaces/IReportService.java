package com.example.reportms.services.interfaces;

public interface IReportService {
    public abstract String makeReport(Long idCompany);
    public abstract String saveReport(String nameReport);
    public abstract void deleteReport(String nameReport);
}
