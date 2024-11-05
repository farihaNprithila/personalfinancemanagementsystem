package com.fariha.userservice.data.entity.temp;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String title;

    /*@ManyToMany(mappedBy = "books", fetch = FetchType.EAGER)*/
    /*@JsonIgnore*/
    @ManyToMany(mappedBy = "books", fetch = FetchType.LAZY)
    /* @JsonBackReference*/
    @JsonIgnoreProperties("books")
    private List<Author> authors;

}
