package com.assignment1.wasteless.Presentation.Controller;

import com.assignment1.wasteless.Data.Repository.ReportGeneratorRepository;
import com.assignment1.wasteless.Presentation.Model.ReportType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.security.Principal;

@Controller
public class ReportController {

    @Autowired
    private ReportGeneratorRepository reportGeneratorRepository;

    @RequestMapping("/groceryLists-user/reportGenerate")
    public String generateReport(@RequestParam(value = "type", required = false) String type, Model model, Principal principal) {
        ReportType reportType = ReportType.valueOf(type.toUpperCase());
        model.addAttribute("report", reportGeneratorRepository.getReport(reportType, principal.getName()));
        return "report-view";
    }


}
