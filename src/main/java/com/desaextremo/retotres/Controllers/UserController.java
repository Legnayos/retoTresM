package com.desaextremo.retotres.Controllers;

import com.desaextremo.retotres.Entities.User;
import com.desaextremo.retotres.Services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {
    @Autowired
    private UserService servicio;

    @GetMapping("/all")
    public List<User> getAll(){
        return servicio.getAll();
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable("id") Integer id){
        return servicio.getUser(id);
    }

    @GetMapping("/emailexist/{email}")
    public boolean existeEmail(@PathVariable("email") String email){
        return servicio.existeEmail(email);
    }

    @GetMapping("/{email}/{password}")
    public User autenticarUsuario(@PathVariable("email") String email, @PathVariable("password") String password){
        return servicio.autenticarUsuario(email,password);
    }

    @PostMapping("/new")
    @ResponseStatus(HttpStatus.CREATED)
    public User registrar(@RequestBody User user){
        return servicio.registrar(user);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public User actualizar(@RequestBody User user){
        return servicio.actualizar(user);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int id) {
        return servicio.delete(id);
    }
}
