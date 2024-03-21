package com.example.adminvaquitas.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface AuditRepository<T> extends JpaRepository<T,String> {
}
