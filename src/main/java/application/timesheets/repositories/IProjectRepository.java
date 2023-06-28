package application.timesheets.repositories;

import application.timesheets.models.Client;
import application.timesheets.models.Project;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface IProjectRepository extends JpaRepository<Project,Integer> {
    List<Project> findByProjectNameContaining(String name, Pageable pageable);
    List<Project> findByProjectNameStartsWith(Character letter,Pageable pageable);
    Project findByProjectName(String name);
}
