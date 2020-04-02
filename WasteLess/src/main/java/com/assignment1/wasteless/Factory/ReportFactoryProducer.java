package com.assignment1.wasteless.Factory;

import com.assignment1.wasteless.Presentation.Model.ReportType;

public class ReportFactoryProducer {
    public  ReportFactory getFactory(ReportType report){
        if(report == ReportType.WEEKLY)
            return new WeeklyReportFactory();
        else if(report == ReportType.MONTHLY){
            return new MonthlyReportFactory();
        }
        return null;
    }
}
