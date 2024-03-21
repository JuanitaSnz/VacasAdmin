package com.example.adminvaquitas.models;


import jakarta.persistence.*;
import lombok.*;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="registers",uniqueConstraints = {
        @UniqueConstraint(columnNames = {"cow_id","procedure_id"})
})
public class RegisterModel extends  AuditModel {

    private Date date;

    @ManyToOne
    @JoinColumn(name="cow_id")
    private CowModel cowModel;

    @ManyToOne
    @JoinColumn(name="procedure_id")
    private ProcedureModel procedureModel;
}
