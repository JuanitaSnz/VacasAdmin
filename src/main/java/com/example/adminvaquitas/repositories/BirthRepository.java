package com.example.adminvaquitas.repositories;

import com.example.adminvaquitas.models.BirthModel;
import org.springframework.stereotype.Repository;

@Repository
public interface BirthRepository extends AuditRepository<BirthModel> {
}
