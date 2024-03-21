package com.example.adminvaquitas.repositories;

import com.example.adminvaquitas.models.CowModel;
import org.springframework.stereotype.Repository;

@Repository
public interface CowRepository extends AuditRepository<CowModel> {
}
