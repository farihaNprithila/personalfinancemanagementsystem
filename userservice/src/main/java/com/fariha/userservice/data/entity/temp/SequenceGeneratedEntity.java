package com.fariha.userservice.data.entity.temp;

import jakarta.persistence.*;

@Entity
@Table(name = "sequence_generated")
public class SequenceGeneratedEntity {

    /*Hibernate: create table sequence_generated (id bigint not null, name varchar(255) not null, primary key (id))
Hibernate: create sequence sequence_name start with 1 increment by 1*/

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "sequence_gen")
    @SequenceGenerator(name = "sequence_gen", sequenceName = "sequence_name", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    // Constructors, Getters, Setters

    public SequenceGeneratedEntity() {}

    public SequenceGeneratedEntity(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
