package com.example.reportms.helpers;

import com.example.reportms.models.Company;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class ReportHelper {
    @Value("${report.template}")
    private String reportTemplate;

    public String readTemplate(Company company) {
        return this.reportTemplate
                .replace("{company}", company.getName())
                .replace("{foundation_date}", company.getFoundation_date().toString())
                .replace("{founder}", company.getFounder())
                .replace("{web_sites}", company.getWebSites().toString());
    }

    public List<String> getPlaceholdersFromTemplate(String template) {
        var split = template.split("\\{");
        return Arrays.stream(split)
                .filter(line -> !line.isEmpty())
                .map(line -> {
                    var index = line.indexOf("}");
                    return line.substring(0, index);
                })
                .toList();
    }
}
