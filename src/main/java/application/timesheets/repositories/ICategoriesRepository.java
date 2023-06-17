package application.timesheets.repositories;

import application.timesheets.models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICategoriesRepository extends JpaRepository<Category,Integer> {
}
