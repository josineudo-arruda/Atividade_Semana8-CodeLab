package com.josineudo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
@Entity
public class Course {
    @Id
    @JsonProperty("_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank
    @NotNull
    @Length(min = 5, max = 100)
    @Column(length = 100, nullable = false)
    private String name;

    @NotBlank
    @Length(max = 10)
    @Pattern(regexp = "Pop|Country")
    private String category;


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}
    public String getName() {return name;}
    public void setNome(String name) {this.name = name;}
}
