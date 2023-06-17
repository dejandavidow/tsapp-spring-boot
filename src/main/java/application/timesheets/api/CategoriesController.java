package application.timesheets.api;

import application.timesheets.models.Category;
import application.timesheets.repositories.ICategoriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/Categories")
public class CategoriesController {
    @Autowired
    private ICategoriesRepository categoriesRepository;
    @GetMapping
    public List<Category> GetCategories()
    {
        return categoriesRepository.findAll();
    }
    @PostMapping
    public void AddCategory(@RequestBody Category category)
    {
        categoriesRepository.save(category);
    }
}
