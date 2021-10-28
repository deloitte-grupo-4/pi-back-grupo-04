package br.com.piback.ecommerce.Controller;

import br.com.piback.ecommerce.Domain.User;
import br.com.piback.ecommerce.Domain.StatusResponse;
import br.com.piback.ecommerce.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@CrossOrigin("*")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User usuario){
        User user = userService.login(usuario);
        return new ResponseEntity<User>(user, HttpStatus.ACCEPTED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> getUserById(@PathVariable("id") Long id){
        User user = userService.getUserById(id);
        return new ResponseEntity<User>(user, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<User>> getUsers() {
        List<User> users = userService.getUsers();
        return new ResponseEntity(users, HttpStatus.OK);
    }

    @PostMapping
    public String insertUser(@RequestBody User user) throws Exception {
        var token = userService.insertUser(user);
        return  token;
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<StatusResponse> dropUser(@PathVariable("id") Long id){
        StatusResponse statusResponse = userService.deleteUser(id);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<StatusResponse> updateUser(@RequestBody User user){
        StatusResponse statusResponse = userService.updateUser(user);
        return new ResponseEntity<StatusResponse>(statusResponse, HttpStatus.OK);
    }
}
