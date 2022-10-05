package com.tgi_confession.tgi_confession_db.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.tgi_confession.tgi_confession_db.dto.CategoryDto;
import com.tgi_confession.tgi_confession_db.model.Category;
import com.tgi_confession.tgi_confession_db.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping(method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_INSERT')")
    public ResponseEntity<List<Category>> getAllCategory() {
        return new ResponseEntity<>(categoryService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "getById", method = RequestMethod.GET)
    @PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_INSERT')")
    public ResponseEntity<Category> getCateById(@RequestParam String id) {
        if (categoryService.getById(id) == null) {
            return new ResponseEntity<>(null, HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(categoryService.getById(id), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_INSERT')")
    public ResponseEntity<Category> createCategory(@RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.create(categoryDto), HttpStatus.OK);
    }

    @RequestMapping(value = "update", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_INSERT')")
    public ResponseEntity<Category> updateCategory(@RequestParam String id, @RequestBody CategoryDto categoryDto) {
        return new ResponseEntity<>(categoryService.update(id, categoryDto), HttpStatus.OK);
    }

    @RequestMapping(value = "delete", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasAuthority('PRIVILEGE_ADMIN_INSERT')")
    public ResponseEntity<Category> deleteCategory(@RequestParam String id) {
        return new ResponseEntity<>(categoryService.delete(id), HttpStatus.OK);
    }

}
