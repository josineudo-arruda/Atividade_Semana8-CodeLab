package com.josineudo.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Course {
    @Id
    @JsonProperty("_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 200, nullable = false)
    private String name;

    @Column(length = 20, nullable = false)
    private String category;


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}
    public String getName() {return name;}
    public void setNome(String name) {this.name = name;}
}
