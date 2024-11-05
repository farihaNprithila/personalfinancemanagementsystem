package com.fariha.userservice.data.entity.temp;

import jakarta.persistence.*;

@Entity
@Table(name = "table_generated_2")
public class TableGeneratedEntity2 {

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "table_gen")
    @TableGenerator(name = "table_gen_2", table = "id_gen", pkColumnName = "gen_name", valueColumnName = "gen_val", allocationSize = 1)
    private Long id;

    @Column(nullable = false)
    private String name;

    // Constructors, Getters, Setters

    public TableGeneratedEntity2() {}

    public TableGeneratedEntity2(String name) {
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
