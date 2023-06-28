package application.timesheets.api;

import application.timesheets.models.Timesheet;
import application.timesheets.services.ITimesheetsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Timesheets")
public class TimesheetsController {
    @Autowired
    private ITimesheetsService timesheetsService;
    @GetMapping
    public List<Timesheet> GetALl(@RequestParam(defaultValue = "0") int page,@RequestParam(defaultValue = "5") int size)
    {
        return timesheetsService.GetAllTimesheet(page, size);
    }
    @PostMapping
    public void AddTimesheet(@RequestBody Timesheet timesheet)
    {
        timesheetsService.AddTimesheet(timesheet);
    }

}
