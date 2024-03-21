package com.example.adminvaquitas.controllers;

import com.example.adminvaquitas.controllers.internal.CrudController;
import com.example.adminvaquitas.handlers.ResponseHandler;
import com.example.adminvaquitas.models.RegisterModel;
import com.example.adminvaquitas.repositories.RegisterRepository;
import com.example.adminvaquitas.service.internal.RegisterService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/register")
public class RegisterController extends CrudController<RegisterModel> {

    private final RegisterService registerService;

    protected RegisterController(RegisterRepository registerRepository){
        super(new RegisterService(registerRepository));
        this.registerService=new RegisterService(registerRepository);
    }

    @GetMapping("/getByCowId/{id}")
    public ResponseEntity<?> getByCowId(@PathVariable String id){
        return ResponseHandler.generateResponse("Data found", HttpStatus.OK,registerService.getByCowId(id));
    }
}
