package com.example.nyaysathiBackend.controller;

import org.springframework.web.bind.annotation.*;
import com.example.nyaysathiBackend.service.JudgementService;
import com.example.nyaysathiBackend.model.Judgement;
import java.util.List;

@RestController
@RequestMapping("/api/judgements")
public class JudgementController {

    private final JudgementService service;

    // Constructor Injection (Correct)
    public JudgementController(JudgementService service) {
        this.service = service;
    }

    @GetMapping
    public List<Judgement> all() {
        return service.findAll();
    }

    @GetMapping("/search")
    public List<Judgement> search(@RequestParam String q) {
        return service.search(q);
    }

    @PostMapping
    public Judgement create(@RequestBody Judgement j) {
        return service.save(j);
    }
}
