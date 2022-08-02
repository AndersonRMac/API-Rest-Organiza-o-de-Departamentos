package com.projeto.departamento.Controllers;

import com.projeto.departamento.entities.User;
import com.projeto.departamento.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/users")  //endereço principal de onde vai estar os métodos GET, POST e etc.
public class UserController {

    @Autowired //mecanismo de injeção de dependencias do repository
    private UserRepository dao;

    @GetMapping
    public List<User>findAll(){
        List<User> result = dao.findAll();
        return result;
    }
}
