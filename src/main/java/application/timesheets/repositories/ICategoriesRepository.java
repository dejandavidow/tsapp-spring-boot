package application.timesheets.repositories;

import application.timesheets.models.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ICategoriesRepository extends JpaRepository<Category,Integer> {
     Page<Category> findByNameContaining(String name, Pageable pageable);
     Page<Category> findByNameStartsWith(Character character,Pageable pageable);
     Category findByName(String name);
}
