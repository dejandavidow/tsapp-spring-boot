package application.timesheets.api;

import application.timesheets.exceptions.NotFoundException;
import application.timesheets.models.Project;
import application.timesheets.repositories.IProjectRepository;
import application.timesheets.services.IProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Projects")
public class ProjectsController {
    @Autowired
    private IProjectService projectService;
    @GetMapping("{id}")
    public Project GetProjectById(@PathVariable int id)
    {
        return projectService.GetProjectById(id);
    }
    @GetMapping
    public List<Project> GetALlProjects(@RequestParam(defaultValue = "0") int page
            ,@RequestParam(defaultValue = "5") int size
            ,@RequestParam(required = false) String name, @RequestParam(required = false) Character letter)
    {
        return projectService.GetAllProject(page,size,name,letter);
    }
    @PostMapping
    public void AddProject(@RequestBody Project project)
    {
        projectService.AddProject(project);
    }
    @DeleteMapping("{id}")
    public void DeleteProject(@PathVariable int id)
    {
         projectService.DeleteProject(id);
    }
    @PutMapping("{id}")
    public void UpdateProject(@PathVariable int id,@RequestBody Project project)
    {
        projectService.UpdateProject(id,project);
    }
}
