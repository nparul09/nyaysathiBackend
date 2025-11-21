package com.example.nyaysathiBackend.controller;

import com.example.nyaysathiBackend.model.CaseEntity;
import com.example.nyaysathiBackend.model.Judgement;
import org.springframework.web.bind.annotation.*;
import com.example.nyaysathiBackend.service.CaseService;
import com.example.nyaysathiBackend.service.JudgementService;

@RestController
@RequestMapping("/api/search")
public class SearchController {

    private final CaseService caseService;
    private final JudgementService judgementService;

    public SearchController(CaseService cs, JudgementService js){ this.caseService = cs; this.judgementService = js; }

    @GetMapping("/cases")
    public java.util.List<CaseEntity> searchCases(@RequestParam String q){
        return caseService.searchByTitle(q);
    }

    @GetMapping("/judgements")
    public java.util.List<Judgement> searchJudgements(@RequestParam String q){
        return judgementService.search(q);
    }
}
