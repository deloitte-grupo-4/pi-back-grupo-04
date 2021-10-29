package br.com.piback.ecommerce.Config;

import br.com.piback.ecommerce.Security.jwt.JwtConfigurer;
import br.com.piback.ecommerce.Security.jwt.JwtTokenProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private JwtTokenProvider tokenProvider;

    @Bean
    public BCryptPasswordEncoder passwordEncoder(){
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        return bCryptPasswordEncoder;
    }

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception{
        return super.authenticationManagerBean();
    }

    protected void configure(HttpSecurity http) throws Exception{
        http.httpBasic().disable() //para desabilitar a authentication basic

                .csrf().disable() //desabilita o suporte csrf , que é ligado por default (Cross-Site Request Forgery)
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS) //não irá guardar os estados
                //.and().cors()
                .and()
                .authorizeRequests() // para autorizar requisições

                /*
                .antMatchers("/user/**").permitAll()
                .antMatchers("/product/**").authenticated()
                .antMatchers("/order/**").denyAll()
                *
                * */
                .antMatchers("/user/**", "/product/**", "/order/**","swagger-ui.html").permitAll()
                .and()
                .apply(new JwtConfigurer(tokenProvider)); // Aplicar as configurações
    }

}
