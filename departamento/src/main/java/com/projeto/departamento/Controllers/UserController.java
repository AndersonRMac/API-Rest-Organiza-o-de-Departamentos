package com.projeto.departamento.Controllers;

import com.projeto.departamento.entities.User;
import com.projeto.departamento.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")  //endereço principal de onde vai estar os métodos GET, POST e etc.
public class UserController {

    @Autowired //mecanismo de injeção de dependencias do repository
    private UserRepository dao;

    @GetMapping //Endpoint para listar todos os usuarios
    public List<User>findAll(){
        List<User> result = dao.findAll();
        return result;
    }

    @GetMapping( "/{id}") //EndPoint que retorna um usuário só
    public User findById(@PathVariable Long id){  //para que o numero digitado na url correponda ao parâmetro da função
        User result = dao.findById(id).get();
        return result;
    }

    //Endpoint para salvar um novo usuario
    @PostMapping
    public User saveUser(@RequestBody User user){ //passa um objeto do tipo User. (O corpo da requisição) - por isso a anotation requestbody
        User result = dao.save(user);
        return result;
    }
}
