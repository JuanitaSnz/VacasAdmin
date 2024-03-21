package com.example.adminvaquitas.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="births",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"cow_id"})
})
public class BirthModel extends AuditModel {
    private Date dateBirth;
    private int count;
    @Enumerated(EnumType.STRING)
    private Sex sex;
    private String name;

    @ManyToOne
    @JoinColumn(name="cow_id")
    private CowModel cowModel;


}
