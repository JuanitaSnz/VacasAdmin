package com.example.adminvaquitas.models;


import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="cows")
public class CowModel extends  AuditModel{
    private String name;
    private Date entrance;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private String race;
}
