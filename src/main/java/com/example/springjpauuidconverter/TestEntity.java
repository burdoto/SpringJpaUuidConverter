package com.example.springjpauuidconverter;

import com.fasterxml.jackson.annotation.JsonProperty;
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

    @JsonProperty
    public UUID getId() {
        return id;
    }

    @JsonProperty
    public UUID getId2() {
        return id2;
    }

    @JsonProperty
    public String getName() {
        return name;
    }

    public TestEntity() {
    }

    public TestEntity(UUID id, UUID id2, String name) {
        this.id = id;
        this.id2 = id2;
        this.name = name;
    }
}
