package com.example.nyaysathiBackend.controller;

import org.springframework.web.bind.annotation.*;
import com.example.nyaysathiBackend.service.CaseService;
import com.example.nyaysathiBackend.model.CaseEntity;
import java.security.Principal;
import java.util.List;

@RestController
@RequestMapping("/api/cases")
public class CaseController {
    private final CaseService service;
    public CaseController(CaseService service){ this.service = service; }

    @GetMapping
    public List<CaseEntity> all(){ return service.findAll(); }

    @GetMapping("/mine")
    public List<CaseEntity> mine(Principal p){
        return service.findAll();
    }

    @GetMapping("/{id}")
    public CaseEntity get(@PathVariable Long id){ return service.findById(id).orElseThrow(); }

    @PostMapping
    public CaseEntity create(@RequestBody CaseEntity c){ return service.save(c); }

    @PutMapping("/{id}")
    public CaseEntity update(@PathVariable Long id, @RequestBody CaseEntity c){ return service.update(id,c); }
}
