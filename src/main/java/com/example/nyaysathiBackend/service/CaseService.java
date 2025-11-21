package com.example.nyaysathiBackend.service;

import org.springframework.stereotype.Service;
import com.example.nyaysathiBackend.repo.CaseRepository;
import com.example.nyaysathiBackend.model.CaseEntity;

import java.util.List;
import java.util.Optional;

@Service
public class CaseService {
    private final CaseRepository repo;
    public CaseService(CaseRepository repo){ this.repo = repo; }
    public List<CaseEntity> findAll(){ return repo.findAll(); }
    public Optional<CaseEntity> findById(Long id){ return repo.findById(id); }
    public CaseEntity save(CaseEntity c){ return repo.save(c); }
    public void deleteById(Long id){ repo.deleteById(id); }
    public List<CaseEntity> findByOwnerId(Long ownerId){ return repo.findByOwnerId(ownerId); }
    public List<CaseEntity> searchByTitle(String q){ return repo.findByTitleContainingIgnoreCase(q); }

    public CaseEntity update(Long id, CaseEntity incoming){
        var existing = repo.findById(id).orElseThrow();
        existing.setTitle(incoming.getTitle());
        existing.setDescription(incoming.getDescription());
        existing.setJurisdiction(incoming.getJurisdiction());
        existing.setStatus(incoming.getStatus());
        existing.setNextHearing(incoming.getNextHearing());
        existing.setLawyerId(incoming.getLawyerId());
        return repo.save(existing);
    }
}
