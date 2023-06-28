package application.timesheets.services;

import application.timesheets.models.Timesheet;

import java.util.List;

public interface ITimesheetsService {
    void AddTimesheet(Timesheet timesheet);
    void UpdateTimesheet(int id,Timesheet timesheet);
    List<Timesheet> GetAllTimesheet(int page,int pageSize);
}
