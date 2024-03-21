package com.example.adminvaquitas.repositories;

import com.example.adminvaquitas.models.RegisterModel;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RegisterRepository extends AuditRepository<RegisterModel> {
    List<RegisterModel> findRegisterModelByCowModel_Id(String cow_id);
}
