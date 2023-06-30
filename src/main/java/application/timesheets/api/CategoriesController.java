package application.timesheets.api;

import application.timesheets.exceptions.EntityAlreadyExist;
import application.timesheets.exceptions.NotFoundException;
import application.timesheets.models.Category;
import application.timesheets.repositories.ICategoriesRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/Categories")
public class CategoriesController {
    @Autowired
    private ICategoriesRepository categoriesRepository;
    @GetMapping
    public List<Category> GetCategories(@RequestParam(required = false) String name,
                                           @RequestParam(required = false) Character letter,
                                           @RequestParam(defaultValue = "0",name = "page") int pageNumber,
                                           @RequestParam(defaultValue = "5",name = "size") int pageSize
                                        )
    {
        Pageable paged = PageRequest.of(pageNumber,pageSize, Sort.by("name"));
         List<Category> pagedCategories = new ArrayList<Category>();
         Page<Category> pageOfCategories;
        if(name != null)
        {
            pageOfCategories = categoriesRepository.findByNameContaining(name,paged);
        }
        else if(letter != null)
        {
            pageOfCategories = categoriesRepository.findByNameStartsWith(letter,paged);
        }
        else {
            pageOfCategories = categoriesRepository.findAll(paged);
        }
        pagedCategories = pageOfCategories.toList();
        return pagedCategories;
    }
    @PostMapping
    public void AddCategory(@RequestBody Category category)
    {
        Category categoryEx = categoriesRepository.findByName(category.getName());
        if(categoryEx == null) {
            categoriesRepository.save(category);
        }
        else
        {
            throw new EntityAlreadyExist("Category already exists!");
        }
    }
    @GetMapping(path = "{id}")
    public Category GetById(@PathVariable("id") int id)
    {
        Category category = categoriesRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found."));
        return category;
    }
    @DeleteMapping(path = "{id}")
    public void DeleteCategory(@PathVariable("id") int id)
    {
        Category category = categoriesRepository.findById(id).orElse(null);
        if(category == null)
        {
            throw  new NotFoundException("Category not found.");
        }
        categoriesRepository.delete(category);
    }
    @PutMapping("{id}")
    public void UpdateCategory(@PathVariable int id,@RequestBody Category categoryBody)
    {
        Category category = categoriesRepository.findById(id).orElseThrow(() -> new NotFoundException("Category not found."));
        category.setName(categoryBody.getName());
        categoriesRepository.save(category);
    }
}
