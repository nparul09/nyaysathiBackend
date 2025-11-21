package com.example.nyaysathiBackend.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.nyaysathiBackend.model.CaseEntity;
import java.util.List;
public interface CaseRepository extends JpaRepository<CaseEntity, Long> {
    List<CaseEntity> findByOwnerId(Long ownerId);
    List<CaseEntity> findByTitleContainingIgnoreCase(String q);
}
