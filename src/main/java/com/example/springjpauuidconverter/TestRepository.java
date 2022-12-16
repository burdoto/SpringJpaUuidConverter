package com.example.springjpauuidconverter;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface TestRepository extends CrudRepository<TestEntity, UUID> {
    @Query("select e from TestEntity e where e.id2 = ?1")
    Optional<TestEntity> findByAltId(UUID id);
}
