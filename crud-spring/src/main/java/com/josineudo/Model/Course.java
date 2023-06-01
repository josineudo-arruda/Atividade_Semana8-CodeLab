package com.josineudo.Model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(length = 200, nullable = false)
    private String nome;

    @Column(length = 20, nullable = false)
    private String category;


    public Long getId() {return id;}
    public void setId(Long id) {this.id = id;}
    public String getCategory() {return category;}
    public void setCategory(String category) {this.category = category;}
    public String getNome() {return nome;}
    public void setNome(String nome) {this.nome = nome;}
}
