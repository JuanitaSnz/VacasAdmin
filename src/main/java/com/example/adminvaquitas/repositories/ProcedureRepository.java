package com.example.adminvaquitas.repositories;

import com.example.adminvaquitas.models.ProcedureModel;
import org.springframework.stereotype.Repository;

@Repository
public interface ProcedureRepository extends AuditRepository<ProcedureModel> {
}
