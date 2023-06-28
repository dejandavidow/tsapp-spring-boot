package application.timesheets.services;

import application.timesheets.exceptions.EntityAlreadyExist;
import application.timesheets.exceptions.NotFoundException;
import application.timesheets.models.Client;
import application.timesheets.models.Project;
import application.timesheets.repositories.IProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProjectsService implements IProjectService{
    @Autowired
    private IProjectRepository projectRepository;
    @Override
    public List<Project> GetAllProject(int pageNumber,int pageSize,String name,Character letter) {
        List<Project> pagedProjects = new ArrayList<>();
        Pageable page = PageRequest.of(pageNumber,pageSize, Sort.by("projectName"));
        if(name != null)
        {
            pagedProjects = projectRepository.findByProjectNameContaining(name,page);
        }
        else if(letter != null){
            pagedProjects = projectRepository.findByProjectNameStartsWith(letter,page);
        }
        else {
            pagedProjects = projectRepository.findAll(page).toList();
        }
        return  pagedProjects;
    }

    @Override
    public Project GetProjectById(int id) {
        return projectRepository.findById(id).orElseThrow(() -> new NotFoundException("Project doesn't exists."));
    }

    @Override
    public void DeleteProject(int id) {
        projectRepository.findById(id).orElseThrow(() -> new NotFoundException("Project doesn't exists."));
        projectRepository.deleteById(id);
    }

    @Override
    public void UpdateProject(int id, Project project) {
        Project projectUpdate = projectRepository.findById(id).orElseThrow(() -> new NotFoundException("Project doesn't exists."));
        projectUpdate.setProjectName(project.getProjectName());
        projectUpdate.setDescription(project.getDescription());
        projectUpdate.setArchive(project.getArchive());
        projectUpdate.setStatus(project.getStatus());
        projectRepository.save(projectUpdate);
    }

    @Override
    public void AddProject(Project project) {
        Project projectExist = projectRepository.findByProjectName(project.getProjectName());
        if(projectExist == null)
        {
            projectRepository.save(project);
        }
        else
        {
            throw new EntityAlreadyExist("Project already exists.");
        }
    }
}
