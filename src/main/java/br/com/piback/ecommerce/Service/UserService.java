package br.com.piback.ecommerce.Service;

import br.com.piback.ecommerce.Domain.StatusResponse;
import br.com.piback.ecommerce.Domain.User;
import br.com.piback.ecommerce.Repository.UserRepository;
import br.com.piback.ecommerce.Security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    JwtTokenProvider tokenProvider;

    public List<User> getUsers(){ return userRepository.findAll(); }


    //Constructor
    public UserService(UserRepository repository) {
        this.userRepository = repository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        var user = userRepository.findByUsername(username);
        if(user != null) {
            return user;
        }
        else {
            throw new UsernameNotFoundException("Username " + username + " not found");
        }
    }

    public User login(User usuario){
        User user = userRepository.findByEmail(usuario.getEmail()).orElseThrow(IllegalArgumentException::new);

        if(user.getPassword().equals(user.getPassword())) {
            return user;
        }
        else {
            throw new IllegalArgumentException();
        }
    }


    public String insertUser(User user) throws Exception {
        var token = tokenProvider.createToken(user.getUsername(),user.getRoles());
        userRepository.save(user);
        return token;
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
