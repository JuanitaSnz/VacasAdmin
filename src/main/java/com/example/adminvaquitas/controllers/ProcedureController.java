package com.example.adminvaquitas.controllers;

import com.example.adminvaquitas.controllers.internal.CrudController;
import com.example.adminvaquitas.models.ProcedureModel;
import com.example.adminvaquitas.repositories.ProcedureRepository;
import com.example.adminvaquitas.service.internal.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/procedure")
public class ProcedureController extends CrudController<ProcedureModel> {

    @Autowired
    protected ProcedureController(ProcedureRepository procedureRepository){
        super(new CrudService<>(procedureRepository));
    }
}
