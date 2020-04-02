package com.assignment1.wasteless.Factory;

import com.assignment1.wasteless.Presentation.Model.Report;
import com.assignment1.wasteless.Presentation.Model.ReportGenerator;
import com.assignment1.wasteless.Presentation.Model.ReportType;

public abstract class ReportFactory {

    public abstract ReportGenerator getReport(ReportType reportType);
}
