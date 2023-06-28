package application.timesheets.services;

import application.timesheets.models.Project;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IProjectService {
    List<Project> GetAllProject(int page, int size, String name,Character letter);
    Project GetProjectById(int id);
    void DeleteProject(int id);
    void UpdateProject(int id,Project project);
    void AddProject(Project project);
}
