package application.timesheets.services;

import application.timesheets.exceptions.EntityAlreadyExist;
import application.timesheets.models.Timesheet;
import application.timesheets.repositories.ITimesheetsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class TimesheetsService implements ITimesheetsService{
    @Autowired
    private ITimesheetsRepository timesheetsRepository;
    @Autowired
    private ModelMapper mapper;
    @Override
    public void AddTimesheet(Timesheet timesheet)
    {
        Timesheet ts = timesheetsRepository.findById(timesheet.getId()).orElse(null);
        if(ts == null)
        timesheetsRepository.save(timesheet);
        else
            throw  new EntityAlreadyExist("Timesheet already exists");
    }

    @Override
    public void UpdateTimesheet(int id, Timesheet timesheet) {

    }

    public List<Timesheet> GetAllTimesheet(int pageNumber,int pageSize) {
        Pageable page = PageRequest.of(pageNumber,pageSize, Sort.by("date"));
        return  timesheetsRepository.findAll(page).toList();
    }
}
