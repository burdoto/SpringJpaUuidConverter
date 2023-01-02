package com.example.springjpauuidconverter;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;
import java.util.UUID;

public interface TestRepository extends CrudRepository<TestEntity, UUID> {
    @Query("select e from TestEntity e where e.id2 = ?1")
    Optional<TestEntity> findByAltId(UUID id);

    @Modifying(clearAutomatically = true)
    @Transactional
    @Query("update TestEntity e set e.name = ?2 where e.id = ?1")
    void setName(UUID id, String name);
}
