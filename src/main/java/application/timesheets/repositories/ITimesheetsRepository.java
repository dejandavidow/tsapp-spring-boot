package application.timesheets.repositories;

import application.timesheets.models.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ITimesheetsRepository extends JpaRepository<Timesheet,Integer> {
    List<Timesheet> findByCategoryId(int id);
}
