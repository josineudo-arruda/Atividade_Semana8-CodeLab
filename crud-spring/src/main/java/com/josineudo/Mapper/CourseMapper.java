package com.josineudo.Mapper;

import com.josineudo.Enums.Category;
import com.josineudo.Model.Course;
import com.josineudo.dto.CourseDTO;
import org.springframework.stereotype.Component;

@Component
public class CourseMapper {
    public CourseDTO toDTO(Course course) {
        if(course == null) {
            return null;
        }
        return new CourseDTO(course.getId(), course.getName(), course.getCategory().getValue());
    }

    public Course toEntity(CourseDTO courseDTO) {
        if(courseDTO == null) {
            return null;
        }
        Course course = new Course();
        if(courseDTO.id() != null) {
            course.setId(courseDTO.id());
        }
        course.setName(courseDTO.name());
        course.setCategory(convertCategoryValue(courseDTO.category()));

        return course;
    }

    public Category convertCategoryValue(String value) {
        if(value == null) {
            return null;
        }
        return switch (value) {
            case "Country" -> Category.COUNTRY;
            case "Pop" -> Category.POP;
            default -> throw new IllegalArgumentException("Categoria inválida: " + value);
        };
    }
}