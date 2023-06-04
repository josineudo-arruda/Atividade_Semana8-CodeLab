package com.josineudo.Controller;

import com.josineudo.Model.Course;
import com.josineudo.Service.CourseService;
import com.josineudo.dto.CourseDTO;
import lombok.AllArgsConstructor;
import org.antlr.v4.runtime.misc.NotNull;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
@RequestMapping("/api/courses")
@AllArgsConstructor
public class CourseCotroller {
    @Autowired
    private final CourseService courseService;

    public CourseController(CourseService courseService) {this.courseService = courseService;}

    @GetMapping
    public List<CourseDTO> list() {
        return courseService.list();
    }

    @PostMapping
    @ResponseStatus(code = HttpStatus.CREATED)
    public CourseDTO create(@RequestBody @Valid @NotNull CourseDTO course) {
        return courseService.create(course);
    }

    @GetMapping("/{id}")
    public CourseDTO findById(@PathVariable  @NotNull @Positive Long id) {
        return courseService.findById(id);
    }

    @PutMapping("/{id}")
    public CourseDTO  update(@PathVariable  @NotNull @Positive Long id, @RequestBody @Valid @NotNull CourseDTO course) {
        return courseService.update(id, course);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(code = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable @NotNull @Positive Long id) {
        courseService.delete(id);
    }
}
