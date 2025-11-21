package com.example.nyaysathiBackend.repo;

import com.example.nyaysathiBackend.model.Judgement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface JudgementRepository extends JpaRepository<Judgement, Long> {
    List<Judgement> findByTextContainingIgnoreCase(String q);
    List<Judgement> findByCaseId(Long caseId);
}
