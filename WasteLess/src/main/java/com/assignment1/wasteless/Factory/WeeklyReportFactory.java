package com.assignment1.wasteless.Factory;

import com.assignment1.wasteless.Presentation.Model.Report;
import com.assignment1.wasteless.Presentation.Model.ReportGenerator;
import com.assignment1.wasteless.Presentation.Model.ReportType;
import com.assignment1.wasteless.Presentation.Model.WeeklyReport;

public class WeeklyReportFactory extends ReportFactory {

    @Override
    public ReportGenerator getReport(ReportType reportType) {
        return new WeeklyReport();
    }
}
