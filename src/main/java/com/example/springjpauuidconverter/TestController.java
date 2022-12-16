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

    @GetMapping("/createEntities")
    public String initEntities() {
        repo.save(new TestEntity("apple"));
        repo.save(new TestEntity("beanz"));
        return "redirect:https://google.com";
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
