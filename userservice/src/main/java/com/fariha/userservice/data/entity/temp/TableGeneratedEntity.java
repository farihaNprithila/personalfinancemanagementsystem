package com.fariha.userservice.data.entity.temp;

import jakarta.persistence.*;

@Entity
@Table(name = "table_generated")
public class TableGeneratedEntity {
    /*Hibernate: create table id_gen (gen_name varchar(255) not null, gen_val bigint, primary key (gen_name))
Hibernate: insert into id_gen(gen_name, gen_val) values ('table_generated',0)
Hibernate: create table table_generated (id bigint not null, name varchar(255) not null, primary key (id))*/

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table_gen")
    @TableGenerator(name = "table_gen", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    // Constructors, Getters, Setters

    public TableGeneratedEntity() {}

    public TableGeneratedEntity(String name) {
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
