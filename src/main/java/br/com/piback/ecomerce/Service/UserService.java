package br.com.piback.ecomerce.Service;

import br.com.piback.ecomerce.Domain.StatusResponse;
import br.com.piback.ecomerce.Domain.User;
import br.com.piback.ecomerce.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private UserRepository userRepository;

    public List<User> getUsers(){ return userRepository.findAll(); }

    public StatusResponse insertUser(User user){
        userRepository.save(user);
        return new StatusResponse("Usuario cadastrado com sucesso", "sucesso");
    }

    public StatusResponse updateUser(User newUser){
        userRepository.save(newUser);
        return new StatusResponse("Usuario atualizado com sucesso", "sucesso");
    }
    public StatusResponse deleteUser(Long id){
        userRepository.deleteById(id);
        return new StatusResponse("Usuario removido com sucesso", "sucesso");
    }

    public User getUserById(Long id) {
        return userRepository.findById(id).get();
    }

}
