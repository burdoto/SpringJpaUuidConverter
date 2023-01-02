package com.example.springjpauuidconverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.Optional;
import java.util.UUID;

@Controller
public class TestController {
    @Autowired
    public TestRepository repo;

    @GetMapping("/createEntities")
    public String initEntities() {
        repo.save(new TestEntity(UUID.randomUUID(), UUID.randomUUID(), "apple"));
        repo.save(new TestEntity(UUID.randomUUID(), UUID.randomUUID(), "beanz"));
        return "redirect:https://google.com";
    }

    @GetMapping("/get1/{id}")
    public Optional<TestEntity> getById1(@PathVariable("id") UUID id) {
        Optional<TestEntity> byId = repo.findById(id);
        return byId;
    }

    @GetMapping(value = "/get2/{id}", produces = {"application/json"})
    public TestEntity getById2(@PathVariable("id") UUID id) {
        Optional<TestEntity> byAltId = repo.findByAltId(id);
        return byAltId.get();
    }
}
