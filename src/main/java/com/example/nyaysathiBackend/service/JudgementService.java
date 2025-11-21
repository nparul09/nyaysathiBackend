package com.example.nyaysathiBackend.service;

import org.springframework.stereotype.Service;
import com.example.nyaysathiBackend.repo.JudgementRepository;
import com.example.nyaysathiBackend.model.Judgement;
import java.util.List;

@Service
public class JudgementService {
    private final JudgementRepository repo;
    public JudgementService(JudgementRepository repo){ this.repo = repo; }
    public List<Judgement> findAll(){ return repo.findAll(); }
    public List<Judgement> search(String q){ return repo.findByTextContainingIgnoreCase(q); }
    public List<Judgement> findByCaseId(Long id){ return repo.findByCaseId(id); }
    public Judgement save(Judgement j){ return repo.save(j); }
}
