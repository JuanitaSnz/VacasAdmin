package com.example.adminvaquitas.service.internal;

import com.example.adminvaquitas.models.RegisterModel;
import com.example.adminvaquitas.repositories.RegisterRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegisterService extends CrudService<RegisterModel> {

    private final RegisterRepository registerRepository;

    public RegisterService(RegisterRepository registerRepository){
        super(registerRepository);
        this.registerRepository=registerRepository;
    }

    public List<RegisterModel> getByCowId(String id){
        return registerRepository.findRegisterModelByCowModel_Id(id);
    }
}
