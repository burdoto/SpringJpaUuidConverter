package com.example.springjpauuidconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@Controller
public class TestController {
    @Autowired
    public TestRepository repo;

    public class UUIDs {
        public final UUID Id1;
        public final UUID Id2;

        public UUID getId1() {
            return Id1;
        }

        public UUID getId2() {
            return Id2;
        }

        public UUIDs(UUID id1, UUID id2) {
            Id1 = id1;
            Id2 = id2;
        }
    }

    @GetMapping("/createEntities")
    public UUIDs initEntities() {
        var ids = new UUIDs(UUID.randomUUID(), UUID.randomUUID());
        repo.save(new TestEntity(ids.Id1, ids.Id2, "apple"));
        return ids;
    }

    @GetMapping("/get1/{id}")
    public Optional<TestEntity> getById1(@PathVariable("id") UUID id) {
        return repo.findById(id);
    }

    @GetMapping("/get2/{id}")
    public Optional<TestEntity> getById2(@PathVariable("id") UUID id) {
        return repo.findByAltId(id);
    }
}
