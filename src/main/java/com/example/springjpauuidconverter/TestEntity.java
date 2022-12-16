package com.example.springjpauuidconverter;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

import java.util.UUID;


@Entity
@Table(name = "uuid_conv")
public class TestEntity {
    @Id
    public UUID id;
    @Column
    public UUID id2;
    @Column
    public String name;

    public UUID getId() {
        return id;
    }

    public UUID getId2() {
        return id2;
    }

    public String getName() {
        return name;
    }

    public TestEntity() {
    }

    public TestEntity(String name) {
        this.id = UUID.randomUUID();
        this.id2 = UUID.randomUUID();
        this.name = name;
    }
}
