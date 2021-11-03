package br.com.piback.ecommerce.Controller;

import br.com.piback.ecommerce.Domain.Credentials;
import br.com.piback.ecommerce.Domain.User;
import br.com.piback.ecommerce.Repository.UserRepository;
import br.com.piback.ecommerce.Security.jwt.JwtTokenProvider;
import br.com.piback.ecommerce.Service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.http.ResponseEntity.ok;

@Api(value = "Auth EndPoint",tags = {"Auth Endpoint"})
@RestController
@RequestMapping("/auth")
public class AuthController {
    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    JwtTokenProvider tokenProvider;

    @Autowired
    UserRepository repository;

    @Autowired
    UserService userService;

    @ApiOperation("Cria um usuario com login e senha")
    @PostMapping(value = "/criarUser",produces = "application/json", consumes = "application/json")
    public ResponseEntity criarUser(@RequestBody User data) throws Exception {
        try {
            var username = data.getUsername(); //armazena Username e password
            var password = data.getPassword();

            BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(16); //encrypta a senha
            String result = bCryptPasswordEncoder.encode(password);

            var user = repository.findByUsername(username); //busca o user no repository
            var token = "";

            //se o username for encontrado no repositório:
            if(user != null) {
                throw new UsernameNotFoundException("Username "+ username + " already exists."); // trata a exceção
            }else {
                data.setPassword(result);
                token = userService.insertUser(data);

                Map<Object, Object> model = new HashMap<>(); //Montando um obj para ser retornado
                model.put("username", username); //assimilando o username
                model.put("token", token); //assimilando o token
                return ok(model); //retorna o model de retorno
            }
        } catch (Exception e){
            throw new Exception();
        }
    }

    @ApiOperation(value = "Logar e receber um token")
    @PostMapping(value = "/logar",produces = "application/json", consumes = "application/json")
    public ResponseEntity logar(@RequestBody Credentials data) throws Exception {
        try {
            var username = data.getUsername(); //armazena Username e password do VO
            var password = data.getPassword();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password)); //realiza a authenticação
            var user = repository.findByUsername(username); //busca o user no repository
            var token = "";
            //se o user for encontrado no repositório:
            if(user != null) {
                token = tokenProvider.createToken(username, user.getRoles()); //cria o token do user com as permissoes dele
            } else {
                throw new UsernameNotFoundException("Username "+ username + " not found."); // trata a exceção
            }
            Map<Object, Object> model = new HashMap<>(); //Montando um obj para ser retornado
            model.put("userId", user.getId());
            model.put("username", username); //assimilando o username
            model.put("token", token); //assimilando o token
            return ok(model); //retorna o model de retorno
        } catch (Exception e){
            throw new Exception();
        }
    }

}
