package com.cursos.api.spring_security_course.service;

import com.cursos.api.spring_security_course.dto.SaveCategory;
import com.cursos.api.spring_security_course.persistence.entity.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import java.util.Optional;

public interface CategoryService {
    Page<Category> findAll(Pageable pageable);
    Optional<Category> findOneById(Long categoryId);
    Category createOne(SaveCategory saveCategory);
    Category updateOneById(Long categoryId, SaveCategory saveCategory);
    Category disableOneById(Long categoryId);
}
