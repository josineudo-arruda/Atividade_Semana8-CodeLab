package com.josineudo.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.josineudo.Model.Lesson;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;
import org.hibernate.validator.constraints.Length;

import java.util.List;


public record CourseDTO(
        @JsonProperty("_id") Long id,
        @NotBlank @NotNull @Length(min = 5, max = 100) String name,
        @NotNull @Length(max = 10) @Pattern(regexp = "Pop|Conutry") String category, List<LessonDTO> lessons) {
}