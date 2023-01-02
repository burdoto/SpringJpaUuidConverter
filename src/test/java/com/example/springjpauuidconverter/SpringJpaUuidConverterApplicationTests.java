package com.example.springjpauuidconverter;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;

import java.util.Optional;
import java.util.UUID;

@SpringBootTest
class SpringJpaUuidConverterApplicationTests {
    @Autowired
    private TestRepository repo;

    @Test
    void testUuidConvert() {
        UUID id1 = UUID.randomUUID();
        UUID id2 = UUID.randomUUID();

        repo.save(new TestEntity(id1, id2, "beanz"));

        System.out.println("Entities:");
        for (TestEntity entity : repo.findAll()) {
            System.out.println("entity = " + entity);
        }

        System.out.println("By ID " + id1);
        Optional<TestEntity> byId = repo.findById(id1);
        System.out.println("repo.findById(id1) = " + byId);
        System.out.println("By Alt ID " + id2);
        Optional<TestEntity> byAltId = repo.findByAltId(id2);
        System.out.println("repo.findByAltId(id2) = " + byAltId);

        Assert.isTrue(byId.isPresent(), "Not found by primary ID");
        Assert.isTrue(byAltId.isPresent(), "Not found by secondary ID");
    }
}
