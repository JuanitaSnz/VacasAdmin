package com.example.adminvaquitas.controllers;

import com.example.adminvaquitas.controllers.internal.CrudController;
import com.example.adminvaquitas.models.BirthModel;
import com.example.adminvaquitas.repositories.BirthRepository;
import com.example.adminvaquitas.service.internal.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/birth")
public class BirthController extends CrudController<BirthModel> {

    @Autowired
    protected BirthController(BirthRepository birthRepository){
        super(new CrudService<>(birthRepository));
    }

}
