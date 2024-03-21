package com.example.adminvaquitas.controllers;

import com.example.adminvaquitas.controllers.internal.CrudController;
import com.example.adminvaquitas.models.CowModel;
import com.example.adminvaquitas.repositories.CowRepository;
import com.example.adminvaquitas.service.internal.CrudService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cow")
public class CowController extends CrudController<CowModel> {
    @Autowired
    protected CowController(CowRepository cowRepository){super(new CrudService<>(cowRepository));}
}
